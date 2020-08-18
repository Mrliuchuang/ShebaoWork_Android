package com.example.liuchuang.shebao;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class ScanFragment extends Fragment {
    public static ScanFragment newInstance(String param1) {
        ScanFragment fragment = new ScanFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    public ScanFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout2, container, false);
        ImageView shipintonghua = view.findViewById(R.id.bt_shipintonghua);
        shipintonghua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),Renzhengxinxitijiao.class);
                startActivity(intent);
            }
        });
        Bundle bundle = getArguments();
        String agrs1 = bundle.getString("agrs1");
        return view;
    }
}