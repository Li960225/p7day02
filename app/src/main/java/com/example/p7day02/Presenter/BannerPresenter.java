package com.example.p7day02.Presenter;

import com.example.p7day02.BannerContract.BannerContract;
import com.example.p7day02.Base.BasePresenter;
import com.example.p7day02.Bean.BanBean;
import com.example.p7day02.Model.BannerModel;
import com.example.p7day02.Net.NetCallBack;
import com.example.p7day02.Net.NetConstant;
import com.example.p7day02.View.MainActivity;

import java.util.List;

public class BannerPresenter extends BasePresenter<MainActivity> implements BannerContract.IBannerPresenter {
    protected BannerContract.IBannerModel iBannerModel;

    public BannerPresenter() {
        iBannerModel = new BannerModel(this);
    }

    @Override
    public void getData() {
        iBannerModel.getBannerData(NetConstant.BASEBANNERURL, new NetCallBack<BanBean>() {
            @Override
            public void OnSuccess(BanBean banBean) {
                List<BanBean.BannerlistBean> bannerlist = banBean.getBannerlist();
                iView.onSuccess(bannerlist);
            }

            @Override
            public void OnFail(String error) {
                iView.onFail(error);
            }
        });
    }
}
