package com.example.francis.samsung_mediko;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public abstract class DoctorListFragment extends Fragment {
    private static final String TAG = "DoctorListFragment";
    private DatabaseReference mDatabase;

    private FirebaseRecyclerAdapter<Doctor, DoctorViewHolder> mAdapter;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;

    public DoctorListFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.doctor_recycler, container, false);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mRecycler = view.findViewById(R.id.doctor_recycler_view);
        mRecycler.setHasFixedSize(true);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mManager = new LinearLayoutManager(getActivity());

        mRecycler.setLayoutManager(mManager);

        Query doctorsQuery = getQuery(mDatabase);
        Log.i("QUERY:", doctorsQuery.toString());

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Doctor>()
                .setQuery(doctorsQuery, Doctor.class)
                .build();

        mAdapter = new FirebaseRecyclerAdapter<Doctor, DoctorViewHolder>(options) {

            @Override
            public DoctorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
                return new DoctorViewHolder(inflater.inflate(R.layout.doctorlist, viewGroup, false));
            }

            @Override
            protected void onBindViewHolder(DoctorViewHolder viewHolder, int position, final Doctor model) {
                final DatabaseReference doctorRef = getRef(position);

                // Set click listener for the whole post view
                final String postKey = doctorRef.getKey();

                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Launch PostDetailActivity
//                        Intent intent = new Intent(getActivity(), PostDetailActivity.class);
//
//                        intent.putExtra(PostDetailActivity.EXTRA_POST_KEY, postKey);
//
//                        startActivity(intent);
                    }
                });

                // Determine if the current user has liked this post and set UI accordingly
                /*if (model.stars.containsKey(getUid())) {
                    viewHolder.starView.setImageResource(R.drawable.ic_toggle_star_24);
                } else {
                    viewHolder.starView.setImageResource(R.drawable.ic_toggle_star_outline_24);
                }*/

                // Bind Post to ViewHolder, setting OnClickListener for the star button
                viewHolder.bindToDoctor(model, new View.OnClickListener() {
                    @Override
                    public void onClick(View starView) {
                        // Need to write to both places the post is stored
                        DatabaseReference globalPostRef = mDatabase.child("doctors").child(doctorRef.getKey());
                        DatabaseReference userPostRef = mDatabase.child("doctor_" + doctorRef.getKey() + 1).child(model.getUid()).child(doctorRef.getKey());

                        // Run two transactions
//                        onStarClicked(globalPostRef);
//                        onStarClicked(userPostRef);
                    }
                });
            }
        };
        mRecycler.setAdapter(mAdapter);
    }

    public abstract Query getQuery(DatabaseReference databaseReference);
}
