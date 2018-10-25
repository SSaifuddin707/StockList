package com.safee.stocklist.ArrayList;

/**
 * Created by Safeeullah Saifuddin
 * Java 2
 * 10/23/2018
 */


public class Stock implements Comparable{
    private String stockName, stockImageURL;
    private double stockPrice;

    public Stock(String stockName, double stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
    }

    public Stock(String stockName, String stockImageURL, double stockPrice) {
        this.stockName = stockName;
        this.stockImageURL = stockImageURL;
        this.stockPrice = stockPrice;
    }

    public String getStockImageURL() {
        return stockImageURL;
    }

    public void setStockImageURL(String stockImageURL) {
        this.stockImageURL = stockImageURL;
    }

    public String getStockName() {
        return stockName;
    }


    public double getStockPrice() {
        return stockPrice;
    }


    @Override
    public String toString() {
        return "Stock Name: " + stockName + " Stock Price = " + stockPrice;
    }

    @Override
    public boolean equals(Object obj) {
        Stock o = (Stock) obj;
        if (stockName.equalsIgnoreCase(o.getStockName())
                &&
                stockPrice == o.getStockPrice()){
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Object obj) {
        Stock o = (Stock) obj;
        if (stockPrice > o.getStockPrice()) return 1;
        else if (stockPrice == o.getStockPrice()) return 0;
        return -1;
    }
}
