package com.invcd;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CustomerManagementPractice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean transactions = false;
        TreeSet<Integer> customerIDs = new TreeSet<>(Comparator.naturalOrder());
        Set<Integer> customerWithTransactions = new HashSet<>();
        int count = 1;

        while(scanner.hasNext()) {
            String str = scanner.nextLine();
            if(count>2) {
                if (str.contains(" ")) {
                    StringBuffer sbr = new StringBuffer(str);
                    String str1 = sbr.substring(str.indexOf(" ") + 1, str.length()).toString();
                    customerWithTransactions.add(Integer.parseInt(str1));
                } else {
                    customerIDs.add(Integer.parseInt(str));
                }
            }
            count++;
        }
        StringBuffer stringBuffer = new StringBuffer();
        customerIDs.stream().forEach(id->{
            if(!customerWithTransactions.contains(id)){
                stringBuffer.append(id+" ");
            }
        });
        if(!stringBuffer.toString().isEmpty()) {
            System.out.println(stringBuffer.toString());
        }else{
            System.out.println("Empty list");
        }
    }
}
