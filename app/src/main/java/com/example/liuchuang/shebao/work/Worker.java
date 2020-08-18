package com.example.liuchuang.shebao.work;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.liuchuang.shebao.PopWindow;
import com.example.liuchuang.shebao.R;
import com.example.liuchuang.shebao.Renzhengxinxitijiao;
import com.example.liuchuang.shebao.VideoChatViewActivity;
import com.example.liuchuang.shebao.dengdaishenhe.Renzhengrizhijilu;
import com.example.liuchuang.shebao.dengdaishenhe.Shenhetongguo_tupian;

public class Worker extends AppCompatActivity implements View.OnClickListener {
private LinearLayout dnegdaishenhe_work;
private  LinearLayout shenhetongguo_work;
    private  LinearLayout fafangxinxi;
    private  LinearLayout teshushenhe;
private ImageView xiaoxi1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker);
        dnegdaishenhe_work = findViewById(R.id.dnegdaishenhe_work);
        shenhetongguo_work = findViewById(R.id.shenhetongguo_work);
        xiaoxi1 = findViewById(R.id.xiaoxi1);
        fafangxinxi = findViewById(R.id.fafangxinxi);
        teshushenhe = findViewById(R.id.teshushenhe);
        xiaoxi1.setOnClickListener(this);
        ImageView shipintonghua_work = findViewById(R.id.bt_shipintonghua_work);
        shipintonghua_work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Worker.this,Renzhengrizhijilu.class);
                startActivity(intent);
                Toast.makeText(Worker.this, "请选择要审核的用户！", Toast.LENGTH_SHORT).show();
            }
        });
        dnegdaishenhe_work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Worker.this, Renzhengrizhijilu.class);
                startActivity(intent);
            }
        });
        shenhetongguo_work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Worker.this, Shenhetongguo_tupian.class);
                startActivity(intent1);
            }
        });
        fafangxinxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Worker.this, Shenhetongguo_tupian.class);
                startActivity(intent1);
            }
        });
        teshushenhe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Worker.this, "暂无特殊审核记录！", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.xiaoxi1:
                PopWindow popWindow1=new PopWindow(this);
                popWindow1.showPopupWindow(xiaoxi1);
                break;
            default:
                break;
        }
    }
}
