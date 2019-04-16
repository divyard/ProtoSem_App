package com.example.divya.business;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;


public class activity_events extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        navigationView = (NavigationView) findViewById(R.id.nav);
        navigationView.setNavigationItemSelectedListener(this);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public boolean onOptionsItemSelected(MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {

            case R.id.db:
                Intent h = new Intent(this, activity_first.class);
                startActivity(h);
                break;
            case R.id.dbb:
                Intent j = new Intent(this, activity_events.class);
                startActivity(j);
                break;
            case R.id.gie:
                Intent i = new Intent(this, activity_gie.class);
                startActivity(i);
                break;
            case R.id.leader:
                Intent l = new Intent(this, activity_leader.class);
                startActivity(l);
                break;
            case R.id.task:
                Intent m = new Intent(this, activity_tasks.class);
                startActivity(m);
                break;
            case R.id.gallery:
                Intent n = new Intent(this, activity_gallery.class);
                startActivity(n);
                break;
            case R.id.profile:
                Intent o = new Intent(this, activity_profile.class);
                startActivity(o);
                break;
            case R.id.setting:
                Intent k = new Intent(this, activity_settings.class);
                startActivity(k);
                break;
            case R.id.log:
                Intent g = new Intent(this, activity_signin.class);
                startActivity(g);
                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}