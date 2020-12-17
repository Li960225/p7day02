package com.example.p7day02.Base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<p extends BasePresenter> extends AppCompatActivity implements BaseView {
    protected p presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        if (presenter == null){
            presenter = getPresenter();
            presenter.attachView(this);
        }
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract p getPresenter();

    protected abstract int getLayout();
}
