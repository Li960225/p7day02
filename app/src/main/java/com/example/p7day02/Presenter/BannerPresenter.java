package com.example.p7day02.Presenter;

import com.example.p7day02.BannerContract.BannerContract;
import com.example.p7day02.Bean.BanBean;
import com.example.p7day02.Model.BannerModel;
import com.example.p7day02.Net.NetCallBack;
import com.example.p7day02.Net.NetConstant;

import java.util.List;

public class BannerPresenter implements BannerContract.IBannerPresenter {
    private BannerContract.IBannerView iBannerView;
    private BannerContract.IBannerModel iBannerModel;

    public BannerPresenter(BannerContract.IBannerView iBannerView) {
        iBannerModel = new BannerModel(this);
        this.iBannerView = iBannerView;
    }

    @Override
    public void getData() {
        iBannerModel.getBannerData(NetConstant.BASEBANNERURL, new NetCallBack<BanBean>() {
            @Override
            public void OnSuccess(BanBean banBean) {
                List<BanBean.BannerlistBean> bannerlist = banBean.getBannerlist();
                iBannerView.onSuccess(bannerlist);
            }

            @Override
            public void OnFail(String error) {
                iBannerView.onFail(error);
            }
        });
    }
}
