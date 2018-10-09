package app.refactoring.com.refactoringretrofit.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import app.refactoring.com.refactoringretrofit.R;
import app.refactoring.com.refactoringretrofit.bean.ChangeModel;
import app.refactoring.com.refactoringretrofit.util.Utils;

/**
 * unknown at 2018/7/24
 */

public class ChangeFragment extends Fragment {
    private static final String TAG = "ChangeFragment";
    private ListView mListView;
    ChangeModel mChangeModels;
    private static OnItemClick mOnItemClick;
    private int number = 0;
    MyChangeAdapter adapter;
    private Button mButton;

    public static void setmOnItemClick(OnItemClick mOnItemClick) {
        ChangeFragment.mOnItemClick = mOnItemClick;
    }

    public static ChangeFragment newInstance(int position) {
        Bundle args = new Bundle();
        args.putInt("position", position);
        ChangeFragment fragment = new ChangeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mListView = getView().findViewById(R.id.fragment_list);
        mButton = getView().findViewById(R.id.btn_next);
        mChangeModels = Utils.getChangeModel();
        adapter = new MyChangeAdapter();
        adapter.setAnswers(mChangeModels.getTitles().get(number).getAnswers());
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener((parent, view, position, id) -> {
            mButton.setVisibility(View.VISIBLE);
            for (int i = 0; i < mChangeModels.getTitles().size(); i++) {
                List<ChangeModel.Answer> answers = mChangeModels.getTitles().get(number).getAnswers();
                for (int j = 0; j < answers.size(); j++) {
                    if (position == j) {
                        answers.get(j).setShow(true);
                    } else {
                        answers.get(j).setShow(false);
                    }
                }
            }
            adapter.notifyDataSetChanged();
            getActivity().getWindow().getDecorView().postDelayed(() -> {
                int size = Utils.getChangeModel().getTitles().size();
                number++;
                if (number == size) {
                    number = size;
                    return;
                }
                notifyAdapter(number);
            }, 300);
        });
        mButton.setOnClickListener(v -> {
            number--;
            if (number < 0) {
                return;
            }
            if (number == 0) {
                mButton.setVisibility(View.GONE);
            }
            notifyAdapter(number);
        });
    }

    private void notifyAdapter(int num) {
        List<ChangeModel.Answer> answers = mChangeModels.getTitles().get(num).getAnswers();
        adapter.setAnswers(answers);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            Log.i(TAG, "onHiddenChanged: ");
        } else {
            Log.i(TAG, "onHiddenChanged: ");
        }
    }

    class MyChangeAdapter extends BaseAdapter {

        private List<ChangeModel.Answer> mAnswers;

        public void setAnswers(List<ChangeModel.Answer> answers) {
            mAnswers = answers;
        }

        @Override
        public int getCount() {
            return mAnswers.size();
        }

        @Override
        public Object getItem(int position) {
            return mAnswers == null ? 0 : mAnswers.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.change_item, null);
            TextView tvShow = convertView.findViewById(R.id.tv_show);
            ImageView imageView = convertView.findViewById(R.id.img_select);
            if (mAnswers.get(position).isShow()) {
                imageView.setImageResource(R.drawable.r_slect);
            } else {
                imageView.setImageResource(R.drawable.r_unselect);
            }
            tvShow.setText(mAnswers.get(position).getStrAnswer());
            return convertView;
        }
    }

    public interface OnItemClick {
        void itemClick(int position);
    }
}
