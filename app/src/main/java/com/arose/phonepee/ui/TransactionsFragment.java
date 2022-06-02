package com.arose.phonepee.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arose.phonepee.R;
import com.arose.phonepee.adapter.TransactionAdapter;
import com.arose.phonepee.model.TransactionModel;

import java.util.ArrayList;

public class TransactionsFragment extends Fragment {

    private Context context;
    private RecyclerView recyclerView;

    public TransactionsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public static TransactionsFragment newInstance() {
        TransactionsFragment fragment = new TransactionsFragment();
        Bundle args = new Bundle();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transactions, container, false);
        intViews(view);
        ArrayList<TransactionModel> transactionModelArrayList = new ArrayList<>();
        transactionModelArrayList.add(new TransactionModel("1 day ago","Paid to","Arose","Kes. "+"500"
                ,"Debited from",R.drawable.ic_to_contact ));
        transactionModelArrayList.add(new TransactionModel("2 day ago","Paid to","Joy","Kes. "+"600"
                ,"Debited from",R.drawable.ic_to_contact ));
        transactionModelArrayList.add(new TransactionModel("3 day ago","Paid to","Fred","Kes. "+"2500"
                ,"Debited from",R.drawable.ic_to_contact ));
        transactionModelArrayList.add(new TransactionModel("4 day ago","Cashback","Paul","Kes. "+"100"
                ,"Credited to",R.drawable.ic_to_account ));
        transactionModelArrayList.add(new TransactionModel("5 day ago","Paid to","Andrew","Kes. "+"700"
                ,"Debited from",R.drawable.ic_to_contact ));
        transactionModelArrayList.add(new TransactionModel("6 day ago","Paid to","Justine","Kes. "+"4500"
                ,"Debited from",R.drawable.ic_to_contact ));
        transactionModelArrayList.add(new TransactionModel("7 day ago","Cash back","Nim","Kes. "+"900"
                ,"Credited to",R.drawable.ic_to_account ));
        transactionModelArrayList.add(new TransactionModel("8 day ago","Paid to","Sharon","Kes. "+"200"
                ,"Debited from",R.drawable.ic_to_contact ));

        TransactionAdapter adapter = new TransactionAdapter(context,transactionModelArrayList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void intViews(View view) {

        recyclerView = view.findViewById(R.id.transaction_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }
}