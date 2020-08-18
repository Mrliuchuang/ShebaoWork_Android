package com.example.liuchuang.shebao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Renzhengxinxitijiao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renzhengxinxitijiao);
    }

    public void tijiao_renzheng(View view) {
        Intent intent = new Intent(Renzhengxinxitijiao.this, VideoChatViewActivity.class);
        startActivity(intent);
    }
}
