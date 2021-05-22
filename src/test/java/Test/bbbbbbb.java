package Test;

import java.text.*;
import java.time.*;
import java.util.*;

public class bbbbbbb {
    public static void main(String[] args) throws ParseException {
        String sDate1="05/18/2021 03:26 pm";
        Date date1=new SimpleDateFormat("MM/dd/yyyy hh:mm a").parse(sDate1);
        System.out.println(sDate1+"\t"+date1);

        long ticketCreatedDate=date1.getTime();

        LocalDateTime now = LocalDateTime.now();
        String date_now=now.toString();
        System.out.println("dat = " + date_now);

        String todayDate=date_now.substring(5,7)+"/"+date_now.substring(8,10)+"/"+date_now.substring(0,4)+" "+date_now.substring(11,16);

        Date date2=new SimpleDateFormat("MM/dd/yyyy HH:mm").parse(todayDate);
        System.out.println("date2 = " + date2);
        System.out.println("date1 = " + date1);


        long today_date=date2.getTime();

        boolean isMoreThan2Hours = false;
        if (((today_date-ticketCreatedDate)/60000)>120){
            isMoreThan2Hours=true;

        }
        System.out.println("ticketCreatedDate = " + ticketCreatedDate);
        System.out.println("today_date = " + today_date);
        System.out.println("isMoreThan2Hours = " + isMoreThan2Hours);
        System.out.println("today_date-ticketCreatedDate = " + (today_date - ticketCreatedDate)/60000);



    }

}
