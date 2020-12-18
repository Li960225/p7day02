package com.example.p7day02.Model;

import com.example.mvplibrary.Base.BaseModel;
import com.example.mvplibrary.Net.NetCallBack;
import com.example.mvplibrary.Net.NetUtils;
import com.example.p7day02.BannerContract.BannerContract;
import com.example.p7day02.Presenter.BannerPresenter;

public class BannerModel extends BaseModel implements BannerContract.IBannerModel {
    private BannerPresenter bannerPresenter;

    public BannerModel(BannerPresenter bannerPresenter) {
        this.bannerPresenter = bannerPresenter;
    }

    @Override
    public <T> void getBannerData(String url, NetCallBack<T> callBack) {
        NetUtils.getNetUtils().get(url,callBack);
    }
}
