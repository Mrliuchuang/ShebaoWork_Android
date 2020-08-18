package com.example.liuchuang.shebao.work;


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liuchuang.shebao.Adapter.ItemBean1;
import com.example.liuchuang.shebao.Adapter.Myadapter1;
import com.example.liuchuang.shebao.R;
import com.example.liuchuang.shebao.utius.Endbean;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import javax.security.auth.login.LoginException;


public class One_Shenhe extends AppCompatActivity {
    private TextView name_yonghu;
    private TextView IDcard;
    private TextView xingbie;
    private TextView Adress;
    private TextView Birth;
    private TextView minzu;
    private TextView shoujihao;
    private ImageView imageView;
    private Button end;
    ProgressDialog dia;
    String strint;


    String name;
    String adress;
    String birth;
    String sex;
    String shenfenzhenghao;
    String nation;
    String iphone;
    String touxianglujing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one__shenhe);
        imageView = findViewById(R.id.imageview_touxiang);
        Adress = findViewById(R.id.adress);
        Birth = findViewById(R.id.birth);
        end = findViewById(R.id.end);
        name_yonghu = findViewById(R.id.name_yonghu);
        IDcard = findViewById(R.id.shenfenzhenghao);
        xingbie = findViewById(R.id.xingbie);
        minzu = findViewById(R.id.minzu);
        shoujihao = findViewById(R.id.shoujihao);
        Bundle bundle = this.getIntent().getExtras();//跳转传值
        int ID = bundle.getInt("ID");
        strint = String.valueOf(ID);


        RequestParams params = new RequestParams("http://39.106.34.160/shebao/workerend.php");
        params.addBodyParameter("id", strint);
       x.http().post(params, new Callback.CommonCallback<String>() {
           @Override
           public void onSuccess(String result) {
               dia = new ProgressDialog(One_Shenhe.this);
               dia.setMessage("稍后。。。。。。");
               dia.show();
               Log.e("str", result);
               Gson gson = new Gson();
               Endbean jsonbean = gson.fromJson(result, Endbean.class);
                name =jsonbean.getName();
                adress =jsonbean.getAdress();
                birth =jsonbean.getBirth();
                sex =jsonbean.getXingbie();
               touxianglujing = jsonbean.getTouxianglujing();
               String id =jsonbean.getId();
                shenfenzhenghao = jsonbean.getShenfenzhenghao();
                nation =jsonbean.getMinzu();
                iphone = jsonbean.getShoujihao();
               Log.e("name", name);
               name_yonghu.setText(name);
               Adress .setText(adress);
               Birth.setText(birth);
               xingbie.setText(sex);
               IDcard.setText(shenfenzhenghao);
               minzu.setText(nation);
               shoujihao.setText(iphone);

               x.image().bind(imageView,touxianglujing);

               dia.dismiss();

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
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(One_Shenhe.this, Worker.class);
                startActivity(intent);
                delect();
            }
            private void delect() {


                RequestParams params = new RequestParams("http://39.106.34.160/shebao/workerendelectup.php");
                params.addBodyParameter("id", strint);
                params.addBodyParameter("name", name);
                params.addBodyParameter("shenfenzhenghao", shenfenzhenghao);
                params.addBodyParameter("xingbie", sex);
                params.addBodyParameter("minzu", nation);
                params.addBodyParameter("shoujihao", iphone);
                params.addBodyParameter("touxianglujing", touxianglujing);
                params.addBodyParameter("adress",adress );
                params.addBodyParameter("birth",birth );
                x.http().post(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Toast.makeText(One_Shenhe.this, "操作操作成功", Toast.LENGTH_SHORT).show();

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

            }
        });
    }


}

