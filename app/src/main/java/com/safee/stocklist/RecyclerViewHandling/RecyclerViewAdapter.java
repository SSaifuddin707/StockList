package com.safee.stocklist.RecyclerViewHandling;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.safee.stocklist.ArrayList.Stock;
import com.safee.stocklist.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.StockViewholder> {
    private ArrayList<Stock> stockArrayList;
    class StockViewholder extends RecyclerView.ViewHolder{
        public SimpleDraweeView stockImage;
        public TextView stockName, stockPrice;

        public StockViewholder(@NonNull View itemView) {
            super(itemView);
            stockImage = (SimpleDraweeView) itemView.findViewById(R.id.stockImage);
            stockName = (TextView) itemView.findViewById(R.id.stockName);
            stockPrice = (TextView) itemView.findViewById(R.id.stockPrice);
        }
        public void bind(Stock stock){
            stockName.setText(stock.getStockName());
            stockPrice.setText(String.valueOf(stock.getStockPrice()));
            stockImage.setImageURI(Uri.parse(stock.getStockImageURL()));
        }
    }
    public RecyclerViewAdapter (ArrayList<Stock> s){
        this.stockArrayList = s;
    }

    @NonNull
    @Override
    public StockViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.layout_recyclerview_stockitem, viewGroup, false);
        StockViewholder vh = new StockViewholder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull StockViewholder viewHolder, int i) {
        Stock stock = stockArrayList.get(i);
        viewHolder.bind(stock);

    }

    @Override
    public int getItemCount() {
        return stockArrayList.size();
    }
}
