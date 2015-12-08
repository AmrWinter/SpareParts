package com.alexforprog.spareparts.Unregistered;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alexforprog.spareparts.R;
import com.alexforprog.spareparts.Unregistered.unregistered_Fragments.unregistered_Brands_Grid;


import java.util.HashMap;

import CustomControl.CustomTypefaceSpan;
import Global.Global;
import Libs.Animations.DescriptionAnimation;
import Libs.Indicators.PagerIndicator;
import Libs.SliderLayout;
import Libs.SliderTypes.BaseSliderView;
import Libs.SliderTypes.TextSliderView;
import Libs.Tricks.ViewPagerEx;


public class unregistered_MainActivity extends AppCompatActivity
        implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener
        , NavigationView.OnNavigationItemSelectedListener {

    private ImageView ivNavigationDrawer, ivBack;
    private SliderLayout mDemoSlider;
    DrawerLayout drawer;
    NavigationView navigationView;
    FrameLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unregistered_main_wnav);
        initVals();

    }




    private void initVals() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);
        Menu m = navigationView.getMenu();
        for (int i=0;i<m.size();i++) {
            MenuItem mi = m.getItem(i);

            //for aapplying a font to subMenu ...
            SubMenu subMenu = mi.getSubMenu();
            if (subMenu!=null && subMenu.size() >0 ) {
                for (int j=0; j <subMenu.size();j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    applyFontToMenuItem(subMenuItem);
                }
            }

            //the method we have create in activity
            applyFontToMenuItem(mi);
        }
//        navigationView.
        mDemoSlider = (SliderLayout)findViewById(R.id.slider);
        ivNavigationDrawer = (ImageView) findViewById(R.id.ivNavigationDrawer);
        ivBack = (ImageView) findViewById(R.id.ivBack);
        ivNavigationDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

//        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
//        file_maps.put("Hannibal", android.R.drawable.arrow_up_float);
//        file_maps.put("Big Bang Theory", android.R.drawable.arrow_up_float);
//        file_maps.put("House of Cards",android.R.drawable.arrow_up_float);
//        file_maps.put("Game of Thrones", android.R.drawable.arrow_up_float);

        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);

            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);

        replaceFragments(Global.UNREGISTERED_BRANDS_GRID_FRAGMENT);

    }

    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/DroidKufi-Regular.ttf");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypefaceSpan("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
//        Fragment myFragment = null;
//        switch (item) {
//            case 0:
//                myFragment = new unregistered_Home_Page();
//                break;
//        }
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction()
//                .replace(R.id.container, myFragment)
//                .addToBackStack("tag").commit();

        return false;
    }

    public void replaceFragments(int fragment_number){

        Fragment myFragment = null;
        switch (fragment_number) {
//            case Global.UNREGISTERED_LOGIN_FRAGMENT:
//                myFragment = new unregistered_Home_Page();
//                break;
            case Global.UNREGISTERED_BRANDS_GRID_FRAGMENT:
                myFragment = new unregistered_Brands_Grid();
                break;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, myFragment)
                .addToBackStack("tag").commit();


    }
}
