package org.bank.datamodel;

public class SavingAcount extends Account {
    private Double interestRate;

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    private Customer customer;

    @Override
    public String toString() {
        return "SavingAcount{" +
                "interestRate=" + interestRate +
                ", customer=" + customer +
                '}';
    }
}
