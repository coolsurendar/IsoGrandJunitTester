package org.example.done;

/**
 * Hello world!
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankEmployee {
    public static void main( String[] argv ) throws Exception {
        String  line;
        Scanner sc = new Scanner(System.in);
        int numberOfDays= Integer.parseInt(sc.nextLine());
        double accountBalance= Integer.parseInt(sc.nextLine());
        List<Double> transactions = new ArrayList<>();

        for (int i = 0; i < numberOfDays; i++) {
            transactions.add(Double.parseDouble(sc.nextLine()));
        }

        Double oldInterest= Math.abs(calculateOldInterest(accountBalance,numberOfDays,transactions));

        Double newInterest= Math.abs(calculateNewInterest(accountBalance,numberOfDays,transactions));

        System.out.println(Math.round(newInterest-oldInterest));

        //System.out.println("17");
        /* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
    }

    private static Double calculateNewInterest(double accountBalance, int numberOfDays, List<Double> transactions) {
        double currentAccountBalance=accountBalance;
        double fine = 0;
        int numberOfMinusDays=0;
        for (int i = 0; i < numberOfDays; i++) {
            numberOfMinusDays = calculateSequentialMinusDays(currentAccountBalance, numberOfMinusDays);
            currentAccountBalance=currentAccountBalance+transactions.get(i);
            if((numberOfMinusDays>=1 && numberOfMinusDays<=3 )&& currentAccountBalance<0) {
                fine = fine + ((20 * currentAccountBalance) / 100);
            }
            if((numberOfMinusDays>3)&& currentAccountBalance<0) {
                fine = fine + ((30 * currentAccountBalance) / 100);
            }
        }
        return fine;
    }

    private static int calculateSequentialMinusDays(double currentAccountBalance, int numberOfMinusDays) {
        if(currentAccountBalance <0)
            numberOfMinusDays++;
        else
            numberOfMinusDays =0;
        return numberOfMinusDays;
    }

    private static Double calculateOldInterest(double accountBalance, int numberOfDays, List<Double> transactions) {
      double currentAccountBalance=accountBalance;
      double fine = 0;
        int numberOfMinusDays=0;
        for (int i = 0; i < numberOfDays; i++) {
            currentAccountBalance=currentAccountBalance+transactions.get(i);
            numberOfMinusDays = calculateSequentialMinusDays(currentAccountBalance, numberOfMinusDays);
            if(numberOfMinusDays>=3 && currentAccountBalance<0) {
                fine = fine + ((10 * currentAccountBalance) / 100);
            }
        }
      return fine;
    }
}
