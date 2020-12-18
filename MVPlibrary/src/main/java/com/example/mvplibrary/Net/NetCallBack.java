package com.example.mvplibrary.Net;

public interface NetCallBack<T> {
    void OnSuccess(T t);
    void OnFail(String error);
}
