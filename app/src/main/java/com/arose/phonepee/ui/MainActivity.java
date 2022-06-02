package com.arose.phonepee.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.arose.phonepee.R;
import com.arose.phonepee.helper.BottomNavHelp;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    //initialize variable
    private Toolbar mToolbar;
    private TextView toolbartext;
    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment;
    private AccountFragment accountFragment;
    private OfferFragment offerFragment;
    private PaymentFragment paymentFragment;
    private TransactionsFragment transactionsFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()){
            case R.id.navigation_home:
                toolbartext.setText("PhonePe");
                setUpFragment(homeFragment);
                return true;
            case R.id.navigation_offers:
                toolbartext.setText("Offers");
                setUpFragment(offerFragment);
                return true;
            case R.id.navigation_payment:
                toolbartext.setText("Scan & Pay");
                setUpFragment(paymentFragment);
                return true;
            case R.id.navigation_account:
                toolbartext.setText("My Account");
                setUpFragment(accountFragment);
                return true;
            case R.id.navigation_transaction:
                toolbartext.setText("Transactions");
                setUpFragment(transactionsFragment);
                return true;
            default:
                return false;
        }
    };

    private void setUpFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        fragmentTransaction.replace(R.id.home_view, fragment);
        fragmentTransaction.commit();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        initViews();
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        toolbartext.setText("PhonePe");

        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        BottomNavHelp.removeShiftMode(bottomNavigationView);

        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.home_view,homeFragment);
        beginTransaction.commit();
    }

    private void initViews() {
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.toolbar);
        toolbartext = findViewById(R.id.title_toolbar);
        bottomNavigationView = findViewById(R.id.navigation);
        homeFragment = HomeFragment.newInstance();
        accountFragment = AccountFragment.newInstance();
        offerFragment = OfferFragment.newInstance();
        paymentFragment = PaymentFragment.newInstance();
        transactionsFragment = TransactionsFragment.newInstance( );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.notify:
                Toast.makeText(this,"Notification",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.scanNpay:
                Toast.makeText(this,"Scan any code",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}