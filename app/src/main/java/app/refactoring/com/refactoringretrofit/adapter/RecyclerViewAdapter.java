package app.refactoring.com.refactoringretrofit.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import app.refactoring.com.refactoringretrofit.R;
import app.refactoring.com.refactoringretrofit.bean.FoodDataOut;

/**
 * unknown at 2018/6/15
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<FoodDataOut.Data> mNewDatasList;
    private Context                mContext;

    public RecyclerViewAdapter(List<FoodDataOut.Data> newDatasList, Context context) {
        mNewDatasList = newDatasList;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View sView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_data_item, null);
        ViewHolder mViewHolder = new ViewHolder(sView);
        return mViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(mNewDatasList.get(position).getTitle());
        Glide.with(mContext).load(mNewDatasList.get(position)
                .getAlbums().get(0))
                .into(holder.imgNews);
    }


    @Override
    public int getItemCount() {
        return mNewDatasList == null ? 0 : mNewDatasList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView  tvTitle;
        private ImageView imgNews;

        ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            imgNews = itemView.findViewById(R.id.img_news);
        }
    }

    public void updateData(List<FoodDataOut.Data> mNewDatasList) {
        if (null != mNewDatasList) {
            this.mNewDatasList.addAll(mNewDatasList);
        } else {
            this.mNewDatasList = mNewDatasList;
        }
        this.notifyDataSetChanged();
    }
}
