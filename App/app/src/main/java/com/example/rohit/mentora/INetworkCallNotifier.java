package com.example.rohit.mentora;

/**
 * Created by Rohit on 18-12-2015.
 */
public interface INetworkCallNotifier {
    void onSuccess(NetworkResponse response);

    void onFailure();
}

