package com.phq.datlichonl.lichkham;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.phq.datlichonl.Database.LichKhamModify;
import com.phq.datlichonl.LichKham;
import com.phq.datlichonl.R;
import com.phq.datlichonl.Trunggian;

import java.util.ArrayList;

public class LichKhamAdapter extends BaseAdapter {
    final ArrayList<LichKham> list;
    private TextView tvBacsi , tvBenhnhan , tvgio ,tvkhoa;
    private Context context;
    Button btnXoa ;
    LichKhamModify lichKhamModify;
    public LichKhamAdapter(Context context,ArrayList<LichKham> list) {
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
            viewBS = View.inflate(parent.getContext(), R.layout.item_lichkham, null);
        } else viewBS = convertView;

        //Bind sữ liệu phần tử vào View
       LichKham lichKham = (LichKham) getItem(i);
        ((TextView) viewBS.findViewById(R.id.txtTenBenhnhan)).setText(lichKham.getTenbenhnhan());
        ((TextView) viewBS.findViewById(R.id.txtBacSi)).setText(lichKham.getTenbs());
        ((TextView) viewBS.findViewById(R.id.txtkhoa)).setText(lichKham.getKhoa());
        ((TextView) viewBS.findViewById(R.id.txtGioKham)).setText(lichKham.getGio()+" - "+ lichKham.getNgay() );
        tvBacsi = viewBS.findViewById(R.id.txtBacSi);
        tvgio = viewBS.findViewById(R.id.txtGioKham);
        btnXoa = viewBS.findViewById(R.id.btnXoaLichkham);
        lichKhamModify = new LichKhamModify(context);
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lichKhamModify.delete(Trunggian.id,tvgio.getText().toString(),tvBacsi.getText().toString());
                Toast.makeText(context,"Thành công!",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context,DSLichKham.class);
                context.startActivity(intent);
            }
        });


        return viewBS;
    }
}
