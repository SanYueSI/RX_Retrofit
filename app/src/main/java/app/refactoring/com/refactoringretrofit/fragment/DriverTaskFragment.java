package app.refactoring.com.refactoringretrofit.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.refactoring.com.refactoringretrofit.R;

/**
 * unknown at 2018/6/28
 */

public class DriverTaskFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_task1, null);
    }
}
