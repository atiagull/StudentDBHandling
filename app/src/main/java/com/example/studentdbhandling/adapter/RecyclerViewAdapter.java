package com.example.studentdbhandling.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentdbhandling.LessonsCRUD;
import com.example.studentdbhandling.R;
import com.example.studentdbhandling.model.Student;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context context;
    List<Student> studentList;

    public RecyclerViewAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_student_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.txtstdName.setText(student.getName());

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView img;
        TextView txtstdName;
        Button btnLesson;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            img = itemView.findViewById(R.id.stdImage);
            txtstdName = itemView.findViewById(R.id.txtStdName);
            btnLesson = itemView.findViewById(R.id.btnLesson);
            btnLesson.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d("msg","button is clicked");
            int position = this.getBindingAdapterPosition();
            Student student = studentList.get(position);
            Intent intent = new Intent(context, LessonsCRUD.class);
            intent.putExtra("name",student.getName());
            intent.putExtra("rollNo",student.getRollNo());
            intent.putExtra("id",String.valueOf(student.getId()));
            intent.putExtra("sabaq",student.getSabaq());
            intent.putExtra("sabqi",student.getSabqi());
            intent.putExtra("manzil",student.getManzil());
            context.startActivity(intent);
        }
    }
}
