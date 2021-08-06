package com.mphasis.payroll;

public class Finance{

    public void processSalary(Employee employee){
        if(employee != null) {
            employee.netPay();
            if (employee instanceof Permanent) {
                Permanent permanent = (Permanent) employee; //downcasting full restoration of permanent class
                permanent.transportation();
            }
        }
    }
}
