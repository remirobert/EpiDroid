package me.zirko.epidroid.ui;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import me.zirko.epidroid.R;
import me.zirko.epidroid.model.History;
import me.zirko.epidroid.network.VolleySingleton;

public class HistoryAdapter extends BaseAdapter {
    private final Context mContext;
    private final LayoutInflater mInflater;
    private List<History> mData;

    public HistoryAdapter(Context context, List<History> history) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mData = history;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public History getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.history_message, parent, false);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.content = (TextView) convertView.findViewById(R.id.content);
            holder.date = (TextView) convertView.findViewById(R.id.date);
            holder.avatar = (NetworkImageView) convertView.findViewById(R.id.avatar);
            holder.user = (TextView) convertView.findViewById(R.id.full_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy 'à' HH:mm");
        History item = getItem(position);
        holder.title.setText(Html.fromHtml(item.getTitle()));
        holder.content.setText(Html.fromHtml(item.getContent()));
        holder.date.setText(df.format(item.getDate()));
        if (item.getUser().getPicture() != null) {
            holder.avatar.setImageUrl(item.getUser().getPicture(),
                    VolleySingleton.getInstance(mContext).getImageLoader());
        } else {
            holder.avatar.setVisibility(View.GONE);
        }
        holder.user.setText(item.getUser().getTitle());

        return convertView;
    }

    static class ViewHolder {
        TextView title;
        TextView content;
        TextView date;
        NetworkImageView avatar;
        TextView user;
    }
}
