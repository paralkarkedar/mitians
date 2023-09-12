package com.example.mitians.ui.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.mitians.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class FacultyFragment extends Fragment {
    private ImageSlider imageSlider;
    private RecyclerView csDepartment,mechanicalDepartment,etcDepartment,agriDepartment;
    private LinearLayout csNoData,mechNoData,etcNoData,agriNoData;
    private List<TeacherData> list1,list2,list3,list5;
    private TeacherAdapter adapter;

    private DatabaseReference reference,dbRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_faculty2, container, false);


        csDepartment   = view.findViewById(R.id.csDepartment);
        mechanicalDepartment =view. findViewById(R.id.mechanicalDepartment);
        etcDepartment = view.findViewById(R.id.etcDepartment);
        agriDepartment= view.findViewById(R.id.agriDepartment);



        csNoData   = view.findViewById(R.id.csNoData);
        mechNoData = view.findViewById(R.id.mechNoData);
        etcNoData = view.findViewById(R.id.etcNoData);
        agriNoData = view.findViewById(R.id.agriNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        csDepartment();
        mechanicalDepartment();
        etcDepartment();
        agriDepartment();
        imageSlider = view.findViewById(R.id.imageSlider);

        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel("https://mba.mit.asia/extra-images/btech/mba/events/22.png", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://btech.mit.asia/wp-content/uploads/2022/05/Capgemini-placements-2021-22-768x432.png", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://static.zollege.in/public/college_data/images/appImage/16478540961607922815phpXiYhvz.png?tr=h-250,w-400,c-force", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://img.collegedekhocdn.com/media/img/institute/crawled_images/37402/maha4.jpeg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://btech.mit.asia/wp-content/uploads/2022/05/Pentagon-tech-2021-22-768x432.png", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://btech.mit.asia/wp-content/uploads/2022/05/Hinduja-768x432.jpg", ScaleTypes.FIT));


        imageSlider.setImageList(slideModels, ScaleTypes.FIT);





        return  view;

    }



    private void csDepartment() {

        dbRef = reference.child("Computer Science(CSE)");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list1 = new ArrayList<>();    //snapshot
                if(!dataSnapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                }else{
                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1,getContext());
                    csDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void mechanicalDepartment() {

        dbRef = reference.child("Mechanical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list2 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    mechNoData.setVisibility(View.VISIBLE);
                    mechanicalDepartment.setVisibility(View.GONE);
                }else{
                    mechNoData.setVisibility(View.GONE);
                    mechanicalDepartment.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    mechanicalDepartment.setHasFixedSize(true);
                    mechanicalDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2,getContext());
                    mechanicalDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void etcDepartment() {

        dbRef = reference.child("ETC");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list3 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    etcNoData.setVisibility(View.VISIBLE);
                    etcDepartment.setVisibility(View.GONE);
                }else{
                    etcNoData.setVisibility(View.GONE);
                    etcDepartment.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    etcDepartment.setHasFixedSize(true);
                    etcDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3,getContext());
                    etcDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void agriDepartment() {

        dbRef = reference.child("Agriculture");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list5 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    agriNoData.setVisibility(View.VISIBLE);
                    agriDepartment.setVisibility(View.GONE);
                }else{
                    agriNoData.setVisibility(View.GONE);
                    agriDepartment.setVisibility(View.VISIBLE);

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    agriDepartment.setHasFixedSize(true);
                    agriDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list5,getContext());
                    agriDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }


}


