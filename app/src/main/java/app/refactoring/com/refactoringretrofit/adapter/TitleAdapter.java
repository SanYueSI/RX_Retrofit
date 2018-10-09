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
import app.refactoring.com.refactoringretrofit.bean.TitleModel;

/**
 * unknown at 2018/6/15
 */

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.ViewHolder> {
    private List<TitleModel.Title> mTitleList;
    private Context                mContext;

    public TitleAdapter(List<TitleModel.Title> mTitleList, Context context) {
        this.mTitleList = mTitleList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View sView = LayoutInflater.from(mContext)
                .inflate(R.layout.title_item, null);
        ViewHolder mViewHolder = new ViewHolder(sView);
        return mViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(mTitleList.get(position).getTitle());
    }


    @Override
    public int getItemCount() {
        return mTitleList == null ? 0 : mTitleList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;

        ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
