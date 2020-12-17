package com.example.p7day02.Net;

public interface NetCallBack<T> {
    void OnSuccess(T t);
    void OnFail(String error);
}
