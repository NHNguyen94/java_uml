package org.bank.datamodel;

public class Account {
    private String id;
    private String userName;
    private String passWord;
    private Double balance;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
//        if (balance < 0) {
//            return;
//        }
        this.balance = balance;
    }
}
