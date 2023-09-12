package com.example.mitians.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.mitians.LoginActivity;
import com.example.mitians.MainActivity;
import com.example.mitians.Message;
import com.example.mitians.MessageAdapter;
import com.example.mitians.R;
import com.example.mitians.RegistrationActivity;
import com.example.mitians.ebook.EbookActivity;
import com.example.mitians.ui.about.AboutFragment;
import com.example.mitians.video;

import java.util.ArrayList;

import soup.neumorphism.NeumorphCardView;


public class HomeFragment extends Fragment {

    MainActivity mainActivity;
    private ImageSlider imageSlider;
    private ImageView map ,cap;
    TextView kedar,kedar1;
    private  NeumorphCardView cardPunch1,cardWeight,cardCourse,cardRun;
   private  LinearLayout kedarr;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home2, container, false);


        kedar = view.findViewById(R.id.kedar);
        kedar1 = view.findViewById(R.id.kedar1);

        cardPunch1 = view.findViewById(R.id.cardPunch1);
        kedarr = view.findViewById(R.id.kedarr);
        cardWeight = view.findViewById(R.id.cardWeight);
        cardCourse = view.findViewById(R.id.cardCourse);
        cardRun= view.findViewById(R.id.cardRun);



        mainActivity = (MainActivity)getActivity();
        cardPunch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),MainActivity2.class);
                startActivity(i);
            }
        });

        mainActivity = (MainActivity)getActivity();
        kedarr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),MainActivity2.class);
                startActivity(i);
            }
        });
        mainActivity = (MainActivity)getActivity();
        cardWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),video.class);
                startActivity(i);
            }
        });

        mainActivity = (MainActivity)getActivity();
        cardCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),video.class);
                startActivity(i);
            }
        });
        mainActivity = (MainActivity)getActivity();
        cardRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), EbookActivity.class);
                startActivity(i);
            }
        });




        kedar.setSelected(true);
        kedar1.setSelected(true);

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });


        cap = view.findViewById(R.id.cap);
        cap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCap();
            }
        });




         imageSlider = view.findViewById(R.id.imageSlider);

          ArrayList<SlideModel> slideModels = new ArrayList<>();

         slideModels.add(new SlideModel("https://www.mit.asia/wp-content/uploads/2020/08/DSC_2809-1-350x212.png", ScaleTypes.FIT));
         slideModels.add(new SlideModel("https://www.mit.asia/wp-content/uploads/2020/08/MIT_programs_3_3-350x212.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://static.zollege.in/public/college_data/images/appImage/16478540961607922815phpXiYhvz.png?tr=h-250,w-400,c-force", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://img.collegedekhocdn.com/media/img/institute/crawled_images/37402/maha4.jpeg", ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);







            return view;

    }

    private void openCap() {
        String url = "https://www.mit.asia/";
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setPackage("com.android.chrome");
        startActivity(i);
        }



    private void openMap() {
        Uri uri = Uri.parse("geo:0,0?q=MIT Aurangabad");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }







}

