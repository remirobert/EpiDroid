package me.zirko.epidroid.ui;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NavigationDrawerAdapter extends BaseAdapter {
    private List<DrawerItem> mObjects = new ArrayList<>();

    private final Context mContext;
    private final LayoutInflater mInflater;

    public NavigationDrawerAdapter(Context context) {
        mContext = context;
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mObjects.size();
    }

    @Override
    public DrawerItem getItem(int position) {
        return mObjects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;

        if (convertView == null) {
            view = mInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            holder = new ViewHolder();
            holder.title = (TextView) view.findViewById(android.R.id.text1);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }

        DrawerItem item = getItem(position);
        holder.title.setText(item.title);
        holder.title.setCompoundDrawablesWithIntrinsicBounds(item.iconRes, 0, 0, 0);
        holder.title.setCompoundDrawablePadding((int) (16 * mContext.getResources().getDisplayMetrics().density));

        return view;
    }

    public void add(@DrawableRes int iconRes, String navTitle) {
        mObjects.add(new DrawerItem(iconRes, navTitle));
        notifyDataSetChanged();
    }

    public void remove(int position) {
        mObjects.remove(position);
        notifyDataSetChanged();
    }

    public void insert(int position, DrawerItem item) {
        mObjects.add(position, item);
        notifyDataSetChanged();
    }

    private static class ViewHolder {
        public TextView title;
    }

    public class DrawerItem {
        @DrawableRes public int iconRes;
        public String title;

        private DrawerItem(int iconRes, String title) {
            this.iconRes = iconRes;
            this.title = title;
        }
    }
}
