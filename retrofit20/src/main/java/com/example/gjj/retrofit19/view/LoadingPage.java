package com.example.gjj.retrofit19.view;

import com.example.gjj.retrofit19.R;
import com.example.gjj.retrofit19.manager.ThreadManager;
import com.example.gjj.retrofit19.util.UiUtils;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

public abstract class LoadingPage extends FrameLayout {
	//未发出请求
	private static final int STATE_UNLOAD = 0;
	//正在请求
	private static final int STATE_LOADING = 1;
	//请求网络后的结果
	//错误
	private static final int STATE_ERROR = 2;
	//为空
	private static final int STATE_EMPTY = 3;
	//成功
	private static final int STATE_SUCCESSED = 4;
	
	//成功配套的view对象
	private View succesedView;
	private View error_view;
	private View empty_View;
	private View loading_view;
	
	//当前状态的遍历
	private int CURRENT_STATE;
	private LayoutParams layoutParams;
	private Context context;
	
	public LoadingPage(Context context) {
		super(context);
		this.context=context;
		initView();
	}

	private void initView() {
		CURRENT_STATE = STATE_UNLOAD;
		layoutParams = new LayoutParams(
				LayoutParams.MATCH_PARENT, 
				LayoutParams.MATCH_PARENT);
		//默认添加错误界面操作
		error_view = onCreateErrorView();
		if(error_view!=null){
			addView(error_view,layoutParams);
		}
		//默认添加为空界面操作
		empty_View = onCreateEmptyView();
		if(empty_View!=null){
			addView(empty_View,layoutParams);
		}
		
		//默认添加正在加载的界面操作
		loading_view = onCreateLoadingView();
		if(loading_view!=null){
			addView(loading_view,layoutParams);
		}
		showPage();
	}

	private void showPage() {
		UiUtils.runInMainThread(new Runnable() {
			@Override
			public void run() {
				showSafePage();
			}
		});
	}

	private void showSafePage() {
		//如果当前状态等于未加载或者正在加载，则显示转圈view对象
		if(loading_view!=null){
			loading_view.setVisibility(
					(CURRENT_STATE == STATE_UNLOAD||CURRENT_STATE == STATE_LOADING)?
					View.VISIBLE:View.GONE);
		}
		if(error_view!=null){
			error_view.setVisibility((CURRENT_STATE == STATE_ERROR)?View.VISIBLE:View.GONE);
		}
		if(empty_View!=null){
			empty_View.setVisibility((CURRENT_STATE == STATE_EMPTY)?View.VISIBLE:View.GONE);
		}
		//成功界面
		if(succesedView == null && CURRENT_STATE == STATE_SUCCESSED){
			//成功界面如何去做获取,当前类位置
			succesedView = onCreateSuccessedView();
			//将当前详细界面返回的成功view添加至FrameLayout中去
			addView(succesedView, layoutParams);
		}
		
		//如果当前状态是成功
		if(CURRENT_STATE == STATE_SUCCESSED){
			if(succesedView!=null){
				succesedView.setVisibility(View.VISIBLE);
			}
		}
	}
	
	public void show() {
		resetState();
		if(CURRENT_STATE == STATE_UNLOAD){
			//主线程
			UiUtils.runInMainThread(new Runnable() {
				@Override
				public void run() {
					//决定显示那个界面
					showSafePage();
				}
			});
		}
		
	}
	public void show(final ResultState currentState) {
					//主线程
					UiUtils.runInMainThread(new Runnable() {
						@Override
						public void run() {
							CURRENT_STATE = currentState.getValue();
							//决定显示那个界面
							showSafePage();
						}
					});
	}
	class RunnableTask implements Runnable{
		@Override
		public void run() {
			//请求网络操作,并且告知请求网络的最终状态
			final ResultState onLoad = onLoad();
			//主线程
			UiUtils.runInMainThread(new Runnable() {
				@Override
				public void run() {
					CURRENT_STATE = onLoad.getValue();
					//决定显示那个界面
					showSafePage();
				}
			});
		}
	}

	private void resetState() {
		if(CURRENT_STATE == STATE_SUCCESSED || CURRENT_STATE == STATE_ERROR || CURRENT_STATE == STATE_EMPTY){
			CURRENT_STATE = STATE_UNLOAD;
		}
	}

	public abstract View onCreateSuccessedView();
	public abstract ResultState onLoad();

	private View onCreateLoadingView() {
		return UiUtils.inflate(context,R.layout.layout_loading);
	}

	private View onCreateEmptyView() {
		return UiUtils.inflate(context,R.layout.layout_loading_empty);
	}

	private View onCreateErrorView() {
		//xml---View
		return UiUtils.inflate(context,R.layout.layout_loading_error);
	}
	
	public enum ResultState{
		RESULT_STATE_ERROR(2),
		RESULT_STATE_EMPTY(3),
		RESULT_STATE_SUCCESS(4);

		private int value;

		private ResultState(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
	}
}
