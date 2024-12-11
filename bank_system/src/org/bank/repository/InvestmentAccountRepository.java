package org.bank.repository;

import org.bank.datamodel.InvestmentAccount;
import org.bank.datamodel.SavingAcount;
import org.bank.datamodel.Stock;
import org.bank.datamodel.StockOrder;

import java.time.ZonedDateTime;
import java.util.HashMap;

public class InvestmentAccountRepository {
    public void buyStock(InvestmentAccount account, Stock stock, Integer quantity, Double commission) {
        ZonedDateTime currentTime = ZonedDateTime.now();
        StockOrder stockOrder = new StockOrder(account, stock, quantity, commission, currentTime);
        Double newBalance = account.getBalance() - stockOrder.getTotalPrice();
        account.setBalance(newBalance);
        System.out.println("Order: " + stockOrder);
    }
}
