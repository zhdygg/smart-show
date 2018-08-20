package com.coder.zzq.smartshowdemo;

import android.app.Application;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coder.zzq.smartshow.SmartShow;
import com.coder.zzq.smartshow.SmartSnackbar;
import com.coder.zzq.smartshow.SmartToast;
import com.coder.zzq.smartshow.toast.ProcessViewCallback;


/**
 * Created by 朱志强 on 2017/11/12.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SmartShow.init(this);
        SmartShow.toastSetting()
                //自定义布局，参数可以是布局资源，也可以View。
                // 在自定义布局中，一定要设置显示文本提示的
                //TextView的Id为android:id="@id/custom_toast_msg"。
//                .view(R.layout.custom_toast)
                //设置背景颜色
                .backgroundColorRes(R.color.colorPrimary)
                //文本颜色
                .textColorRes(R.color.colorAccent)
                //设置文本字体大小
                .textSizeSp(18)
                //设置文本是否加粗
                .textBold(true)
                //设置离开当前页面时，该页面的Toast是否立即消失
                .dismissOnLeave(true)
                //对布局进一步处理
                .processView(new ProcessViewCallback() {
                    @Override
                    //isCustom 是否是自定义布局；rootView 布局根view；outParent 默认布局时，msgView的父布局，也是根布局
                    //msgView 显示文本的TxtView
                    public void processView(boolean isCustom, View rootView, LinearLayout outParent, TextView msgView) {
                        //...
                    }
                });

        SmartShow.snackbarSetting()
                //设置背景颜色
                .backgroundColorRes(R.color.colorPrimary)
                //设置消息文本颜色
                .msgTextColor(Color.WHITE)
                //设置消息文本大小
                .msgTextSizeSp(18)
                //设置动作文本颜色
                .actionColorRes(R.color.colorAccent)
                //设置动作文本大小
                .actionSizeSp(18)
                // //设置进入新的页面时，该页面的Snackbar是否消失（主要是Indefinite Snackbar而言）
                .dismissOnLeave(true)
                //对布局进一步处理
                .processView(new com.coder.zzq.smartshow.snackbar.ProcessViewCallback() {
                    @Override
                    //layout 父布局；msgView 消息文本View;actionView 动作文本View
                    public void processSnackbarView(Snackbar.SnackbarLayout layout, TextView msgView, TextView actionView) {

                    }
                });
    }
}
