package com.mahui.firstgitproject.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mahui.firstgitproject.R;
import com.mahui.firstgitproject.util.ShowDialog;

/**
 * Created by Administrator on 2016/10/20.
 */
public class StudentViewHolder extends RecyclerView.ViewHolder{
    public TextView id,name,sex;

    Context context;
    private View.OnClickListener myclicklistener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ShowDialog.getInstance().showCommentDialog(v,name.getText().toString(),context);
        }
    };
    public StudentViewHolder(View itemView,Context context) {
        super(itemView);
        this.context=context;
        id= (TextView) itemView.findViewById(R.id.id);
        name= (TextView) itemView.findViewById(R.id.name);
        sex= (TextView) itemView.findViewById(R.id.sex);
        name.setOnClickListener(myclicklistener);
    }

}
