package com.brlab.employeewage;

import java.util.Scanner;

public class EmployeeWageComputation {

    public static void main(String[] args) {
        System.out.println("Welcome to EmployeeWage Computation Program on master branch");


        Scanner sc = new Scanner(System.in);
        System.out.println("enter here\n1 - Present \n2 - Absent");
        int n = sc.nextInt();
        if(n == 1)
            System.out.println("employee is present,....");
        else
            System.out.println("employee not present,....");
    }
}
