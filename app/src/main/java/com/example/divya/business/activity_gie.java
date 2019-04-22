package com.example.divya.business;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.provider.FontsContract;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.provider.FontsContractCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class activity_gie extends AppCompatActivity {
    CardView view;
    String TAG = "LOAD";
    AppBarLayout bar;
    CardView[] card = new CardView[8];
    ImageButton[] imge = new ImageButton[8];
    ImageButton[] imgs = new ImageButton[8];
    CollapsingToolbarLayout barr;
    LinearLayout layout;
    Toolbar toolbar;
    TextView[] pview = new TextView[8];
    TextView[] topic = new TextView[8];
    ImageView[] img = new ImageView[8];
    int count = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gie);

        getSupportActionBar().hide();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.inflateMenu(R.menu.gie_menu);

        bar = (AppBarLayout)findViewById(R.id.appbar) ;
        barr = (CollapsingToolbarLayout)findViewById(R.id.colapse);
        view = (CardView)findViewById(R.id.info);

        card[0] = (CardView)findViewById(R.id.card);
        card[1]= (CardView)findViewById(R.id.card1);
        card[2] = (CardView)findViewById(R.id.card2);
        card[3]= (CardView)findViewById(R.id.card3);
        card[4]= (CardView)findViewById(R.id.card4);
        card[5] = (CardView)findViewById(R.id.card5);
        card[6] = (CardView)findViewById(R.id.card6);
        card[7] = (CardView)findViewById(R.id.card7);

        img[0] = (ImageView)findViewById(R.id.im1);
        img[1] = (ImageView)findViewById(R.id.im2);
        img[2] = (ImageView)findViewById(R.id.im3);
        img[3] = (ImageView)findViewById(R.id.im4);
        img[4] = (ImageView)findViewById(R.id.im5);
        img[5] = (ImageView)findViewById(R.id.im6);
        img[6] = (ImageView)findViewById(R.id.im7);
        img[7] = (ImageView)findViewById(R.id.im8);

        topic[0] = (TextView)findViewById(R.id.tp1);
        topic[1] = (TextView)findViewById(R.id.tp2);
        topic[2] = (TextView)findViewById(R.id.tp3);
        topic[3] = (TextView)findViewById(R.id.tp4);
        topic[4] = (TextView)findViewById(R.id.tp5);
        topic[5] = (TextView)findViewById(R.id.tp6);
        topic[6] = (TextView)findViewById(R.id.tp7);
        topic[7] = (TextView)findViewById(R.id.tp8);

        pview[0] = (TextView)findViewById(R.id.pview);
        pview[1] = (TextView)findViewById(R.id.pview1);
        pview[2] = (TextView)findViewById(R.id.pview2);
        pview[3] = (TextView)findViewById(R.id.pview3);
        pview[4] = (TextView)findViewById(R.id.pview4);
        pview[5] = (TextView)findViewById(R.id.pview5);
        pview[6] = (TextView)findViewById(R.id.pview6);
        pview[7] = (TextView)findViewById(R.id.pview7);


        imge[0] = (ImageButton)findViewById(R.id.expand);
        imgs[0] = (ImageButton)findViewById(R.id.shrink);
        imge[1] = (ImageButton)findViewById(R.id.expand1);
        imgs[1] = (ImageButton)findViewById(R.id.shrink1);
        imge[2] = (ImageButton)findViewById(R.id.expand2);
        imgs[2] = (ImageButton)findViewById(R.id.shrink2);
        imge[3] = (ImageButton)findViewById(R.id.expand3);
        imgs[3] = (ImageButton)findViewById(R.id.shrink3);
        imge[4] = (ImageButton)findViewById(R.id.expand4);
        imgs[4] = (ImageButton)findViewById(R.id.shrink4);
        imge[5] = (ImageButton)findViewById(R.id.expand5);
        imgs[5] = (ImageButton)findViewById(R.id.shrink5);
        imge[6] = (ImageButton)findViewById(R.id.expand6);
        imgs[6] = (ImageButton)findViewById(R.id.shrink6);
        imge[7] = (ImageButton)findViewById(R.id.expand7);
        imgs[7] = (ImageButton)findViewById(R.id.shrink7);

        LayoutTransition transition = new LayoutTransition();
        view.setLayoutTransition(transition);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(activity_gie.this,activity_first.class);
                startActivity(home);
                finish();
            }
        });

        bar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
                Log.i(TAG, String.valueOf(offset));


                if (offset > -500)
                {

                    view.setVisibility(View.GONE);



                    for(int i = 0;i<card.length;i++){

//                        card[i].setBackgroundColor(Color.WHITE);
//                        pview[i].setTextColor(ContextCompat.getColor(activity_gie.this,R.color.grey));
//                        topic[i].setTextColor(ContextCompat.getColor(activity_gie.this,R.color.grey));


                        final int ival = i;
                        card[i].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                count = count+1;

                                Toast.makeText(getApplicationContext(),"Chart"+""+ival+"Selected",Toast.LENGTH_SHORT).show();

                                if(count%2 == 0){
                                    imge[ival].setVisibility(View.VISIBLE);
                                    imgs[ival].setVisibility(View.GONE);
                                    pview[ival].setVisibility(View.VISIBLE);
                                    card[ival].setBackgroundColor(Color.WHITE);
                                    pview[ival].setTextColor(ContextCompat.getColor(activity_gie.this,R.color.grey));
                                    topic[ival].setTextColor(ContextCompat.getColor(activity_gie.this,R.color.grey));
                                    pview[ival].setTextColor(ContextCompat.getColor(activity_gie.this,R.color.grey));
                                    topic[ival].setTypeface(null, Typeface.NORMAL);
                                    pview[ival].setTypeface(null, Typeface.NORMAL);

                                    if(ival == 0){
                                        img[ival].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.hardware));
                                    }
                                    else if(ival ==3){
                                        img[ival].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.industry));
                                    }
                                    else if(ival == 7){
                                        img[ival].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.innovation));
                                    }
                                    else if(ival == 6){
                                        img[ival].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ipr));
                                    }
                                    else if(ival == 1){
                                        img[ival].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ai));
                                    }
                                    else if(ival == 2){
                                        img[ival].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.softwareapp));
                                    }
                                    else if(ival==4){
                                        img[ival].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.softwareplt));
                                    }
                                    else if(ival==5){
                                        img[ival].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.programing));
                                    }

                                }
                                else{
                                    imge[ival].setVisibility(View.GONE);
                                    imgs[ival].setVisibility(View.VISIBLE);
                                    pview[ival].setVisibility(View.GONE);

                                    card[ival].setBackgroundColor(ContextCompat.getColor(activity_gie.this,R.color.colorPrimary));
                                    pview[ival].setTextColor(Color.WHITE);
                                    topic[ival].setTextColor(Color.WHITE);
                                    topic[ival].setTypeface(null, Typeface.BOLD);
                                    pview[ival].setTypeface(null, Typeface.BOLD);
                                    if(ival == 0){
                                        img[ival].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.whardware));
                                    }
                                    else if(ival ==3){
                                        img[ival].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.windustry));
                                    }
                                    else if(ival == 7){
                                        img[ival].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.winnovation));
                                    }
                                    else if(ival == 6){
                                        img[ival].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.wipr));
                                    }
                                    else if(ival == 1){
//                                        img[ival].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.wai));
                                    }
                                    else if(ival == 2){
                                        img[ival].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.wsoftwareapp));
                                    }
                                    else if(ival==4){
                                        img[ival].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.wsoftwareplt));
                                    }
                                    else if(ival==5){
                                        img[ival].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.wprograming));
                                    }
                                }

                            }
                        });
                    }


                }

                else if(offset < -700){

//                    view.setVisibility(View.VISIBLE);

//                    for(int  j = 0;j<card.length;j++){
//
//                        final int jval = j;
//                        card[j].setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                count = count+1;
//
//
//
//
//                                Toast.makeText(getApplicationContext(),"Chart"+""+jval+"Unselectd",Toast.LENGTH_SHORT).show();
//
//                                if(count%2 == 0){
//                                    imge[jval].setVisibility(View.VISIBLE);
//                                    imgs[jval].setVisibility(View.GONE);
//                                    pview[jval].setVisibility(View.VISIBLE);
//                                    card[jval].setBackgroundColor(Color.WHITE);
//                                    pview[jval].setTextColor(ContextCompat.getColor(activity_gie.this,R.color.grey));
//                                    topic[jval].setTextColor(ContextCompat.getColor(activity_gie.this,R.color.grey));
//                                }
//                                else{
//                                    imge[jval].setVisibility(View.GONE);
//                                    imgs[jval].setVisibility(View.VISIBLE);
//                                    pview[jval].setVisibility(View.GONE);
//
//                                    card[jval].setBackgroundColor(ContextCompat.getColor(activity_gie.this,R.color.colorPrimary));
//                                    pview[jval].setTextColor(Color.WHITE);
//                                    topic[jval].setTextColor(Color.WHITE);
//                                }
//
//                            }
//                        });
//                    }
//                    card[].setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Toast.makeText(activity_gie.this,"appbar closed",Toast.LENGTH_SHORT).show();
//                        }
//                    });



                }
            }
        });


    }
}
