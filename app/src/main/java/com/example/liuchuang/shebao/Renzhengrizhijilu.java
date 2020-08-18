package com.example.liuchuang.shebao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.liuchuang.shebao.Adapter.ItemBean1;
import com.example.liuchuang.shebao.Adapter.Myadapter1;

import java.util.ArrayList;
import java.util.List;

public class Renzhengrizhijilu extends AppCompatActivity {
    private ListView listView1;
    List<ItemBean1> datelist1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renzhengrizhijilu);
        listView1 = findViewById(R.id.lv_main1);
        for (int i = 0; i < 10; i++) {
            // 设置适配器
            datelist1.add(new ItemBean1(R.mipmap.ic_launcher, "age"+i, "age","age","age","age"));
            Myadapter1 myadapter = new Myadapter1(Renzhengrizhijilu.this, datelist1);
            listView1.setAdapter(myadapter);
        }
    }

    public void renzhengrizhi(View view) {
      this.finish();
    }
}
