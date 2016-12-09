package com.ljheee.listfragmentdemo;


import com.ljheee.listfragmentdemo.ListTitleFragment.CallBacks;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
/**
 * 实现了ListFragment中的Callbacks接口
 * @author ljheee
 *
 */
public class MainActivity extends Activity implements CallBacks{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
    	switch (item.getItemId()) {
		case R.id.action_exit:
			finish();
			break;
		case R.id.action_settings:
			Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
    	return super.onOptionsItemSelected(item);
    }

    /***
	 * 该方法实现了ListFragment中的Callbacks接口
	 * 一旦ListFragment调用该方法
	 * Activity将生成新的Fragment放置在Activity右侧
	 * 并将对于的内容通过bundles传递给新的Fragment
	 */
	@Override
	public boolean onItemSelected(int pos) {
		
		//生成新的Fragment
		ContentFragment fragment = new ContentFragment();
		
		//生成Bundle，并在其中设置了需要传递的值
		Bundle argument = new Bundle();
		argument.putInt(ContentFragment.TITLEID, pos);//将新生成的Fragment替换在R.id.content标签下
		fragment.setArguments(argument);
		
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.replace(R.id.content, fragment);
		ft.commit();
		
		return false;
	}
}
