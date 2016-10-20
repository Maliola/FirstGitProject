package com.mahui.firstgitproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mahui.firstgitproject.adapter.RecycleAdapter;
import com.mahui.firstgitproject.model.Student;
import com.mahui.firstgitproject.util.ShowDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycle;
    RecycleAdapter recycleAdapter;
    List<Student> alllist;
    TextView desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycle= (RecyclerView) findViewById(R.id.recycle);
        desc= (TextView) findViewById(R.id.desc);

        initData();

        recycle.setLayoutManager(new LinearLayoutManager(this));
        recycleAdapter=new RecycleAdapter(MainActivity.this,alllist);
        recycle.setAdapter(recycleAdapter);
        desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog.getInstance().showCommentDialog(v,"某某电影是一部很好看的电影，多少大牌明星云集，精彩演技。真的是很好看，满足你对梦幻世界的所有追求和幻想",MainActivity.this);
            }
        });
    }
    public void initData(){
        alllist=new ArrayList<Student>();
        alllist.add(new Student(1,"小白","男"));
        alllist.add(new Student(2,"小红","女"));
        alllist.add(new Student(3,"小粉","女"));
        alllist.add(new Student(4,"小绿","男"));
        alllist.add(new Student(5,"小蓝","男"));
        alllist.add(new Student(6,"小赤","男"));
        alllist.add(new Student(7,"小橙","女"));
        alllist.add(new Student(8,"小紫","男"));
        alllist.add(new Student(9,"小黄","男"));
        alllist.add(new Student(10,"小黑","男"));
        alllist.add(new Student(11,"小1","男"));
        alllist.add(new Student(12,"小2","女"));
        alllist.add(new Student(13,"小3","男"));
        alllist.add(new Student(14,"小4","男"));
        alllist.add(new Student(15,"小5","男"));
    }
}
