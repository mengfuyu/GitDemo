package com.shared.thinkpad.mycliyeview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView img;

    private MyView view;

    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView(){
        view = (MyView) findViewById(R.id.myview);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag) {
                    view.setCheck(true);
                    view.invalidate();
                    flag = true;
                }else{
                    Toast.makeText(MainActivity.this, "有点急了", Toast.LENGTH_SHORT).show();
                    view.setBackgroundResource(R.mipmap.zhangh);
                    view.setCheck(false);
                    view.invalidate();
                    flag = false;
                }
            }
        });
    }
}
