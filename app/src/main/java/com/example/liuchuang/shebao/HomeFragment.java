package com.example.liuchuang.shebao;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
public class HomeFragment extends Fragment {
    private ViewPager vp;
    private LinearLayout ll;
    private List<ImageView> imageList;
    private ArrayList<ImageView> dotsList;
    private int[] images = {R.mipmap.i,R.mipmap.c,R.mipmap.d,R.mipmap.e,R.mipmap.f,R.mipmap.g,R.mipmap.h};
    public Handler handler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            int currentItem = vp.getCurrentItem();
            //切换至下一个页面
            vp.setCurrentItem(++currentItem);
            //再次调用
            handler.sendEmptyMessageDelayed(1, 5000);
        };
    };
    public static HomeFragment newInstance(String param1) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout3, container, false);
        vp = (ViewPager) view.findViewById(R.id.vp);
        ll = (LinearLayout)view.findViewById(R.id.ll);

        //初始化数据
        initImages();
        //初始化小圆点
        initDots();
        //适配器
        ViewPagerIndicator adapter = new ViewPagerIndicator(imageList,handler);
        vp.setAdapter(adapter);
        //初始化vp的位置
        vp.setCurrentItem(imageList.size()*1000);
        //页面改变监听
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                //遍历小圆点集合
                for(int i=0;i<dotsList.size();i++){
                    if(position%dotsList.size() == i){//设置当前小圆点
                        dotsList.get(i).setImageResource(R.mipmap.blue);
                    }else{//设置其他小圆点
                        dotsList.get(i).setImageResource(R.mipmap.white);
                    }
                }
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,int positionOffsetPixels) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        //两秒发送一个消息
        handler.sendEmptyMessageDelayed(1, 5000);
        return view;
    }
    private void initDots() {
        //实例化一个集合存放小圆点
        dotsList = new ArrayList<ImageView>();
        for(int i=0;i<images.length;i++){
            ImageView view = new ImageView(getActivity());
            //把第一个小圆点设置为选中状态
            if(i == 0){
                view.setImageResource(R.mipmap.blue);
            }else{
                view.setImageResource(R.mipmap.white);
            }

//          ViewPager.LayoutParams params = new ViewPager.LayoutParams(8,8);
//            params.setMargins(5,0, 5, 0);
            DrawerLayout.LayoutParams params = new DrawerLayout.LayoutParams(20, 20);
            params.setMargins(10,0, 5, 0);
            //把小圆点添加到布局中
            ll.addView(view, params );
            //把小圆点添加到集合
            dotsList.add(view);
        }
    }
    private void initImages() {
        //实例化一个集合，用于存放图片
        imageList = new ArrayList<ImageView>();
        for(int i=0;i<images.length;i++){
            ImageView view = new ImageView(getActivity());
            view.setImageResource(images[i]);
            //添加到集合
            imageList.add(view);
        }
    }
}