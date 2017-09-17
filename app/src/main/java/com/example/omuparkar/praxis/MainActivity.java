package com.example.omuparkar.praxis;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_events) {
            Toast.makeText(this,"Events",Toast.LENGTH_SHORT).show();
            EventFragment ev = new EventFragment();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.main_unchangable,ev,ev.getTag()).commit();
        }
        else if (id == R.id.nav_workshop) {
            Toast.makeText(this,"Workshops",Toast.LENGTH_SHORT).show();
            WorkshopFragment workshop = new WorkshopFragment();
            FragmentManager man = getSupportFragmentManager();
            man.beginTransaction().replace(R.id.main_unchangable,workshop,workshop.getTag()).commit();

        }else if (id == R.id.nav_leader) {
            Toast.makeText(this,"Leader Board",Toast.LENGTH_SHORT).show();
            LeaderboardFragment lf = new LeaderboardFragment();
            FragmentManager man = getSupportFragmentManager();
            man.beginTransaction().replace(R.id.main_unchangable,lf,lf.getTag()).commit();

        }
        else if (id == R.id.nav_ecoin) {
            Toast.makeText(this,"E-Coins",Toast.LENGTH_SHORT).show();
            EcoinsFragment ecoin = new EcoinsFragment();
            FragmentManager man = getSupportFragmentManager();
            man.beginTransaction().replace(R.id.main_unchangable,ecoin,ecoin.getTag()).commit();

        }
        else if (id == R.id.nav_about) {
            Toast.makeText(this,"About us",Toast.LENGTH_SHORT).show();
            AboutFragment about = new AboutFragment();
            FragmentManager man = getSupportFragmentManager();
            man.beginTransaction().replace(R.id.main_unchangable,about,about.getTag()).commit();
        }
        else if (id == R.id.nav_signout) {
            Toast.makeText(this,"Signed out",Toast.LENGTH_SHORT).show();
            SignoutFragment signout = new SignoutFragment();
            FragmentManager man = getSupportFragmentManager();
            man.beginTransaction().replace(R.id.main_unchangable,signout,signout.getTag()).commit();
        }
        else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
