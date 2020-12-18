package com.example.p7day02.View;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvplibrary.Base.BaseActivity;
import com.example.p7day02.BannerContract.BannerContract;
import com.example.p7day02.Bean.BanBean;
import com.example.p7day02.Presenter.BannerPresenter;
import com.example.p7day02.R;

import java.util.List;

public class MainActivity extends BaseActivity<BannerPresenter> implements BannerContract.IBannerView {

    private TextView tvTitle;

    public void initData() {
        presenter.getData();
    }

    public void initView() {
        tvTitle = findViewById(R.id.tv_title);
    }

    @Override
    protected BannerPresenter getPresenter() {
        return new BannerPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(List<BanBean.BannerlistBean> bannerlistBeans) {
        tvTitle.setText(bannerlistBeans.get(0).getImageurl());
    }

    @Override
    public void onFail(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.detachView();
        }
    }
}