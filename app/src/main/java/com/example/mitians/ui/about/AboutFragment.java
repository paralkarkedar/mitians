package com.example.mitians.ui.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mitians.R;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel>  list;
    private ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about2, container, false);


        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });



        list = new ArrayList<>();
        list.add(new BranchModel(R.drawable.ic_computer,"Computer Science","Computer science focuses on the development and testing of software and software systems. It involves working."));
        list.add(new BranchModel(R.drawable.ic_mech,"Mechanical Production","Mechanical engineers design power-producing machines, such as electric generators, internal combustion engines."));

        adapter = new BranchAdapter(getContext(),list);

        viewPager = view.findViewById(R.id.viewPager);


        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.college_image);

        Glide.with(getContext())
                .load("https://images.shiksha.com/mediadata/images/1607922828phpxOxv2D.png")
                .into(imageView);

        return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0,0?q=MIT Aurangabad");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}
