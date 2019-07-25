package com.tavisca.workshops.MerchantGalaxy;

import com.tavisca.workshops.MerchantGalaxy.Parsers.Parser;

import java.util.Scanner;

public class Merchant {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String languageStatement = null;
        System.out.println("\n\n\n\nHello, I am a Merchant.\n I am eager to help you." +
                " \n I am Listening to Your queries and facts (enter \'quit\' to exit) ....");

        Parser parser = Parser.getInstance();
        while (!(languageStatement = scanner.nextLine()).equals("quit")) {
            try {
                Object[] results = parser.Parse(languageStatement);
                for (Object result : results) {
                    System.out.print(result + " ");
                }
                System.out.println();
            } catch (Exception e) {
                System.out.println("I have no idea what you are talking about");
            }
        }
    }
}
