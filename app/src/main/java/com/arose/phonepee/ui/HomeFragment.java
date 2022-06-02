package com.arose.phonepee.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arose.phonepee.R;
import com.arose.phonepee.adapter.HomeViewPagerAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends Fragment {

   private Context mContext;
   private ViewPager viewPager;
   private LinearLayout lrnLyt;
   private ArrayList<Integer> offerList;
   private int count = 0;
   private Timer timer;

    public HomeFragment() {
        // Required empty public constructor
    }

      public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context.getApplicationContext();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void intiViews(View view) {
        viewPager = view.findViewById(R.id.view_pager_home);
        lrnLyt = view.findViewById(R.id.ln_points_home);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        intiViews(view);
        setupViewPager();

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
                        count++;
                    }
                    else{
                        count=0;
                        viewPager.setCurrentItem(count);
                    }
                });
            }
        }, 500, 2000);

        return view;
    }

    private void setupViewPager() {
        offerList = new ArrayList<>();
        offerList.add(R.drawable.jsi);
        offerList.add(R.drawable.jse1);
        offerList.add(R.drawable.jse2);
        HomeViewPagerAdapter viewPagerAdapter = new HomeViewPagerAdapter(mContext,offerList);
        viewPager.setAdapter(viewPagerAdapter);
        addBottomDots(0);
    }

    private void addBottomDots(int currentPage) {
        TextView[] mTxtDot = new TextView[offerList.size()];
        lrnLyt.removeAllViews();

        for(int i =0; i< mTxtDot.length; i++){
            mTxtDot[i] = new TextView(mContext);
            mTxtDot[i].setText(Html.fromHtml("&#8226"));
            mTxtDot[i].setTextSize(35);
            mTxtDot[i].setTextColor(getResources().getColor(R.color.grey_300));
            lrnLyt.addView(mTxtDot[i]);
        }
        if(mTxtDot.length>0)
            mTxtDot[currentPage].setTextColor(getResources().getColor(R.color.grey_400));
    }

    @Override
    public void onDetach() {
        super.onDetach();
        timer.cancel();
    }
}