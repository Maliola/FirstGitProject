package com.mahui.firstgitproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mahui.firstgitproject.R;
import com.mahui.firstgitproject.model.Student;
import com.mahui.firstgitproject.viewholder.StudentViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2016/10/20.
 */
public class RecycleAdapter extends RecyclerView.Adapter<StudentViewHolder>{
    Context context;
    List<Student> list;

    public RecycleAdapter(Context context, List<Student> list) {
        this.list=list;
        this.context=context;
    }
    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_item, parent, false);
        return new StudentViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, final int position) {
        holder.id.setText(list.get(position).getId()+"");
        holder.name.setText(list.get(position).getName());
        holder.sex.setText(list.get(position).getSex());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
