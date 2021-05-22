package Test;

import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class aaaaaaaaaaaaa {
    public static void main(String[] args) throws ParseException {
//        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("hh:mm a");
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(now);
//        System.out.println(dtf1.format(now));


        String pattern = "MM-dd-yyyy hh:mm a ";
        LocalDateTime now = LocalDateTime.now();
        String d1 = now.format(DateTimeFormatter.ofPattern(pattern));
        System.out.println(d1);


        int time1inMinutes = ((Integer.parseInt(d1.substring(11, 13)))*60) + Integer.parseInt(d1.substring(14, 16));
        if ((d1.substring(17, 19).equalsIgnoreCase("PM"))) {
            String hour1 = String.valueOf(Integer.parseInt(d1.substring(11, 13)) + 12);
            d1 = d1.replace(d1.substring(11, 13), hour1);
            System.out.println("d1" + d1);
            time1inMinutes = ((Integer.parseInt(d1.substring(11, 13))) * 60 )+ (Integer.parseInt(d1.substring(14, 16)));
            System.out.println("time1 : "+time1inMinutes);
        }


        String ticketCreatedDate = "05/17/2021 09:48am";
        String d2 = ticketCreatedDate.replaceAll("/", "-").replace("pm", " PM").replace("am", " AM");
        System.out.println(d2);
        int time2inMinutes = (Integer.parseInt(d2.substring(11, 13))*60 )+ (Integer.parseInt(d2.substring(14, 16)));
        if ((d2.substring(17, 19).equalsIgnoreCase("PM"))) {
            String hour1 = String.valueOf(Integer.parseInt(d2.substring(11, 13)) + 12);
            d2 = d2.replace(d2.substring(11, 13), hour1);
            time2inMinutes = ((Integer.parseInt(d2.substring(11, 13)))*60)+ (Integer.parseInt(d2.substring(14, 16)));

        }


        boolean isMoreThan2Hours = false;
        if (Integer.parseInt(d1.substring(3, 5)) > Integer.parseInt(d2.substring(3, 5))) {
            isMoreThan2Hours = true;
        } else {
            if ((time1inMinutes - time2inMinutes) > 120) {
                isMoreThan2Hours = true;
            }

        }
        System.out.println(isMoreThan2Hours);
        System.out.println("time1 : "+time1inMinutes);
        System.out.println("time2 : "+time2inMinutes);
    }

}