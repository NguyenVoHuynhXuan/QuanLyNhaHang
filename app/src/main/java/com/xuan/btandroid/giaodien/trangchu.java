package com.xuan.btandroid.giaodien;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.xuan.btandroid.Fragment.Fragment_hienthibanan;
import com.xuan.btandroid.Fragment.Fragment_thucdon;
import com.xuan.btandroid.R;

/**
 * Created by HP on 17-Apr-18.
 */

public class trangchu extends AppCompatActivity
{
    Toolbar toolbar1;
    NavigationView navigationView1;
    DrawerLayout drawerLayout1;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangchu);
        fragmentManager=getSupportFragmentManager();
        toolbar1=(Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView1=(NavigationView)findViewById(R.id.navigationview1);
        drawerLayout1=(DrawerLayout)findViewById(R.id.drawblelayout1);
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(trangchu.this,drawerLayout1,toolbar1,R.string.mo,R.string.dong)
        {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout1.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView1.setItemIconTintList(null);
        navigationView1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                int id=item.getItemId();
                switch (id)
                {
                    case R.id.menutrangchu:

                        break;
                    case R.id.menubanan:
                        fragmentTransaction=fragmentManager.beginTransaction();
                        Fragment_hienthibanan hienthibanan=new Fragment_hienthibanan();
                        fragmentTransaction.replace(R.id.framechinh,hienthibanan);
                        fragmentTransaction.commit();
                        item.setChecked(true);
                        drawerLayout1.closeDrawers();
                        break;

                    case R.id.menuthucdon:
                        fragmentTransaction=fragmentManager.beginTransaction();
                        Fragment_thucdon thucdon=new Fragment_thucdon();
                        fragmentTransaction.replace(R.id.framechinh,thucdon);
                        fragmentTransaction.commit();
                        item.setChecked(true);
                        drawerLayout1.closeDrawers();
                        break;
                    case R.id.menunhanvien:
                        break;
                    case R.id.menuthongke:
                        break;
                    case R.id.menucaidat:
                        break;
                }
                return false;
            }
        });



    }
}
