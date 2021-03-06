package com.tht.movies.ui;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tht.movies.R;


public class DetailRecyclingAdapter extends RecyclerView.Adapter<DetailRecyclingAdapter.DetailAdapterViewHolder> {

    private String[] detailData;

    @Override
    public DetailRecyclingAdapter.DetailAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.detail_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, parent, false);
        return new DetailAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailRecyclingAdapter.DetailAdapterViewHolder holder, int position) {
        holder.detailItemTextView.setText(detailData[position]);
    }

    @Override
    public int getItemCount() {
        if (detailData != null) {
            return detailData.length;
        } else {
            return 0;
        }

    }

    public void setDetailData(Cursor data) {
        detailData = new String[3];
        detailData[0] = "Summary:\n\n" + data.getString(DetailActivity.INDEX_OVERVIEW);
        detailData[1] = "Rating: \n\n" + data.getDouble(DetailActivity.INDEX_VOTE_AVG) + "/10";
        detailData[2] = "Release Date: \n" + data.getString(DetailActivity.INDEX_RELEASE_DATE);
        notifyDataSetChanged();
    }

    public class DetailAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView detailItemTextView;

        public DetailAdapterViewHolder(View itemView) {
            super(itemView);
            detailItemTextView = (TextView) itemView.findViewById(R.id.tv_movie_detail);

        }
    }
}
