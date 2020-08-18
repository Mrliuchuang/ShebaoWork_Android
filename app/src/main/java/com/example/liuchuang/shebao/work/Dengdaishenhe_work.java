package com.example.liuchuang.shebao.work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import com.example.liuchuang.shebao.Adapter.ItemBean1;
import com.example.liuchuang.shebao.Adapter.MainAdapter;
import com.example.liuchuang.shebao.Adapter.Myadapter1;
import com.example.liuchuang.shebao.R;
import com.example.liuchuang.shebao.VideoChatViewActivity;
import com.example.liuchuang.shebao.listload.XListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Dengdaishenhe_work extends Activity implements XListView.IXListViewListener {

    private XListView mListView;
    private ArrayList<ItemBean1> datas;
    private Handler mHandler;
    private MainAdapter mainAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dengdaishenhe_work);

        mListView = (XListView) findViewById(R.id.xlistview);
        mainAdapter = new MainAdapter(this);
        datas = new ArrayList<>();
        mHandler = new Handler();
        //设置数据
        geneItems();
        mListView.setPullLoadEnable(true);
        mListView.setAdapter(mainAdapter);

        mListView.setXListViewListener(this);
        //设置item的点击事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //这里的i-1，是因为头视图占了一个position
                //Toast.makeText(Dengdaishenhe_work.this, "i:" + (i - 1), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Dengdaishenhe_work.this, VideoChatViewActivity.class);
                Bundle bundle=new Bundle();
                bundle.putInt("ID", (i - 1));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
//        //设置长按事件
//        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, "长按事件 i:" + (i-1), Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
        //添加头布局
        View view = getLayoutInflater().inflate(R.layout.head_view, null);
        mListView.addHeaderView(view);
        //添加尾视图
        View view2 = getLayoutInflater().inflate(R.layout.head_view, null);
        mListView.addFooterView(view2);
        //设置禁止上拉
        //mListView.setPullLoadEnable(false);
        //设置禁止下拉
        //mListView.setPullRefreshEnable(false);
    }
    private void geneItems() {
        RequestParams params = new RequestParams("http://39.106.34.160/shebao/workerzhengzaishenhe.php");

        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Log.e("nnnnnnnnnn", "success" + result);
                try {
                    JSONArray jsonArray = new JSONArray(result);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String name = jsonObject.getString("name");
                        String IDcard=jsonObject.getString("shenfenzhenghao");
                        String Iphone=jsonObject.getString("shoujihao");
                        // 设置适配器
                        datas.add(new ItemBean1(R.mipmap.ic_launcher, name, "等待审核", IDcard, Iphone, "城乡户口"));
                        Myadapter1 myadapter = new Myadapter1(Dengdaishenhe_work.this, datas);
                        mListView.setAdapter(myadapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
//        for (int i = 0; i <= 10; i++) {
//            datas.add(new ItemBean1(R.mipmap.ic_launcher, "d", "等待审核", "d", "d", "城乡户口"));
//        }
//        mainAdapter.setDatas(datas);
    }


    //下拉刷新
    @Override
    public void onRefresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                datas.clear();
                geneItems();
                // mAdapter.notifyDataSetChanged();
                mainAdapter = new MainAdapter(Dengdaishenhe_work.this);
                mainAdapter.setDatas(datas);
                mListView.setAdapter(mainAdapter);
                onLoad();
            }
        }, 2000);
    }

    //上拉加载
    @Override
    public void onLoadMore() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                geneItems();
                mainAdapter.notifyDataSetChanged();
                onLoad();
            }
        }, 2000);
    }

    private void onLoad() {
        mListView.stopRefresh();
        mListView.stopLoadMore();
        //获取当前时间
        Date curDate = new Date(System.currentTimeMillis());
        //格式化
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
        String time = formatter.format(curDate);
        mListView.setRefreshTime(time);
    }
}
