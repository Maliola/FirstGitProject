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
        //获得屏幕的宽和高
        mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int screenWidth = mWindowManager.getDefaultDisplay().getWidth();
        int screenHeight= mWindowManager.getDefaultDisplay().getHeight();
        //获得传进来view的位置
        int[] location= new int[2];
        view.getLocationOnScreen(location);
        int dyBottom= screenHeight - location[1] - view.getHeight();
        //判断是在view顶部还是底部显示
        boolean onTop= (location[1] > dyBottom) ? true : false;
        View viewtop = View.inflate(context, R.layout.popup, null);
        top= (TextView) viewtop.findViewById(R.id.top);
        top.setText(text);
        bottom= (TextView) viewtop.findViewById(R.id.bottom);
        bottom.setText(text);
        //设置要显示的x,y坐标
        Window mwindow=dialog.getWindow();
        WindowManager.LayoutParams lp=mwindow.getAttributes();
        lp.x=-(screenWidth/2)+location[0];
        if(onTop){
            top.setVisibility(View.VISIBLE);
            bottom.setVisibility(View.GONE);
            //顶部显示就应该在view的y值上减去view的高
            lp.y=-(screenHeight/2)+location[1]-view.getHeight();
        }else{
            top.setVisibility(View.GONE);
            bottom.setVisibility(View.VISIBLE);
            //底部显示就应该在view的y值上加上view的高
            lp.y=-(screenHeight/2)+location[1]+view.getHeight();
        }
        dialog.setContentView(viewtop);
        //将计算好的位置set进去
        mwindow.setAttributes(lp);
        dialog.show();
    }
}
