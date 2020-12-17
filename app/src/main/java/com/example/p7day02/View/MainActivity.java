package com.example.p7day02.View;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.p7day02.BannerContract.BannerContract;
import com.example.p7day02.Bean.BanBean;
import com.example.p7day02.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements BannerContract.IBannerView {

    private TextView tvTitle;
    private BannerContract.IBannerPresenter iBannerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        iBannerPresenter.getData();
    }

    private void initView() {
        tvTitle = findViewById(R.id.tv_title);
    }

    @Override
    public void onSuccess(List<BanBean.BannerlistBean> bannerlistBeans) {
        tvTitle.setText(bannerlistBeans.get(0).getImageurl());
    }

    @Override
    public void onFail(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}