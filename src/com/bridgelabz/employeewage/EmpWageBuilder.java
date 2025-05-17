package com.bridgelabz.employeewage;

import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;

// Interface
interface EmployeeWageInterface {
    void addCompany(String company, int wagePerHour, int workingDays, int maxHours);
    void computeWages();
    int getTotalWage(String companyName);
}

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

    ArrayList<Integer> dailyWages;

    // Constructor to initialize company details
    public CompanyEmpWage(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHours = maxWorkingHours;
        this.dailyWages = new ArrayList<>(); // Initialize the list
    }

    public void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }

    public void addDailyWage(int wage) {
        dailyWages.add(wage); // ✅ Add wage to the list
    }

    @Override
    public String toString() {
        return "Total Wage for Company " + companyName + " is ₹" + totalWage;
    }

    public void printDailyWages() {
        System.out.println("Daily Wages for " + companyName + ":");
        for (int i = 0; i < dailyWages.size(); i++) {
            System.out.println("Day " + (i + 1) + ": ₹" + dailyWages.get(i));
        }
    }
}

public class EmpWageBuilder implements EmployeeWageInterface{

    private final ArrayList<CompanyEmpWage> companyList = new ArrayList<>();
    private final HashMap<String, Integer> companyToTotalWageMap = new HashMap<>(); // Add this

    int index=0;
    // Add a company to the array
    public void addCompany(String name, int wagePerHour, int workingDays, int workingHours) {
        companyList.add(new CompanyEmpWage(name, wagePerHour, workingDays, workingHours));
    }

    // Compute wages for all companies
    public void computeWages() {
        for (CompanyEmpWage company : companyList) {
            int totalWage = computeEmployeeWage(company);
            company.setTotalWage(totalWage);
            companyToTotalWageMap.put(company.companyName, totalWage);
            System.out.println(company);
            company.printDailyWages();
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
                  //  System.out.println("Day " + day + ": Absent");
                    break;
                case 1:
                   // System.out.println("Day " + day + ": Part-Time");
                    empHours = CompanyEmpWage.PART_TIME_HOURS;
                    break;
                case 2:
                  //  System.out.println("Day " + day + ": Full-Time");
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
            company.addDailyWage(dailyWage);

            if (empHours != 0) {
                totalDaysWorked++;
                totalHoursWorked += empHours;
            }

            //System.out.println("Wage for Day " + day + ": ₹" + dailyWage);
           // System.out.println("Total Hours so far: " + totalHoursWorked + "\n");
            day++;
        }
        return totalWage;
    }

    public int getTotalWage(String companyName) {
        Integer totalWage = companyToTotalWageMap.get(companyName);
        if (totalWage != null) {
            return totalWage;
        } else {
            System.out.println("Company not found: " + companyName);
            return -1;
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program on master branch");
        EmployeeWageInterface empWageBuilder = new EmpWageBuilder();

        empWageBuilder.addCompany("TCS", 20, 20, 100);
        empWageBuilder.addCompany("Infosys", 22, 22, 120);
        empWageBuilder.addCompany("Wipro", 18, 25, 90);

        empWageBuilder.computeWages();

        // Query total wage by company
        System.out.println("\nQueried Total Wage:");
        System.out.println("TCS: ₹" + empWageBuilder.getTotalWage("TCS"));
        System.out.println("Infosys: ₹" + empWageBuilder.getTotalWage("Infosys"));
        System.out.println("Wipro: ₹" + empWageBuilder.getTotalWage("Wipro"));

    }
}
