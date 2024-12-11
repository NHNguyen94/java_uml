package org.bank.datamodel;

import java.util.ArrayList;

public class Customer {
    private String id;
    private String customerName;
    private String homeAddress;
    private ArrayList<Account> accountList;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        if (customerName == null) {
            return;
        }
        this.customerName = customerName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        if (homeAddress == null) {
            return;
        }
        this.homeAddress = homeAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", customerName='" + customerName + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", accountList=" + accountList +
                '}';
    }
}
