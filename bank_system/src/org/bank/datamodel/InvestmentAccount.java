package org.bank.datamodel;

import java.util.ArrayList;

public class InvestmentAccount extends Account {
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    private Customer customer;

    @Override
    public String toString() {
        return "InvestmentAccount{" +
                "customer=" + customer +
                '}';
    }
}
