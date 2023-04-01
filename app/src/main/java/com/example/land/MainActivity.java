package com.example.land;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.land.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {


    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            setUpToolbar();
            navigationView = (NavigationView) findViewById(R.id.navigation_menu);
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId())
                    {
                        case R.id.home:

                            Intent home = new Intent(MainActivity.this,Home.class);
                            startActivity(home);
                            finish();
                            break;

                        case R.id.buy:

                            Intent buy = new Intent(MainActivity.this,Buy.class);
                            startActivity(buy);
                            finish();
                            break;

                        case R.id.rent:

                            Intent rent = new Intent(MainActivity.this,Rent.class);
                            startActivity(rent);
                            finish();
                            break;

                        case R.id.settings:

                            Intent settings = new Intent(MainActivity.this,settings.class);
                            startActivity(settings);
                            finish();
                            break;

                        case R.id.about:

                            Intent about = new Intent(MainActivity.this,About.class);
                            startActivity(about);
                            finish();
                            break;

                        case R.id.login:

                            Intent intent1 = new Intent(MainActivity.this,Login.class);
                            startActivity(intent1);
                            finish();
                            break;

                        case  R.id.share:{

                            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                            sharingIntent.setType("text/plain");
                            String shareBody =  "http://play.google.com/store/apps/detail?id=" + getPackageName();
                            String shareSub = "Try now";
                            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                            startActivity(Intent.createChooser(sharingIntent, "Share using"));

                        }
                        break;


                    }
                    return false;
                }
            });

        }

    private void setUpToolbar() {
        drawerLayout = findViewById(R.id.drawerLayout);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        actionBarDrawerToggle.syncState();
    }
}