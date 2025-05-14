package com.brlab.employeewage;

import java.util.Random;

public class EmployeeWageComputation {

    public static void main(String[] args) {

        int wagePerHour = 20;
        int fullTimeHours = 8;
        int partTimeHours = 4;
        int totalWage=0;
        int maxWorkingDays = 20;
        int maxWorkingHours = 100;
        int totalHoursWorked=0;
        int totalDaysWorked=0;
        int day=1;

        System.out.println("Welcome to Employee Wage Computation Program on master branch");

        // Create Random object
        Random random = new Random();
        while (totalDaysWorked <= maxWorkingDays && totalHoursWorked <= maxWorkingHours && day <= maxWorkingDays) {
            int empHours = 0;
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
            totalWage += dailyWage;

            if(empHours!=0){
                totalDaysWorked++;
                totalHoursWorked+=empHours;
            }

            System.out.println("Wage for Day " + day + ": ₹" + dailyWage);
            System.out.println("Total Hours so far: " + totalHoursWorked + "\n");
            day++;
        }

        // Display the result
        System.out.println("Total Working Days: " + totalDaysWorked);
        System.out.println("Total Working Hours: " + totalHoursWorked);
        System.out.println("Total Monthly Wage: ₹" + totalWage);
    }
}
