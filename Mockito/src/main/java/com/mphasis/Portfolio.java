package com.mphasis;

import com.mphasis.entities.Stock;
import com.mphasis.services.CalculatorService;
import com.mphasis.services.StockService;

import java.util.List;

public class Portfolio {
    private StockService stockService;
    private List<Stock> stocks;
    private CalculatorService calculatorService;

    public CalculatorService getCalculatorService() {
        return calculatorService;
    }

    public void setCalculatorService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public StockService getStockService() {
        return stockService;
    }

    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public double getMarketValue(){
        double marketValue = 0.0;
        for(Stock stock:stocks){
            marketValue += stockService.getPrice(stock) * stock.getQuantity();
        }
        return marketValue;
    }

    public double checkAdd(double first, double second){
        return calculatorService.add(first,second);
    }
}
