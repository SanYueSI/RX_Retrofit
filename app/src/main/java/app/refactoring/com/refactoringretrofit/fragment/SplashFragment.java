package app.refactoring.com.refactoringretrofit.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import app.refactoring.com.refactoringretrofit.R;

/**
 * unknown at 2018/6/15
 */

public class SplashFragment extends Fragment {
    private ImageView mImageView;

    public static SplashFragment newInstance(String url) {
        SplashFragment fragment = new SplashFragment();
        Bundle args = new Bundle();
        args.putString("url", url);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container, false);
        mImageView = view.findViewById(R.id.splash_img);
        String arg_param1 = getArguments().getString("url", "");
        Glide.with(inflater.getContext()).load(arg_param1)
                .into(mImageView);
        return view;
    }

}
