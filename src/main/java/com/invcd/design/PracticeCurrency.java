package com.invcd.design;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class PracticeCurrency {

    public static void getFormattedAmount(double payment){
        Locale indiaLocale = new Locale("en", "IN");
        List<Locale> localeList = List.of(Locale.US, indiaLocale, Locale.CHINA, Locale.FRANCE);
        List<String> countries = List.of("US: ","India: ", "China: ", "France: ");
        AtomicInteger ind = new AtomicInteger(0);
        localeList.forEach(locale -> {
            NumberFormat format = NumberFormat.getCurrencyInstance(locale);
            System.out.println(countries.get(ind.get())+format.format(payment));
            ind.getAndIncrement();
        });
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        getFormattedAmount(payment);
    }
}
