package com.mahui.firstgitproject.util;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.mahui.firstgitproject.R;

/**
 * Created by Administrator on 2016/10/20.
 */
public class ShowDialog {
    WindowManager mWindowManager;
    TextView top,bottom;

    private static ShowDialog INSTACE;
    public synchronized static ShowDialog getInstance() {
        if(null==INSTACE){
            INSTACE=new ShowDialog();
        }
        return INSTACE;
    }

    public void showCommentDialog(View view, String text, Context context) {
        Dialog dialog=new Dialog(context, R.style.dialog_translucent);
        mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int screenWidth = mWindowManager.getDefaultDisplay().getWidth();
        int screenHeight= mWindowManager.getDefaultDisplay().getHeight();
        int[] location= new int[2];
        view.getLocationOnScreen(location);
        int dyBottom= screenHeight - location[1] - view.getHeight();
        boolean onTop= (location[1] > dyBottom) ? true : false;
        View viewtop = View.inflate(context, R.layout.popup, null);
        top= (TextView) viewtop.findViewById(R.id.top);
        top.setText(text);
        bottom= (TextView) viewtop.findViewById(R.id.bottom);
        bottom.setText(text);
        Window mwindow=dialog.getWindow();
        WindowManager.LayoutParams lp=mwindow.getAttributes();
        lp.x=-(screenWidth/2)+location[0];
        if(onTop){
            top.setVisibility(View.VISIBLE);
            bottom.setVisibility(View.GONE);
            lp.y=-(screenHeight/2)+location[1]-view.getWidth();
        }else{
            top.setVisibility(View.GONE);
            bottom.setVisibility(View.VISIBLE);
            lp.y=-(screenHeight/2)+location[1]+view.getWidth();
        }
        dialog.setContentView(viewtop);
        mwindow.setAttributes(lp);
        dialog.show();
    }
}
