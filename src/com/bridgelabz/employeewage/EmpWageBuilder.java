package com.bridgelabz.employeewage;

import java.util.Random;

class CompanyEmpWage {

    // Class-level constants
    static final int FULL_TIME_HOURS = 8;
    static final int PART_TIME_HOURS = 4;

    // Instance variables for each company
    String companyName;
    int wagePerHour;
    int maxWorkingDays;
    int maxWorkingHours;
    int totalWage;

    // Constructor to initialize company details
    public CompanyEmpWage(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHours = maxWorkingHours;
    }

    public void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }

    public String toString() {
        return "Total Wage for Company " + companyName + " is ₹" + totalWage;
    }
}

public class EmpWageBuilder {

    CompanyEmpWage[] companies;
    int index = 0;

    // Constructor to initialize company array
    public EmpWageBuilder(int companyCount) {
        companies = new CompanyEmpWage[companyCount];
    }

    // Add a company to the array
    public void addCompany(String name, int wagePerHour, int workingDays, int workingHours) {
        companies[index++] = new CompanyEmpWage(name, wagePerHour, workingDays, workingHours);
    }

    // Compute wages for all companies
    public void computeWages() {
        for (int i = 0; i < index; i++) {
            CompanyEmpWage company = companies[i];
            int totalWage = computeEmployeeWage(company);
            company.setTotalWage(totalWage);
            System.out.println(company);
        }
    }

    // Core computation logic for one company
    private int computeEmployeeWage(CompanyEmpWage company) {
        int totalHoursWorked = 0;
        int totalDaysWorked = 0;
        int day = 1;
        int totalWage = 0;
        // Create Random object
        Random random = new Random();
        System.out.println("\nComputing wages for company: " + company.companyName);
        while (totalDaysWorked <= company.maxWorkingDays && totalHoursWorked <= company.maxWorkingHours && day <= company.maxWorkingDays) {
            int empHours = 0;
            int empStatus = random.nextInt(3);  // 0=Absent, 1=Part-time, 2=Full-time
            switch (empStatus) {
                case 0:
                    System.out.println("Day " + day + ": Absent");
                    break;
                case 1:
                    System.out.println("Day " + day + ": Part-Time");
                    empHours = CompanyEmpWage.PART_TIME_HOURS;
                    break;
                case 2:
                    System.out.println("Day " + day + ": Full-Time");
                    empHours = CompanyEmpWage.FULL_TIME_HOURS;
                    break;
            }

            // Ensure we don't exceed 100 hours
            if (totalHoursWorked + empHours > company.maxWorkingHours) {
                empHours = company.maxWorkingHours - totalHoursWorked; // Adjust last day's hours
            }

            // Calculate daily wage
            int dailyWage = company.wagePerHour * empHours;
            totalWage += dailyWage;

            if (empHours != 0) {
                totalDaysWorked++;
                totalHoursWorked += empHours;
            }

            System.out.println("Wage for Day " + day + ": ₹" + dailyWage);
            System.out.println("Total Hours so far: " + totalHoursWorked + "\n");
            day++;
        }
        return totalWage;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program on master branch");
        EmpWageBuilder empWageBuilder = new EmpWageBuilder(3); // Can handle up to 3 companies

        empWageBuilder.addCompany("TCS", 20, 20, 100);
        empWageBuilder.addCompany("Infosys", 22, 22, 120);
        empWageBuilder.addCompany("Wipro", 18, 25, 90);

        empWageBuilder.computeWages();

    }
}
