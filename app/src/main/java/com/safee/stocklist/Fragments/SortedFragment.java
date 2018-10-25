package com.safee.stocklist.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.safee.stocklist.Activity.StockRecyclerActivity;
import com.safee.stocklist.ArrayList.CreateArrayList;
import com.safee.stocklist.ArrayList.QuickSortStockArrayList;
import com.safee.stocklist.ArrayList.Stock;
import com.safee.stocklist.R;
import com.safee.stocklist.RecyclerViewHandling.RecyclerViewAdapter;

import java.util.ArrayList;


public class SortedFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View v;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private ArrayList<Stock> stockArray = new ArrayList<>();
    private SearchView searchView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public SortedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SortedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SortedFragment newInstance(String param1, String param2) {
        SortedFragment fragment = new SortedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v =inflater.inflate(R.layout.fragment_sorted, container, false);

        createArrayList();
        setUpRecyclerView();
        setUpSearchView();

        return v;
    }

    private void setUpSearchView() {
         searchView = v.findViewById(R.id.unSortedText);
        handleSearch();
    }

    private void handleSearch() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                querySearch(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }
    private void querySearch(String searchStockName) {
        boolean found = false;
        for (Stock s : stockArray) {
            if (s.getStockName() .equalsIgnoreCase(searchStockName)) {
                found = true;
                ((StockRecyclerActivity)getActivity()).hideKeyboard(getActivity());
                Toast.makeText(getContext(), s.getStockName() + " stock found. Current price: $" + s.getStockPrice(), Toast.LENGTH_LONG).show();

            }
        }
        if (!found) Toast.makeText(getContext(), searchStockName + " stock not found", Toast.LENGTH_LONG).show();

    }



    private void setUpRecyclerView() {
        recyclerView = (RecyclerView) v.findViewById(R.id.l_stockrecycler);
        LinearLayoutManager LLM = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(LLM);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                LLM.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapter(stockArray);
        recyclerView.setAdapter(adapter);

    }
    private void createArrayList() {
        CreateArrayList cal = new CreateArrayList();
        stockArray.clear();
        stockArray.addAll(cal.getStockArray());
        QuickSortStockArrayList qsa = new QuickSortStockArrayList(stockArray);
        stockArray = qsa.getStockArray();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
