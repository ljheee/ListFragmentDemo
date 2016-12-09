package com.ljheee.listfragmentdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/**
 * 右侧ContentFragment
 * @author ljheee
 *
 */
public class ContentFragment extends Fragment {
	
	private int titlePos;
	public static String TITLEID = "contentAddress";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(getArguments().containsKey(TITLEID)){
			titlePos = getArguments().getInt(TITLEID);
		}
	}
	
	/***
	 * 生成该Fragment的界面
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		//加载视图
		View root = inflater.inflate(R.layout.content, container , false);
		
		//从布局 中获取控件
		TextView textView = (TextView) root.findViewById(R.id.showContent);
		textView.setText("当前题目是"+titlePos);
		
		return root;
	}
	
	
	
}
