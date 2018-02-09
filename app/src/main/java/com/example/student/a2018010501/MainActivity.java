package com.example.student.a2018010501;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int ch=-1;//-1讓那個列表不要有預設值
    int tmp;//配合ch作暫時變數，免得出現取消後打開不會顯示現正選取的問題
    boolean chks[]=new boolean[6];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click1(View v){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);//創造一個對話的物件
        builder.setTitle("this is title");//設定它的標題
        builder.setMessage("hello");//設定它的內容

        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {//設定他右邊的按鈕並創造一個監聽此按鈕，當此按鈕被按時執行下列動作
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"你按了確定",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {//設定他左邊的按鈕並創造一個監聽此按鈕，當此按鈕被按時執行下列動作
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"你按了取消",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("help", new DialogInterface.OnClickListener() {//設定他最左邊的按鈕並創造一個監聽此按鈕，當此按鈕被按時執行下列動作
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"無法幫你",Toast.LENGTH_SHORT).show();
            }
        });
 /*
        builder.setNeutralButton("999", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"999",Toast.LENGTH_SHORT).show();
            }
        });
*/

        builder.show();//將此對話SHOW出來
    }
    public void click2(View v){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("可輸入");
        builder.setMessage("請輸入");

        final TextView tv;
        tv=(TextView)findViewById(R.id.textView);
        final EditText ed;
        ed=new EditText(MainActivity.this);
        ed.setText(tv.getText().toString());
        builder.setView(ed);
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {//設定他右邊的按鈕並創造一個監聽此按鈕，當此按鈕被按時執行下列動作
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tv.setText(ed.getText().toString());
                Toast.makeText(MainActivity.this,"你按了確定",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {//設定他左邊的按鈕並創造一個監聽此按鈕，當此按鈕被按時執行下列動作
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"你按了取消",Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
    public void click3(View v){
        final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("列表");
        final String list[]={"A","B","C"};
        final TextView tv2;
        tv2=(TextView)findViewById(R.id.textView2);
        builder.setItems(list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tv2.setText(list[i]);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });//因為沒辦法按空白處取消，所以必須要給你一個取消鈕
        builder.setCancelable(false);//這一行讓你沒有辦法按空白處取消
        builder.show();

    }
    public void click4(View v){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("選一個");
        final String plz[]={"AAA","BBB","CCC"};
        final TextView tv4;
        tmp=ch;//把tmp回去設定與ch同個值，避免沒修改(沒修改不會出發tmp=i的程式)就按確定時會輸入舊的值的錯誤
        tv4=(TextView)findViewById(R.id.textView3);
        builder.setSingleChoiceItems(plz, ch, new DialogInterface.OnClickListener() {//第二個參數用-1可以無預設，用變數可以根據變數改變顯示的值
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tmp=i;//將取得的數字i丟入ch變數中
                 }
        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ch=tmp;
                tv4.setText(plz[ch]);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.show();

    }
    public void click5(View v){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("多選");
        final String list[]={"QQ","GG","Q_Q","AA","BB","CC"};
        final TextView tv4=(TextView)findViewById(R.id.textView4);
        builder.setMultiChoiceItems(list,  chks, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

            }
        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                StringBuilder sb=new StringBuilder();
                for(int a=0;a<=5;a++){
                    if (chks[a]){
                        sb.append(list[a]+",");
                    }
                }
                tv4.setText(sb.toString());
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();

    }
    public void click6(View v){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("自訂Dialog");
        LayoutInflater LI=LayoutInflater.from(MainActivity.this);//layout解壓縮用的，可以把res裡面的layout挖出來
        View X=LI.inflate(R.layout.layout1,null);
        builder.setView(X);
        //-------------------------------------------控制自訂Dialog裡面元件的程式碼---------------------------
        final TextView tv=X.findViewById(R.id.textView5);
        Button btn=X.findViewById(R.id.button7);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("hello world");
            }
        });
        //-----------------------------------------------------------------------------------------------------------------------
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.show();

    }



}
