package com.example.gjj.retrofit19.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.gjj.retrofit19.R;
import com.example.gjj.retrofit19.swipClassView.SwipeBackActivity;
import com.example.gjj.retrofit19.util.UiUtils;
import com.example.gjj.retrofit19.view.LoadingPage;
import com.example.gjj.retrofit19.view.titleBar.TitleBarView;
import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * 作者：gjj on 2015/12/1 18:29
 * 邮箱：Gujj512@163.com
 */
public abstract class BaseSwipActivity extends SwipeBackActivity{
    public BaseSwipActivity mActivity;
    public TitleBarView mTitleBarView;
    private LoadingPage loadingPage;
    public View.OnClickListener leftListener,ortherLeftListener=null;
    private LinearLayout linearLayout,titleShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 消除标题
        setTranslucentStatus(true);
        applyKitKatTranslucency();
        mActivity = this;
        mTitleBarView = new TitleBarView(mActivity);
        leftListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.finish();
            }
        };
        linearLayout= (LinearLayout) UiUtils.inflate(mActivity,R.layout.activity_home_base);
        titleShow= (LinearLayout) linearLayout.findViewById(R.id.title_show);
        // 返回view对象
        loadingPage = new LoadingPage(mActivity) {
                    @Override
                    public View onCreateSuccessedView() {
                        //返回正常展示界面的方法
                        return mActivity.onCreateSuccessedView();
                    }
                    @Override
                    public ResultState onLoad() {
                        return mActivity.onLoad();
                    }
                };
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        loadingPage.setLayoutParams(params);
        linearLayout.addView(loadingPage);
        setContentView(linearLayout);
        setGui();
//        loadingPage.show();//加载网络显示界面
    }

    /**
     * 显示成功的界面
     */
    public abstract View onCreateSuccessedView();

    /**
     * 网络请求反悔的结果
     */
    public abstract LoadingPage.ResultState onLoad() ;
    /**
     * 设置界面的显示
     */
    public abstract void setGui();
    public void show(){
        //如何实现当前show方法
        if(loadingPage!=null){
            loadingPage.show();
        }
    }
    /**
     * Apply KitKat specific translucency.
     */
    public void applyKitKatTranslucency() {
        // KitKat translucent navigation/status bar.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            SystemBarTintManager mTintManager = new SystemBarTintManager(this);
            mTintManager.setStatusBarTintEnabled(true);
            mTintManager.setNavigationBarTintEnabled(true);
            if(0==initColor()){
//				mTintManager.setTintColor(0xFFff5500);//默认颜色ff5500
                mTintManager.setTintColor(getResources().getColor(R.color.colorPrimaryDark));//默认颜色ff5500
            }else{
                mTintManager.setTintColor(initColor());//自定义颜色
            }
        }
    }
    @TargetApi(19)
    public void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
    /**
     * 设置标题栏颜色
     */
    protected abstract int initColor();
    public void setTitle(String title){
            mTitleBarView.setTitle(TextUtils.isEmpty(title)?"":title);
    }
    /**
     * 设置标题内容
     */
    public void setmTitleBarView(LinearLayout linearLayout,String title){
        mTitleBarView = new TitleBarView(mActivity);
        linearLayout.addView(mTitleBarView.setup());
        mTitleBarView.setBackground(R.color.colorPrimaryDark);//设置背景资源
        mTitleBarView.setTitle(TextUtils.isEmpty(title)?"":title);
//        mTitleBarView.setLeftButton(leftImage, 0, leftButton);
//        mTitleBarView.setRightButton(rightImage,0,rightButton);
    }
    /**
     * 设置不需要标题
     */
    public void setTitleShow(boolean b){
        if(titleShow!=null){
            if(b){
                titleShow.setVisibility(View.VISIBLE);
            }else{
                titleShow.setVisibility(View.GONE);
            }
        }
    }

}
