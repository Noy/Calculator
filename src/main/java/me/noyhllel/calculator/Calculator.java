package me.noyhllel.calculator;


import java.util.Scanner;

/**
 * Created by Noy on 22/02/2015.
 */
class Calculator {

    public static void main(String[] args) {
        while(true) {
            try {
                doCalculations();
            }catch (RuntimeException e) {
                print("Thanks for using the calc!");
                break;
            }
        }
    }

    private static void doCalculations() {
        Scanner scan = new Scanner(System.in);
        print("Please type a calculation!");
        String s = scan.next();
        if (s.equalsIgnoreCase("exit")) throw new RuntimeException();
        Calculations c = null;
        String[] n = null;
        for (Calculations calcs : Calculations.values()) {
            if (s.contains(calcs.key)) {
                n = s.split("\\" + calcs.key);
                if (n.length != 2) {
                    n = null;
                    break;
                }
                c = calcs;
            }
        }
        if (c == null || n == null) {
            print("Specify an operation!");
            doCalculations();
            return;
        }
        try {
            Double x = Double.valueOf(n[0]);
            Double y = Double.valueOf(n[1]);
            print(s + " = " + c.delegate.performCalculations(x, y) + "!");
        }catch (NumberFormatException e) {
            print("You did not type a number!");
        }
    }

    @SafeVarargs
    private static <T> void print(T... args) {
        for (T t : args) {
            System.out.println(t);
        }
    }
}