package me.zirko.epidroid.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import me.zirko.epidroid.R;
import me.zirko.epidroid.model.Schedule;

public class ScheduleAdapter extends ArrayAdapter<Schedule> {
    private final LayoutInflater mInflater;

    public ScheduleAdapter(Context context) {
        super(context, 0);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        Schedule item = getItem(position);

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.schedule_item, parent, false);
            holder = new ViewHolder();
            holder.time = (TextView) convertView.findViewById(R.id.event_time);
            holder.title = (TextView) convertView.findViewById(R.id.event_title);
            holder.room = (TextView) convertView.findViewById(R.id.event_room);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        DateFormat df = new SimpleDateFormat("HH'h'mm");

        holder.time.setText(getContext().getString(R.string.event_time,
                df.format(item.getStart()), df.format(item.getEnd())));
        holder.title.setText(item.getActiTitle());

        String roomCode = item.getRoom().getCode();
        holder.room.setText(roomCode.substring(roomCode.lastIndexOf('/') + 1));

        return convertView;
    }

    static class ViewHolder {
        TextView time;
        TextView title;
        TextView room;
    }
}
