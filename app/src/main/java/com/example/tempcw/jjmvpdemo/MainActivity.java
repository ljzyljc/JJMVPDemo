package com.example.tempcw.jjmvpdemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.tempcw.jjmvpdemo.mvp.activity.BaseActivity;
import com.jaeger.library.StatusBarUtil;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private String[] mMenuTitles;
    private ListView mMenuListView;
    private DrawerLayout drawer_layout;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMenuListView= (ListView) findViewById(R.id.left_drawer);
        drawer_layout= (DrawerLayout) findViewById(R.id.drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //设置沉浸式状态栏
//        StatusBarUtil.setColorForDrawerLayout(MainActivity.this, drawer_layout, getResources().getColor(R.color.main_line_color));
        //左边listView
        String[] mMenuTitles=getResources().getStringArray(R.array.menu_array);
        mMenuListView.setAdapter(new ArrayAdapter<String>(this,R.layout.left_item_layout,mMenuTitles));
        mMenuListView.setOnItemClickListener(this);
        //设置toolbar
//        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
//
//        bottomNavigationBar
//                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "首页").setActiveColorResource(R.color.orange))
//                .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "书籍").setActiveColorResource(R.color.teal))
//                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "音乐").setActiveColorResource(R.color.blue))
//                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp, "视频").setActiveColorResource(R.color.brown))
////                .addItem(new BottomNavigationItem(R.drawable.icon_02grzx64, "Games"))
//                .setActiveColor(R.color.colorAccent)
//                .setMode(BottomNavigationBar.MODE_FIXED)
//                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)
//                .initialise();
//        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(int position) {
//
//            }
//
//            @Override
//            public void onTabUnselected(int position) {
//
//            }
//
//            @Override
//            public void onTabReselected(int position) {
//
//            }
//        });
//        MyAsynTask myAsynTask=new MyAsynTask(MainActivity.this);
//        myAsynTask.execute();
    }
//    static class MyAsynTask extends AsyncTask<Void,Void,Void>{
//        private WeakReference<Context> weakReference;
//        public MyAsynTask(Context context){
//            weakReference=new WeakReference<Context>(context);
//        }
//
//        @Override
//        protected Void doInBackground(Void... params) {
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//            MainActivity activity= (MainActivity) weakReference.get();
//            if (activity!=null){
//                activity.drawer_layout.
//            }
//        }
//    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
//    private Handler mHandler=new MyHandler(this);
//    private static class MyHandler extends Handler{
//        private WeakReference<Activity> mActivity;
//        public MyHandler(Activity activity){
//            mActivity=new WeakReference<Activity>(activity);
//        }
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            if (mActivity.get()!=null){
//
//            }
//        }
//    }


}
