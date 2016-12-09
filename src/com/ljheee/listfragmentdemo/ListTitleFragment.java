package com.ljheee.listfragmentdemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
/**
 * 屏幕左侧：ListFragment
 * @author ljheee
 *
 */
public class ListTitleFragment extends ListFragment{

	private CallBacks mCallBacks;;//对应绑定到的Activity
	private static List<String> titles = new ArrayList<String>();
	
	static{
		titles.add("题目一");
		titles.add("题目二");
		titles.add("题目三");
	}
	
	/**
	 * 内部接口
	 * 使用ListTitleFragment的Activity需要实现该接口。ListTitleFragment将使用该接口与Activity进行通信
	 * @author ljheee
	 *
	 */
	public interface CallBacks{
		public boolean onItemSelected(int pos);
	}
	
	/**
	 * 一旦Fragment开始与主Activity进行绑定。onAttach方法将被Android系统调用
	 * activity对应ListTitleFragment绑定到的Activity
	 */
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if(!(activity instanceof CallBacks)){
			throw new IllegalStateException(
					"ListTitle所在Activity必须实现Callbacks接口");
		}
		mCallBacks = (CallBacks) activity;
	}
	
	
	@Override
	public void onDetach() {
		super.onDetach();
		mCallBacks = null;
	}
	
	/**
	 * 初始化
	 * 使用ArrayAdapter来设置显示内容
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(getActivity(), 
				android.R.layout.simple_list_item_1,
				titles));
	}

	/**
	 * 如果某一项被选择，该方法将被调用
	 */
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		mCallBacks.onItemSelected(position);
	}
	
	
	
}
