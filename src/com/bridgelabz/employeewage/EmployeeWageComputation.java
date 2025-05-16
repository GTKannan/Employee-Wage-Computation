package com.bridgelabz.employeewage;

import java.util.Random;

public class EmployeeWageComputation {

    // Class-level constants
    static final int FULL_TIME_HOURS = 8;
    static final int PART_TIME_HOURS = 4;

    // Method to compute wage for a company using parameters
    public static void computeEmployeeWage(String company, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        int totalWage = 0;
        int totalHoursWorked = 0;
        int totalDaysWorked = 0;
        int day = 1;
        // Create Random object
        Random random = new Random();
        System.out.println("Computing wages for company: " + company);
        while (totalDaysWorked <= maxWorkingDays && totalHoursWorked <= maxWorkingHours && day <= maxWorkingDays) {
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
            if (totalHoursWorked + empHours > maxWorkingHours) {
                empHours = maxWorkingHours - totalHoursWorked; // Adjust last day's hours
            }

            // Calculate daily wage
            int dailyWage = wagePerHour * empHours;
            totalWage += dailyWage;

            if (empHours != 0) {
                totalDaysWorked++;
                totalHoursWorked += empHours;
            }

            System.out.println("Wage for Day " + day + ": ₹" + dailyWage);
            System.out.println("Total Hours so far: " + totalHoursWorked + "\n");
            day++;
        }

        displaySummary(company,totalDaysWorked,totalHoursWorked,totalWage);
    }

    // Class method to display final summary
    public static void displaySummary(String company,int totalDaysWorked,int totalHoursWorked,int totalWage) {
        // Display the result
        System.out.println("Summary for " + company + ":");
        System.out.println("Total Working Days: " + totalDaysWorked);
        System.out.println("Total Working Hours: " + totalHoursWorked);
        System.out.println("Total Monthly Wage: ₹" + totalWage);
        System.out.println("-----------------------------------------------------\n");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program on master branch");
        computeEmployeeWage("TCS", 20, 20, 100);
        computeEmployeeWage("Infosys", 22, 22, 120);
        computeEmployeeWage("Wipro", 18, 25, 90);
    }
}
