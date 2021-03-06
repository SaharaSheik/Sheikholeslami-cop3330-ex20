package base;

/*

 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Sahar Sheikholeslami

 */

/*
Exercise 20 - Multistate Sales Tax Calculator
More complex programs may have decisions nested in other decisions,
so that when one decision is made, additional decisions must be made.

Create a tax calculator that handles multiple states and multiple counties within each state.
The program prompts the user for the order amount and the state where the order will be shipped.

Wisconsin residents must be changed 5% sales tax with an additional county-level charge.
For Wisconsin residents, prompt for the county of residence.
For Eau Claire county residents, add an additional 0.005 tax.
For Dunn county residents, add an additional 0.004 tax.

Illinois residents must be charged 8% sales tax with no additional county-level charge.

All other states are not charged tax.
The program then displays the tax and the total for Wisconsin and Illinois residents
but just the total for everyone else.

Example Output
What is the order amount? 10
What state do you live in? Wisconsin
What county do you live in? Dane

The tax is $0.50.
The total is $10.50.

Constraints
Ensure that all money is rounded up to the nearest cent.
Use a single output statement at the end of the program to display the program results.
Challenges
Add support for your state and county.
Allow the user to enter a state abbreviation and county name in upper, lower, or mixed case.
Allow the user to also enter the state’s full name in upper, lower, or mixed case.
Implement the program using data structures to avoid nested if statements.
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        final double wiTax = 0.05;
        final double eauTax = 0.005;
        final double daneTax = 0.004;
        final double ilTax = 0.08;

        Scanner input = new Scanner(System.in);

        //String output ="";
        String state, county;
        double tax=0, taxAmount=0;

        System.out.print("What is the order amount? ");
        double orderAmount = Double.parseDouble(input.nextLine());

        System.out.print("What state do you live in? ");
        state = input.nextLine();;

        state = state.toUpperCase();

        if(state.equals("WI") || state.equals("IL") || state.equals("WISCONSIN") || state.equals("ILLINOIS")){

            if(state.equals("WI") || state.equals("WISCONSIN")){

                tax = wiTax;
                System.out.print("What county do you live in? ");
                county = input.nextLine();
                county = county.toUpperCase();

                    if(county.equals("DANE"))
                        tax +=daneTax;
                    else
                        tax +=eauTax;

                taxAmount = orderAmount*tax;

                orderAmount += (tax*orderAmount);

            }else{
                tax=ilTax;
                taxAmount = orderAmount*tax;
                orderAmount += (tax*orderAmount);
            }

        }

        taxAmount = Math.round(taxAmount*10)/10.0;
        orderAmount = Math.round(orderAmount*10)/10.0;



       // taxAmount = (double) (Math.round(taxAmount*100))/100.0;
        //orderAmount=(double) (Math.round(orderAmount*100))/100.0;



        System.out.println(((tax>0)?"The tax is $" + taxAmount +"\n":"") + "The total is $" + orderAmount + ".");

    }
}

