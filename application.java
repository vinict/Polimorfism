package Polimorfism;

import Polimorfism.entities.Employee;
import Polimorfism.entities.OutsourcedEmployee;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Locale;


public class application {
    public static void main(){
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of employees: ");
                
        int n = sc.nextInt();
        
        List <Employee> list = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            System.out.printf("Employee %d data: ", i+1);
            System.out.printf("\nOutsourced (y/n)? ");
            char verify = sc.next().charAt(0);
            sc.next();
            System.out.print("\nName: ");
            String name = sc.nextLine();
            System.out.print("\nHours: ");
            int hours = sc.nextInt();
            System.out.print("\nValue per hour: ");
            double valuePerHour = sc.nextDouble();
            if(verify == 'y'){
                System.out.print("\nAdditional charge: ");
                double additionalCharge = sc.nextDouble();
                list.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
            }else{        
                list.add(new Employee(name, hours, valuePerHour));
            }
        }
        
        System.out.println();
        System.out.println("Payment: ");
        for(Employee employee : list ){
            System.out.printf("%s - $ %.2f", employee.getName(), employee.payment());
        }
        
        sc.close();
    }
}
