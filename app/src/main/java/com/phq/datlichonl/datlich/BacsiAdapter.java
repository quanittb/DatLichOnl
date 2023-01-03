package com.phq.datlichonl.datlich;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.phq.datlichonl.BacSi;
import com.phq.datlichonl.datlich.DatLich;
import com.phq.datlichonl.R;
import com.phq.datlichonl.datlich.Thongtinchitiet;

import java.util.ArrayList;

public class BacsiAdapter extends BaseAdapter {
    final ArrayList<BacSi> list;
    private LinearLayout linearLayout ;
    private Button btnDatKham;
    private Context context;
    public BacsiAdapter(Context context,ArrayList<BacSi> list) {
        this.context = context;
        this.list = list;

    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return list.get(i).getId();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View viewBS;
        if (convertView == null) {
            viewBS = View.inflate(parent.getContext(), R.layout.item_bacsi, null);
        } else viewBS = convertView;

        //Bind sữ liệu phần tử vào View
        BacSi bs = (BacSi) getItem(i);
        ((TextView) viewBS.findViewById(R.id.txtTenBS)).setText(bs.getTen());
        ((TextView) viewBS.findViewById(R.id.txtKhoa)).setText("Khoa "+ bs.getKhoa());
        linearLayout = viewBS.findViewById(R.id.layout_item);
        btnDatKham = viewBS.findViewById(R.id.btnDatKham);
        btnDatKham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context, DatLich.class);
                intent.putExtra("id",String.valueOf(bs.getId()));
                context.startActivity(intent);
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context, Thongtinchitiet.class);
                intent.putExtra("id",String.valueOf(bs.getId()));
                context.startActivity(intent);

            }
        });
        return viewBS;

    }

}
