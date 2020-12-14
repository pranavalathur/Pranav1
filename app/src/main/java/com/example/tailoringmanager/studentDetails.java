package com.example.tailoringmanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailoringmanager.Model.Details;
import com.example.tailoringmanager.ViewHolder.DetailsViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class studentDetails extends AppCompatActivity {


    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    DatabaseReference studReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        studReference = FirebaseDatabase.getInstance().getReference("Details");
        recyclerView=findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Details> options=new FirebaseRecyclerOptions.Builder<Details>().setQuery(studReference, Details.class).build();

        FirebaseRecyclerAdapter<Details, DetailsViewHolder> adapter=new FirebaseRecyclerAdapter<Details, DetailsViewHolder>(options)
        {
            private DetailsViewHolder holder;
            private int position;
            private Details model;


            @Override
            protected void onBindViewHolder(@NonNull DetailsViewHolder holder, int position, @NonNull final Details model)
            {
                holder.tvName.setText(model.getCourse1());
                holder.tvPrice.setText(model.getCourse2());


            }

            @NonNull
            @Override
            public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.studentview, parent, false);
                DetailsViewHolder holder=new DetailsViewHolder(view);
                return holder;
            }
        };
    }
}
