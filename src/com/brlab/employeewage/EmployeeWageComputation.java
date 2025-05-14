package com.brlab.employeewage;

import java.util.Random;

public class EmployeeWageComputation {

    // Class-level constants
    static final int WAGE_PER_HOUR = 20;
    static final int FULL_TIME_HOURS = 8;
    static final int PART_TIME_HOURS = 4;
    static final int MAX_WORKING_DAYS = 20;
    static final int MAX_WORKING_HOURS = 100;

    // Class-level variables
    static int totalWage = 0;
    static int totalHoursWorked = 0;
    static int totalDaysWorked = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program on master branch");
        computeEmployeeWage();
        displaySummary();
    }

    // Class method to compute employee wage
    public static void computeEmployeeWage() {
        // Create Random object
        Random random = new Random();
        int day = 1;
        while (totalDaysWorked <= MAX_WORKING_DAYS && totalHoursWorked <= MAX_WORKING_HOURS && day <= MAX_WORKING_DAYS) {
            int empHours = 0;
            int empStatus = random.nextInt(3);  // 0=Absent, 1=Part-time, 2=Full-time
            switch (empStatus) {
                case 0:
                    System.out.println("Day " + day + ": Absent");
                    break;
                case 1:
                    System.out.println("Day " + day + ": Part-Time");
                    empHours = PART_TIME_HOURS;
                    break;
                case 2:
                    System.out.println("Day " + day + ": Full-Time");
                    empHours = FULL_TIME_HOURS;
                    break;
            }

            // Ensure we don't exceed 100 hours
            if (totalHoursWorked + empHours > MAX_WORKING_HOURS) {
                empHours = MAX_WORKING_HOURS - totalHoursWorked; // Adjust last day's hours
            }

            // Calculate daily wage
            int dailyWage = WAGE_PER_HOUR * empHours;
            totalWage += dailyWage;

            if (empHours != 0) {
                totalDaysWorked++;
                totalHoursWorked += empHours;
            }

            System.out.println("Wage for Day " + day + ": ₹" + dailyWage);
            System.out.println("Total Hours so far: " + totalHoursWorked + "\n");
            day++;
        }
    }

    // Class method to display final summary
    public static void displaySummary() {
        // Display the result
        System.out.println("Total Working Days: " + totalDaysWorked);
        System.out.println("Total Working Hours: " + totalHoursWorked);
        System.out.println("Total Monthly Wage: ₹" + totalWage);
    }
}
