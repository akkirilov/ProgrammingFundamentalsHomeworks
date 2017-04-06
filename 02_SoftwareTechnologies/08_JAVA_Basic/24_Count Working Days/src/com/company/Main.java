package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        Scanner scanner = new Scanner(System.in);

        LocalDate startDate = LocalDate.from(dtf.parse(scanner.nextLine()));
        LocalDate endDate = LocalDate.from(dtf.parse(scanner.nextLine()));
        endDate = endDate.plusDays(1);

        ArrayList<LocalDate> holidays = new ArrayList<>();
        holidays.add(LocalDate.from(dtf.parse("01-01-2000")));
        holidays.add(LocalDate.from(dtf.parse("03-03-2000")));
        holidays.add(LocalDate.from(dtf.parse("01-05-2000")));
        holidays.add(LocalDate.from(dtf.parse("06-05-2000")));
        holidays.add(LocalDate.from(dtf.parse("24-05-2000")));
        holidays.add(LocalDate.from(dtf.parse("06-09-2000")));
        holidays.add(LocalDate.from(dtf.parse("22-09-2000")));
        holidays.add(LocalDate.from(dtf.parse("01-11-2000")));
        holidays.add(LocalDate.from(dtf.parse("24-12-2000")));
        holidays.add(LocalDate.from(dtf.parse("25-12-2000")));
        holidays.add(LocalDate.from(dtf.parse("26-12-2000")));

        int workingDays = 0;
        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)){
            if(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY){
                continue;
            }

            for(int i = 0; i < holidays.size();i++){
                if(holidays.get(i).getDayOfMonth() == date.getDayOfMonth()){
                    if(holidays.get(i).getMonthValue() == date.getMonthValue()){
                        workingDays--;
                        break;
                    }
                }
            }

            workingDays++;
        }

        System.out.println(workingDays);
    }
}