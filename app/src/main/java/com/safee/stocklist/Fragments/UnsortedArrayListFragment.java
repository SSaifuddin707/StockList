package com.safee.stocklist.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.safee.stocklist.ArrayList.CreateArrayList;
import com.safee.stocklist.ArrayList.Stock;
import com.safee.stocklist.R;
import com.safee.stocklist.RecyclerViewHandling.RecyclerViewAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link UnsortedArrayListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UnsortedArrayListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private View v;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private static ArrayList<Stock> stockArray = new ArrayList<>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public UnsortedArrayListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UnsortedArrayListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UnsortedArrayListFragment newInstance(String param1, String param2) {
        UnsortedArrayListFragment fragment = new UnsortedArrayListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_unsorted_array_list, container, false);
        createArrayList();
        setUpRecyclerView();

        return v;
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
        stockArray.addAll(cal.getStockArray());
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

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
