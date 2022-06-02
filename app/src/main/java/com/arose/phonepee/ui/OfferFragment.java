package com.arose.phonepee.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arose.phonepee.R;
import com.arose.phonepee.adapter.DealerAdapter;
import com.arose.phonepee.adapter.OfferAdapter;
import com.arose.phonepee.adapter.OfferViewPagerAdapter;
import com.arose.phonepee.model.DealerModel;
import com.arose.phonepee.model.OfferModel;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class OfferFragment extends Fragment {

    private Context context;
    private RecyclerView offerRecycler,dealerRecycler,dealerRecyclerOnline;
    private DealerAdapter adapter;
    private ViewPager viewPager;
    private ArrayList<String> offerArray;
    private LinearLayout lnrLyt;
    private Timer timer;
    private int count = 0;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public OfferFragment() {
        // Required empty public constructor
    }

    public static OfferFragment newInstance() {
        OfferFragment fragment = new OfferFragment();
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
        View view = inflater.inflate(R.layout.fragment_offer, container, false);
        intView(view);
        setUpViewPager();
        ArrayList<DealerModel> offlineMerchantList = new ArrayList<>();
        offlineMerchantList.add(new DealerModel("Arose","Flat","Kes."+"50","CashBack","Valid once per user"));
        offlineMerchantList.add(new DealerModel("Dido","Get burger worth","Kes."+"250","free","For new user"));
        offlineMerchantList.add(new DealerModel("Metro","Flat","Kes."+"70","Free","Bill payment of kes 300"));
        offlineMerchantList.add(new DealerModel("Leo","Cashback","Kes."+"20","Wallet","Valid once per user"));
        adapter = new DealerAdapter(context,offlineMerchantList);
        dealerRecycler.setAdapter(adapter);

        ArrayList<DealerModel> onlineMerchantList = new ArrayList<>();
        onlineMerchantList.add(new DealerModel("Ken","Get","20%","CashBack","Valid Twice per user"));
        onlineMerchantList.add(new DealerModel("Sara","Get","15","CashBack","For new user only"));
        onlineMerchantList.add(new DealerModel("Tom","Get","70","CashBack","Book 4 tickets"));
        onlineMerchantList.add(new DealerModel("Lev","Get","50","CashBack","Valid Twice per user"));
        adapter = new DealerAdapter(context,onlineMerchantList);
        dealerRecyclerOnline.setAdapter(adapter);

        ArrayList<OfferModel> offerList = new ArrayList<>();
        offerList.add(new OfferModel("Bill Payment","25% Cashback",R.drawable.ic_bill_green));
        offerList.add(new OfferModel("Electricity","30% Cashback",R.drawable.ic_lightbulb_green));
        offerList.add(new OfferModel("Water Bill","15% Cashback",R.drawable.ic_water_green));
        OfferAdapter adapter = new OfferAdapter(context,offerList);
        offerRecycler.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                addBottomDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(() ->{
                    if (count<=5){
                        viewPager.setCurrentItem(count);
                    }else{
                        count=0;
                        viewPager.setCurrentItem(count);
                    }
                });
            }
        },500,2000);

        return view;
    }

    private void setUpViewPager() {
        offerArray = new ArrayList<>();
        offerArray.add("25% cashback");
        offerArray.add("Free Recharge");
        offerArray.add("20% off on SBI card");
        offerArray.add("10% discount Book Flight");
        OfferViewPagerAdapter viewPagerAdapter = new OfferViewPagerAdapter(context,offerArray);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setClipToPadding(false);
        viewPager.setPadding(40,0,40,20);
        viewPager.setPageMargin(20);
        addBottomDots(0);

    }

    private void addBottomDots(int currentPage) {
        TextView[] mTxtDot = new TextView[offerArray.size()];
        lnrLyt.removeAllViews();

        for(int i =0; i< mTxtDot.length; i++){
            mTxtDot[i] = new TextView(context);
            mTxtDot[i].setText(Html.fromHtml("&#8226"));
            mTxtDot[i].setTextSize(35);
            mTxtDot[i].setTextColor(getResources().getColor(R.color.grey_300));
            lnrLyt.addView(mTxtDot[i]);
        }
        if(mTxtDot.length>0)
            mTxtDot[currentPage].setTextColor(getResources().getColor(R.color.grey_400));
    }

    private void intView(View view) {
        viewPager = view.findViewById(R.id.offer_view_pager);
        lnrLyt = view.findViewById(R.id.ln_points);
        offerRecycler = view.findViewById(R.id.rv_bill_pay_offers);
        dealerRecycler = view.findViewById(R.id.rv_offline_merchant);
        dealerRecyclerOnline = view.findViewById(R.id.online_dealer_recycler);
        dealerRecyclerOnline.setNestedScrollingEnabled(false);
        dealerRecycler.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        offerRecycler.setLayoutManager(layoutManager);
        dealerRecycler.setLayoutManager(new GridLayoutManager(context,3));
        dealerRecyclerOnline.setLayoutManager(new GridLayoutManager(context,3));
    }

    @Override
    public void onDetach() {
        super.onDetach();
        timer.cancel();
    }
}