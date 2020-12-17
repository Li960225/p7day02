package com.example.p7day02.BannerContract;

import com.example.p7day02.Bean.BanBean;
import com.example.p7day02.Net.NetCallBack;

import java.util.List;

public class BannerContract {
    public interface IBannerView{
        void onSuccess(List<BanBean.BannerlistBean> bannerlistBeans);
        void onFail(String error);
    }

    public interface IBannerPresenter{
        void getData();
    }

    public interface IBannerModel{
        <T> void getBannerData(String url, NetCallBack<T> callBack);
    }
}
