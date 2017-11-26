package com.example.tshb.top10downloader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mhmmdd on 19.11.2017.
 */

public class FeedAdapter<T extends FeedEntry> extends ArrayAdapter {
    private static final String TAG = "FeedAdapter";
    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private List<T> applications;

    public FeedAdapter(@NonNull Context context, int resource, List<T> applications) {
        super(context, resource);
        layoutResource = resource;
        layoutInflater = LayoutInflater.from(context);
        this.applications = applications;
    }

    @Override
    public int getCount() {
        return applications.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            Log.d(TAG, "getView: called with null convertView");
            convertView = layoutInflater.inflate(layoutResource, parent, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            Log.d(TAG, "getView: provided a convertView");
            viewHolder = (ViewHolder) convertView.getTag();
        }
        T currentApp = applications.get(position);

        viewHolder.tvNameTextView.setText(currentApp.getName());
        viewHolder.tvArtistTextView.setText(currentApp.getArtist());
        viewHolder.tvSummaryTextView.setText(currentApp.getSummary());

        return convertView;
    }

    private class ViewHolder {
        final TextView tvNameTextView;
        final TextView tvArtistTextView;
        final TextView tvSummaryTextView;

        ViewHolder(View v) {
            this.tvNameTextView = (TextView) v.findViewById(R.id.tvNameTextView);
            this.tvArtistTextView = (TextView) v.findViewById(R.id.tvArtistTextView);
            this.tvSummaryTextView = (TextView) v.findViewById(R.id.tvSummaryTextVieww);
        }
    }
}
