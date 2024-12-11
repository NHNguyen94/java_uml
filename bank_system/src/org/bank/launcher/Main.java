package org.bank.launcher;

import org.bank.datamodel.Customer;
import org.bank.datamodel.InvestmentAccount;
import org.bank.datamodel.SavingAcount;
import org.bank.datamodel.Stock;
import org.bank.repository.InvestmentAccountRepository;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setCustomerName("nguyen");
        customer.setHomeAddress("home");
        String customerName = customer.getCustomerName();
        System.out.println("hello " + customerName);

//        SavingAcount account = new SavingAcount();
//        account.setCustomer(customer);
//        account.setInterestRate(0.025);
//        account.setBalance(2000.0);
//        System.out.println("Create account " + account + " with current balance " + account.getBalance());
//        Double newBalance = account.getBalance() + account.getBalance() * account.getInterestRate();
//        account.setBalance(newBalance);
//        System.out.println("New balance " + account.getBalance());

        Stock goldStock = new Stock("GOLD", 100.0);
        Stock appleStock = new Stock("Apple", 6.7);

        InvestmentAccount investmentAccount = new InvestmentAccount();
        investmentAccount.setBalance(1000.0);
        System.out.println("Initial balance " + investmentAccount.getBalance());

        InvestmentAccountRepository investmentRepo = new InvestmentAccountRepository();
        investmentRepo.buyStock(investmentAccount, goldStock, 160, 0.0);
        System.out.println("New balance " + investmentAccount.getBalance());
    }
}
