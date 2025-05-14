package com.bridgelabz.employeewage;

import java.util.Random;

public class EmployeeWageComputation {

    public static void main(String[] args) {

        int wagePerHour = 20;
        int fullTimeHours = 8;
        int partTimeHours = 4;
        int empHours = 0;

        System.out.println("Welcome to Employee Wage Computation Program on master branch");

        // Create Random object
        Random random = new Random();
        int empStatus = random.nextInt(3);  // 0=Absent, 1=Part-time, 2=Full-time

        if (empStatus == 0) {
            System.out.println("Employee is Absent.");
            empHours = 0;
        } else if (empStatus == 1) {
            System.out.println("Employee is Part-Time.");
            empHours = partTimeHours;
        } else if (empStatus == 2) {
            System.out.println("Employee is Full-Time.");
            empHours = fullTimeHours;
        }

        // Calculate daily wage
        int dailyWage = wagePerHour * empHours;

        // Display the result
        System.out.println("Daily Employee Wage: ₹" + dailyWage);
    }
}
