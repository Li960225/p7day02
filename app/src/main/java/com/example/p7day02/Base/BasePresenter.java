package com.example.p7day02.Base;

import com.example.p7day02.Presenter.BannerPresenter;

public class BasePresenter<V extends BaseView> {
    public V iView;
    public void attachView(V v){
        iView = v;
    }
}
