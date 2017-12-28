package com.ssc2018.dqb.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者：MrXu on 2017/12/27 10:11
 * 邮箱：17610872621@163.com
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getFragmentView() == null){
            return LayoutInflater.from(getContext()).inflate(getFragmentViewById(),null);
        } else{
            return getFragmentView();
        }


    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    protected  abstract void  initData();
    protected abstract void initView();
    public View getFragmentView(){
        return null;
    }
    public int getFragmentViewById(){
        return 0;
    }
    public View findViewById(int id){
        return  getView().findViewById(id);
    }
    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
