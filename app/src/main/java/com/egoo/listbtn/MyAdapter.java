package com.egoo.listbtn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zd on 2017/4/24.
 */
public class MyAdapter extends BaseAdapter {
    private Context mContext;

    private LayoutInflater mInflater;

    private List<String> mDatas;

//    private View.OnClickListener onClickListener;

    public MyAdapter(Context context, List<String> datas) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mDatas = datas;
//        this.onClickListener = onClickListener;
    }

    //个数
    @Override
    public int getCount() {
        return (mDatas != null ? mDatas.size() : 0);
    }

    @Override
    public Object getItem(int position) {
        return (mDatas != null ? mDatas.get(position) : null);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //布局
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {

            // 下拉项布局
            convertView = mInflater.inflate(R.layout.list_item_btn, null);

            holder = new ViewHolder();

            holder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.btn = (Button) convertView.findViewById(R.id.btn);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String plan = mDatas.get(position);

        if (plan != null) {

            holder.title.setText(plan);
            holder.btn.setText(mDatas.get(position));

            // 通常将position设置为tag，方便之后判断点击的button是哪一个
            //按钮的点击事件
            holder.btn.setTag(position);
            holder.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Button btn = (Button) v;
                    int pos = (Integer) btn.getTag();
                    System.out.println(" position2 :" + pos);
                    System.out.println(" data2 :" + mDatas.get(pos).toString());
                    btn.setText("111");
                    mDatas.set(position,"111");

                }
            });
        }


        return convertView;
    }

    //控件
    static class ViewHolder {
        ImageView avatar;
        TextView title;
        Button btn;
    }


}
