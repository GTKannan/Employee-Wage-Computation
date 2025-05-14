package com.bridgelabz.employeewage;

import java.util.Random;

public class EmployeeWageComputation {

    public static void main(String[] args) {

        int wagePerHour = 20;
        int fullTimeHours = 8;
        int partTimeHours = 4;
        int empHours = 0;
        int workingDays = 20;
        int totalWage=0;

        System.out.println("Welcome to Employee Wage Computation Program on master branch");

        // Create Random object
        Random random = new Random();
        for (int day = 1; day <= workingDays; day++) {
            int empStatus = random.nextInt(3);  // 0=Absent, 1=Part-time, 2=Full-time

            switch (empStatus) {
                case 0:
                    System.out.println("Day " + day + ": Absent");
                    break;
                case 1:
                    System.out.println("Day " + day + ": Part-Time");
                    empHours = partTimeHours;
                    break;
                case 2:
                    System.out.println("Day " + day + ": Full-Time");
                    empHours = fullTimeHours;
                    break;
            }

            // Calculate daily wage
            int dailyWage = wagePerHour * empHours;
            System.out.println("Wage for Day " + day + ": ₹" + dailyWage);
            totalWage += dailyWage;
        }
        // Display the result
        System.out.println("\nTotal Monthly Wage: ₹" + totalWage);

    }
}
