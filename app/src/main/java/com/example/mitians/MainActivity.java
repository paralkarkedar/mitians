package com.example.mitians;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.mitians.ebook.EbookActivity;
import com.example.mitians.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

import soup.neumorphism.NeumorphCardView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {



    private static  final String CHANNEL_ID = "My Channel";
    private static  final   int  NTIFICATION_ID = 100;
    private BottomNavigationView bottomNavigationView;
    private NavController navController;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;



    //private ImageSlider imageSlider;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.maha,null);

        BitmapDrawable bitmapDrawable= (BitmapDrawable) drawable;
        Bitmap largeIcon = bitmapDrawable.getBitmap();

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
             notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.maha)
                    .setContentText("New Message")
                    .setSubText("New Message From Ritesh Tamboli")
                    .setChannelId(CHANNEL_ID)
                    .build();
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"New Channel",NotificationManager.IMPORTANCE_HIGH));
        }else {
             notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.maha)
                    .setContentText("New Message")
                    .setSubText("New Message From Ritesh Tamboli")
                    .build();
        }
        nm.notify(NTIFICATION_ID,notification);

        // imageSlider = findViewById(R.id.imageSlider);

      //  ArrayList<SlideModel> slideModels = new ArrayList<>();

       // slideModels.add(new SlideModel("https://www.mit.asia/wp-content/uploads/2020/08/DSC_2809-1-350x212.png", ScaleTypes.FIT));
       // slideModels.add(new SlideModel("https://www.mit.asia/wp-content/uploads/2020/08/MIT_programs_3_3-350x212.jpg", ScaleTypes.FIT));
        //slideModels.add(new SlideModel("", ScaleTypes.FIT));
       // slideModels.add(new SlideModel("", ScaleTypes.FIT));

        //imageSlider.setImageList(slideModels, ScaleTypes.FIT);




        bottomNavigationView =findViewById(R.id.bottomNavigationView2);

        navController = Navigation.findNavController(this,R.id.frame_layout);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigation_view);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.start,R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        navigationView.setNavigationItemSelectedListener(this);





        NavigationUI.setupWithNavController(bottomNavigationView,navController);





    }





    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }

        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_developer:
                //  Toast.makeText(this, "Developer", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, video.class));
                break;
            case R.id.navigation_video:
                Toast.makeText(this, "Video Lecture", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_rate:
                Toast.makeText(this, "Rate Us", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_ebook:
                startActivity(new Intent(this, EbookActivity.class));
                break;
            case R.id.navigation_theme:
                Toast.makeText(this, "Themes", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_website:
                Toast.makeText(this, "WelCome To College", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
              
        }

        return true;
    }



    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);

        }else

        super.onBackPressed();
    }


}




  // color for navigation bar  ------ android:background="#BBD2ED"----