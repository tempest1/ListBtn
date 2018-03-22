package com.egoo.listbtn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list_view;
    private List<String> plans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_view = (ListView) findViewById(R.id.list_view);
        plans = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            plans.add("测试" );
        }

        MyAdapter mAdapter = new MyAdapter(this, plans);
        list_view.setAdapter(mAdapter);

        list_view.setOnItemClickListener(new OnItemClickHandler());
    }

    //ListView的点击事件
    private class OnItemClickHandler implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {

            Toast.makeText(MainActivity.this,""+position,Toast.LENGTH_SHORT).show();
            Log.e(""," position1 :" + position);
        }

    }


}
