package com.phq.datlichonl.datlich;

import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.phq.datlichonl.BacSi;
import com.phq.datlichonl.Database.BacSiModify;
import com.phq.datlichonl.R;

import java.util.ArrayList;

public class DSBacSi extends AppCompatActivity {
    ListView listView ;
    BacsiAdapter bacsiAdapter;
    ArrayList<BacSi> list = new ArrayList<>();
    TextView txtten ;
    Button btnTimKiem ,btnDatKham ,btnSapxep;
    BacSiModify bacSiModify = new BacSiModify(DSBacSi.this);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danhsachbacsi);
        txtten = (TextView) findViewById(R.id.txtTimKiem);
        btnTimKiem = findViewById(R.id.btnTimKiem);
        btnDatKham = findViewById(R.id.btnDatKham);
        listView = (ListView) findViewById(R.id.lstBS);
        bacSiModify.insert(new BacSi(0,"Phạm Văn A","Phụ sản","QÚA TRÌNH ĐÀO TẠO\n" +
                "\n" +
                "- Hệ đại học – HVQY - Bác sỹ đa khoa phổ thông: 7/1979 – 09/1985.\n" +
                "\n" +
                "- Hệ sau đại học – HVQY – Bác sỹ CK cấp 1 nội chung: 9/1990 – 9/1992.\n" +
                "\n" +
                "- Trường đại học Y khoa Mác Xây – Cộng Hòa Pháp – Bác sỹ CK tim mạch: 1/1996-10/1997.\n" +
                "\n" +
                "- Viện Trường đại học La Timone – Thành phố Mác Xây – Thực tập sinh chuyên nghành tim mạch can thiệp: 1/2004 – 12/2004.\n" +
                "\n" +
                "- Hệ sau đại học – HVQY – Nghiên cứu sinh nội tim mạch: 2000-2005 (Bảo vệ luận án cấp Quốc gia tháng 3/2006).\n" +
                "\n" +
                "QUÁ TRÌNH CÔNG TÁC\n" +
                "\n" +
                "- 7/1979 - 9/1979: Huấn luyện tân binh, chiến sỹ - QK3\n" +
                "\n" +
                "- 9/1979 - 9/1985: Học viên Hệ đại học – Học viện Quân y\n" +
                "\n" +
                "- 9/1985 - 9/1988: Bác sỹ, C trưởng QY – QĐ3\n" +
                "\n" +
                "- 9/1988 - 9/1990: Bác sỹ, trưởng ban Nội – QY – QĐ3.\n" +
                "\n" +
                "- 9/1990 - 9/1992: Học viên CK cấp I, nội chung – Hệ sau Đại học – Học viện Quân y\n" +
                "\n" +
                "- 10/1992 - 3/2006: Bác sỹ điều trị - Khoa A1 – Bệnh viện TWQĐ 108\n" +
                "\n" +
                "- 3/2006 - 10/2012: Tiến sỹ, Phó CNK – Khoa A1 – Bệnh viện TWQĐ 108\n" +
                "\n" +
                "- Từ 10/2012 tới nay:Tiến sỹ, CNK – Khoa A1 – Bệnh viện TWQĐ 108\n" +
                "\n" +
                "ĐỀ TÀI NGHIÊN CỨU\n" +
                "\n" +
                "-  Điều trị bằng oxy cao áp cho bệnh nhân thiếu máu cơ tim\n" +
                "\n" +
                "- Nghiên cứu về Hypochol chiết xuất từ dầu đậu nành để điều trị hội chứng rối loạn lipid máu.\n" +
                "\n" +
                "- Tìm hiểu các yếu tố nguy cơ, ứng dụng các tiến bộ kỹ thuật trong chẩn đoán bệnh mạch vành, quản lý tốt các bệnh nhân sau nhồi máu cơ tim.\n" +
                "\n" +
                "- Nghiên cứu ứng dụng tiến bộ khoa học kỹ thuật trong chẩn đoán và điều trị bệnh động mạch vành.\n" +
                "\n" +
                "- Vai trò của siêu âm tim qua đường thực quản trong chẩn đoán các bệnh động mạch chủ ngực.\n" +
                "\n" +
                "- ứng dụng phương pháp nong van hai lá bằng bóng qua da trong điều trị bệnh hẹp khít van hai lá do thấp.\n" +
                "\n" +
                "- Hoàn thiện qui trình can thiệp động mạch vành qua da thì đầu trong điều trị nhồi máu cơ tim cấp.\n" +
                "\n" +
                "- Nghiên cứu tình trạng vữa xơ động mạch chủ ngực ở bệnh nhân nhồi máu não và nhồi máu cơ tim bằng siêu âm tim qua đường thực quản.\n" +
                "\n" +
                " - Nghiên cứu đặc điểm lâm sàng, cận lâm sàng và điều trị tái hẹp động mạch vành ở bệnh nhân sau can thiệp mạch vành qua da.\n" +
                "\n" +
                "- Hoàn thiện qui trình chẩn đoán và xử trí tái hẹp động mạch vành trên bệnh nhân thiếu máu cơ tim được nong và đặt stent.\n" +
                "\n" +
                "KHEN THƯỞNG\n" +
                "\n" +
                "- Chiến sỹ thi đua: 2 \n" +
                "\n" +
                "- 2005: Huân chương chiến công hạng nhất\n" +
                "\n" +
                "BÁC SĨ CÙNG KHOA"));
        bacSiModify.insert(new BacSi(1,"Phạm Văn A","Phụ sản","Giáo tone điều trị đau can thiệp." ));
        bacSiModify.insert(new BacSi(2,"Phạm Văn B","Răng hàm mặt","ABCD"));
        bacSiModify.insert(new BacSi(3,"Phạm Văn C","Hồi sức","ABC"));
        bacSiModify.insert(new BacSi(4,"Phạm Văn D","Chấn thương chỉnh hình","ABCE"));
        bacSiModify.insert(new BacSi(5,"Phạm Văn E","ABC","ABCF"));
        bacSiModify.insert(new BacSi(6,"Phạm Văn F","Chấn thương chỉnh hình","ABCG"));
        bacSiModify.insert(new BacSi(7,"Phạm Văn D","ABC","ABS"));
                bacSiModify.insert(new BacSi(8,"Phạm Văn B","Phụ sản","ABCDE"));

        Cursor cursor = bacSiModify.getAllData();
        cursor.moveToFirst();
        while (!cursor.isLast()){
            BacSi a = new BacSi(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
            list.add(a);
            cursor.moveToNext();
        }
        bacsiAdapter = new BacsiAdapter(DSBacSi.this,list);
        listView.setAdapter(bacsiAdapter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    public void timkiem(View view){
        int d = 0;
        ArrayList<BacSi> list1 = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(txtten.getText().toString().equalsIgnoreCase(list.get(i).getTen().toString())||txtten.getText().toString().equalsIgnoreCase(list.get(i).getKhoa().toString())){
                list1.add(list.get(i));
                d++;
            }
        }
            if(d==0){
                Toast.makeText(this,"Không tìm thấy !",Toast.LENGTH_LONG).show();
                txtten.setText("");
                bacsiAdapter = new BacsiAdapter(this,list);
                listView.setAdapter(bacsiAdapter);
                return;
            }
            bacsiAdapter = new BacsiAdapter(this,list1);
            listView.setAdapter(bacsiAdapter);

    }
}
