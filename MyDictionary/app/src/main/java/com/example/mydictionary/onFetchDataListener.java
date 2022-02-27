package com.example.mydictionary;

import com.example.mydictionary.Models.APIresponse;

public interface onFetchDataListener {

    void onFetchData(APIresponse apiResponse,String message);
    void onError(String message);
}
