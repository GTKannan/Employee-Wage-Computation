package com.bridgelabz.employeewage;

import java.util.Random;

public class EmployeeWageComputation {

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program on master branch");

        // Create Random object
        Random random = new Random();

        // 0 for Absent, 1 for Present
        int attendance = random.nextInt(2); // generates 0 or 1

        // Check and print attendance status
        if (attendance == 1) {
            System.out.println("Employee is Present");
        } else {
            System.out.println("Employee is Absent");
        }

        // Employee wage calculation-UC2
        int wagePerHour = 20;
        int fullDayHours = 8;

        // Calculate daily wage
        int dailyWage = wagePerHour * fullDayHours;

        // Display the result
        System.out.println("Daily Employee Wage: ₹" + dailyWage);
    }
}
