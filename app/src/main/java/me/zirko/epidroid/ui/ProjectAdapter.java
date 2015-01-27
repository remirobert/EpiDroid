package me.zirko.epidroid.ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import me.zirko.epidroid.R;
import me.zirko.epidroid.model.Project;

public class ProjectAdapter extends ArrayAdapter<Project> {
    private final LayoutInflater mInflater;

    public ProjectAdapter(Context context) {
        super(context, 0);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        Project item = getItem(position);

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.project_item, parent, false);
            holder = new ViewHolder();
            holder.time = (TextView) convertView.findViewById(R.id.project_time);
            holder.title = (TextView) convertView.findViewById(R.id.project_title);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        DateFormat df = new SimpleDateFormat("dd MMMM yyyy 'à' HH'h'mm");

        holder.time.setText(getContext().getString(R.string.project_time, df.format(item.getEndActi())));
        holder.title.setText(item.getActiTitle());

        return convertView;
    }

    static class ViewHolder {
        TextView time;
        TextView title;
        TextView room;
    }
}
