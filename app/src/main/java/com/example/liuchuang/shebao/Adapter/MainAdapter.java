package com.example.liuchuang.shebao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liuchuang.shebao.ItemBean;
import com.example.liuchuang.shebao.R;

import java.util.ArrayList;

/**
 * @author 刘闯
 * @date 2019/3/23 0023.
 * Email：741163103@qq.com
 */

public class MainAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ItemBean1> datas;

    public MainAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(ArrayList<ItemBean1> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas != null ? datas.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        MyViewHolder myViewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item1, viewGroup, false);
            myViewHolder = new MyViewHolder(view);
            view.setTag(myViewHolder);
        }else {
            myViewHolder = (MyViewHolder) view.getTag();
        }
        //设置数据
        ItemBean1 bean = datas.get(i);
        myViewHolder.name_rizhi.setText(bean.name_rizhi);
        myViewHolder.itemImage.setImageResource(bean.itemImageResid);
        myViewHolder.zhuangtai_rizhi.setText(bean.name_rizhi);
        myViewHolder.shengfenzhenghao_rizhi.setText(bean.name_rizhi);
        myViewHolder.lianxifangshi_rizhi.setText(bean.name_rizhi);
        myViewHolder.renyuanleixing_rizhi.setText(bean.name_rizhi);


        return view;
    }

    class MyViewHolder {

        private TextView name_rizhi;
        private ImageView itemImage;
        private TextView zhuangtai_rizhi;
        private TextView shengfenzhenghao_rizhi;
        private TextView lianxifangshi_rizhi;
        private TextView renyuanleixing_rizhi;


        MyViewHolder(View itemView) {


             itemImage = (ImageView) itemView.findViewById(R.id.iv_image_rizhi);
             name_rizhi = (TextView) itemView.findViewById(R.id.name_rizhi);
             zhuangtai_rizhi = (TextView) itemView.findViewById(R.id.zhuangtai_rizhi);
             shengfenzhenghao_rizhi = (TextView) itemView.findViewById(R.id.shengfenzhenghao_rizhi);
             lianxifangshi_rizhi = (TextView) itemView.findViewById(R.id.lianxifangshi_rizhi);
             renyuanleixing_rizhi = (TextView) itemView.findViewById(R.id.renyuanleixing_rizhi);
        }
    }
}

