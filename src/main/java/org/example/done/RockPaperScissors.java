package org.example.done;

/**
 * Hello world!
 *
 */

import java.util.Scanner;


public class RockPaperScissors {

    public static void main(String[] argv) throws Exception {
        String line;
        Scanner sc = new Scanner(System.in);
        String playerLine=sc.nextLine();
        String[] player= playerLine.split("");

        String winner=player[0];
        for(int i=0;i<player.length-1;i++){
            winner=winnerOf(player[i],player[i+1]);
        }
        System.out.println(winner);
    }

    private static String winnerOf(String left, String right) {
        if(left.equals(right))
            return left;
        if("P".equals(left)&& "F".equals(right))
            return "F";
        if("P".equals(left)&& "C".equals(right))
            return "P";
        if("F".equals(left)&& "P".equals(right))
            return "F";
        if("F".equals(left) && "C".equals(right))
            return "C";
        if("C".equals(left) && "P".equals(right))
            return "P";
        if("C".equals(left) && "F".equals(right))
            return "C";
        return "KO";
    }
}

