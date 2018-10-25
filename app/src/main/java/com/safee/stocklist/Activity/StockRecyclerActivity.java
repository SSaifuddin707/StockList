package com.safee.stocklist.Activity;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.safee.stocklist.Fragments.ViewPagerAdapter;
import com.safee.stocklist.Fragments.SortedFragment;
import com.safee.stocklist.Fragments.UnsortedArrayListFragment;
import com.safee.stocklist.R;

public class StockRecyclerActivity extends AppCompatActivity {
    //    private RecyclerView stockRecyclerView;
//    private static ArrayList<Stock> stockArray = new ArrayList<>();
    private ViewPager viewPager;
    private static final String TAG = "StockRecyclerActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_stock_recycler);
        setUpViewPager();


    }

    private void setUpViewPager() {
        viewPager = findViewById(R.id.container);
        ViewPagerAdapter vpa = new ViewPagerAdapter(getSupportFragmentManager());
        vpa.addFragment(new UnsortedArrayListFragment(), "Un-Sorted");
        vpa.addFragment(new SortedFragment(), "Sorted");
        viewPager.setAdapter(vpa);
    }

    public void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

//    private void createArrayList() {
//        CreateArrayList cal = new CreateArrayList();
//        stockArray.addAll(cal.getStockArray());
//    }


//    private void setUpRecyclerView() {
//        stockRecyclerView = (RecyclerView) findViewById(R.id.l_stockrecycler);
//        LinearLayoutManager LLM = new LinearLayoutManager(this);
//        stockRecyclerView.setLayoutManager(LLM);
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(stockRecyclerView.getContext(),
//                LLM.getOrientation());
//        stockRecyclerView.addItemDecoration(dividerItemDecoration);
//        stockRecyclerView.setHasFixedSize(true);
//        RecyclerViewAdapter adapter = new RecyclerViewAdapter(stockArray);
//        stockRecyclerView.setAdapter(adapter);
//
//    }
    }
}
