package com.safee.stocklist.ArrayList;

import java.util.ArrayList;
import java.util.Collections;


public class QuickSortStockArrayList {
    private ArrayList<Stock> stockArray;

    public QuickSortStockArrayList(ArrayList<Stock> stockArray) {
        quickSort(stockArray, 0, stockArray.size() -1);
        this.stockArray = stockArray;
    }

    private static void quickSort(ArrayList<Stock> unsortedArrayList, int start, int end) {
        int pivotPoint;
        if (start < end){
            pivotPoint = partition(unsortedArrayList, start, end);
            quickSort(unsortedArrayList, start, pivotPoint - 1);
            quickSort(unsortedArrayList, pivotPoint +1, end);
        }
    }

    private static int partition(ArrayList<Stock> unsortedArrayList, int start, int end) {
        double pValue;
        int midPoint;
        int endOfList;

        midPoint = (start + end) / 2;

        Collections.swap(unsortedArrayList, start, midPoint);

        pValue = unsortedArrayList.get(start).getStockPrice();

        endOfList = start;

        for (int i = start + 1; i<= end; i++){
            if (unsortedArrayList.get(i).getStockPrice() < pValue){
                endOfList++;
                Collections.swap(unsortedArrayList, endOfList, i);
            }
        }

        Collections.swap(unsortedArrayList, start, endOfList);
        return endOfList;


    }

    public ArrayList<Stock> getStockArray() {
        return stockArray;
    }
}

