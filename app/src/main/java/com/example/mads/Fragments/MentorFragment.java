package com.example.mads.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mads.Adapters.Mentor;
import com.example.mads.Models.mentor;
import com.example.mads.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class MentorFragment extends Fragment {


    private RecyclerView recyclerView;
    private Mentor mentor;
    private List<mentor> Umentor;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_mentor, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Umentor = new ArrayList<>();
        readUsers();

        return view;
    }

    private void readUsers(){
        final FirebaseUser firebaseUser  = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");

        reference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Umentor.clear();
                for ( DataSnapshot snapshot : dataSnapshot.getChildren()){
                    mentor m = snapshot.getValue(mentor.class);

                    assert m !=null;
                    assert firebaseUser !=null;

                    if (m.getTitle().equals("mentor") && !m.getId().equals(firebaseUser.getUid())){
                        Umentor.add(m);
                    }
                }



                mentor = new Mentor(getContext(), Umentor,true);
                recyclerView.setAdapter(mentor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}

