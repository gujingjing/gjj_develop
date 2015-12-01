package com.example.gjj.retrofit19.util;

import android.util.Log;

/**
 * 日誌控制文件
 */
public class LogUtils {
	private static final boolean LOGGER = true;
	private static final String TAG = "logs";
	public static void v(String tag, String msg) {
		if (LOGGER) {
			Log.v(TAG, StringUtils.joinString(tag, "---logs-->", msg));
		}
	}

	public static void d(String tag, String msg) {
		if (LOGGER) {
			Log.d(TAG, StringUtils.joinString(tag, "---logs-->", msg));
		}
	}

	public static void i(String tag, String msg) {
		if (LOGGER) {
			Log.i(TAG, StringUtils.joinString(tag, "---logs-->", msg));
		}
	}

	public static void w(String tag, String msg) {
		if (LOGGER) {
			Log.w(TAG, StringUtils.joinString(tag, "---logs-->", msg));
		}
	}

	public static void e(String tag, String msg) {
		if (LOGGER) {
			Log.e(tag, StringUtils.joinString(tag, "---logs-->", msg));
		}
	}

	public static void e(String tag, String msg, Throwable tr) {
		if (LOGGER) {
			Log.e(tag, StringUtils.joinString(tag, "---logs-->", msg));
		}
	}
}
