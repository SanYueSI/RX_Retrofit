package app.refactoring.com.refactoringretrofit.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.refactoring.com.refactoringretrofit.R;
import app.refactoring.com.refactoringretrofit.adapter.RecyclerViewAdapter;
import app.refactoring.com.refactoringretrofit.api.imp.NewInterfaceImp;
import app.refactoring.com.refactoringretrofit.api.inter.NewsInterface;
import app.refactoring.com.refactoringretrofit.base.BaseFragment;
import app.refactoring.com.refactoringretrofit.bean.FoodDataOut;
import app.refactoring.com.refactoringretrofit.util.RecyclerViewDivider;

/**
 * unknown at 2018/6/15
 */

public class NewDataFragment extends LazyLoadFragment {
    private static final String                 ARG_PARAM1 = "tag";
    private              List<FoodDataOut.Data> data       = new ArrayList<>();
    private RecyclerViewAdapter mMyRecyclerViewAdapter;
    XRecyclerView recyclerView;

    public static NewDataFragment newInstance(String title) {
        NewDataFragment fragment = new NewDataFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, title);
        fragment.setArguments(args);
        return fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_newsdata, container, false);
        recyclerView = view.findViewById(R.id.frag_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMyRecyclerViewAdapter = new RecyclerViewAdapter(data, getActivity());
        recyclerView.addItemDecoration(new RecyclerViewDivider());
        recyclerView.setAdapter(mMyRecyclerViewAdapter);
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                getActivity().getWindow().getDecorView()
                        .postDelayed(() -> recyclerView.refreshComplete(), 3000);
            }

            @Override
            public void onLoadMore() {
                getActivity().getWindow().getDecorView()
                        .postDelayed(() -> recyclerView.loadMoreComplete(), 3000);
            }
        });
        return view;
    }

    private void requestNewData() {
        NewsInterface newsInterface = new NewInterfaceImp();
        newsInterface.getFoodsDatas(getActivity(), this,
                "1d2e476415bafcd9bf227323b5be850e",
                getArguments().getString(ARG_PARAM1));
    }

    public void requestSuccess(FoodDataOut foodDataOut) {
        mMyRecyclerViewAdapter.updateData(foodDataOut.getResult().getData());
    }

    @Override
    public void fetchData() {
        requestNewData();
    }
}
