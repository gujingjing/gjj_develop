package com.example.gjj.retrofit19.view.titleBar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gjj.retrofit19.R;

public class TitleBarView extends ViewGroup {
	private Context ctx = null;
	private Button leftButton = null;
	private Button rightButton = null;
	private TextView titleTextView = null;
	private View v;

	public TitleBarView(Context context) {
		super(context);
		this.ctx = context;
	}

	protected void onLayout(boolean arg0, int arg1, int arg2, int arg3, int arg4) {
	}

	@SuppressWarnings("unused")
	public View setup() {
		try {
			v = LayoutInflater.from(ctx).inflate(R.layout.title_bar_layout, null);
			RelativeLayout titleLayout = (RelativeLayout) v.findViewById(R.id.titleLayout);
			leftButton = (Button) v.findViewById(R.id.title_bar_left_button);

			rightButton = (Button) v.findViewById(R.id.title_bar_right_button);

			titleTextView = (TextView) v.findViewById(R.id.title_bar_title_textview);
			// titleTextView.getBackground().setAlpha(0);// 0~255透明度值
			// 隐藏左右菜单按钮
			setLeftButton(null);
			setRightButton(null);
			return v;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * id 设置左按钮文本
	 */
	public void setLeftButton(int id) {
		if (id > 0) {
			setLeftButton(ctx.getResources().getString(id));
		}else{
			leftButton.setVisibility(View.GONE);
		}
	}

	/**
	 * 设置左按钮文本 str
	 */
	public void setLeftButton(String str) {
		if (str != null) {
			leftButton.setVisibility(View.VISIBLE);
			leftButton.setText(str);
		} else {
			leftButton.setVisibility(View.GONE);
		}
	}
	/**
	 * 设置带图片的左边按钮
	 * @param leftdrawId
	 * @param
	 */
	public void setLeftButton(int leftdrawId, int id) {
		leftButton.setCompoundDrawablesWithIntrinsicBounds(ctx.getResources().getDrawable(leftdrawId), null, null, null);
		leftButton.setText(ctx.getResources().getString(id));
		leftButton.setVisibility(View.VISIBLE);
	}
	public void setLeftButton(int leftdrawId, int backDrawId, int id) {
		if(leftdrawId !=0)
		{
			leftButton.setCompoundDrawablesWithIntrinsicBounds(ctx.getResources().getDrawable(leftdrawId), null, null, null);
		}
		if(backDrawId !=0)
		{
			leftButton.setBackgroundResource(backDrawId);
		}
		if(id !=0)
		{
			leftButton.setText(ctx.getResources().getString(id));
		}


		leftButton.setVisibility(View.VISIBLE);
	}
	/**
	 * 设置右按钮
	 */
	public void setRightButton(int id) {
		if (id > 0) {
			setRightButton(ctx.getResources().getString(id));
		}else{
			rightButton.setVisibility(View.GONE);
		}
	}

	public void setRightButton(String str) {

		if (str != null) {
			rightButton.setVisibility(View.VISIBLE);
			rightButton.setText(str);
		} else {
			rightButton.setVisibility(View.GONE);
		}
	}
	/**
	 * 设置带图片的右边按钮
	 * @param
	 * @param
	 */
	public void setRightButton(int rightdrawId, int id) {
		rightButton.setCompoundDrawablesWithIntrinsicBounds(ctx.getResources().getDrawable(rightdrawId), null, null, null);
		rightButton.setText(ctx.getResources().getString(id));
		rightButton.setVisibility(View.VISIBLE);
	}
	public void setRightButton(int leftdrawId, int backDrawId, int id) {
		if(leftdrawId !=0)
		{
			rightButton.setCompoundDrawablesWithIntrinsicBounds(ctx.getResources().getDrawable(leftdrawId), null, null, null);
		}
		if(backDrawId !=0)
		{
			rightButton.setBackgroundResource(backDrawId);
		}
		if(id !=0)
		{
			rightButton.setText(ctx.getResources().getString(id));
		}
		rightButton.setVisibility(View.VISIBLE);
	}
	/**
	 * 设置标题
	 */
	public void setTitle(int id) {
		if (id > 0) {
			setTitle(ctx.getResources().getString(id));
		}
	}

	/**
	 * 设置标题
	 */
	public void setTitle(String str) {

		if (str != null) {
			titleTextView.setVisibility(View.VISIBLE);
			titleTextView.setText(str);
		} else {
			titleTextView.setVisibility(View.INVISIBLE);
		}
	}

	/**
	 * 获取标题的名称
	 */
	public String getTitle() {
		return titleTextView.getText().toString().trim();
	}
	/**
	 * 设置左边按钮的点击事件
	 * @param listener
	 */
	public void setLeftAction(OnClickListener listener) {
		leftButton.setOnClickListener(listener);
	}
	/**
	 * 设置右边按钮点击事件
	 * @param listener
	 */
	public void setRightAction(OnClickListener listener) {
		rightButton.setOnClickListener(listener);
	}
	/**
	 * 设置标题栏背景图片或颜色
	 * @param resid
	 */
	public void setBackground(int resid) {
		v.setBackgroundResource(resid);
	}
}
