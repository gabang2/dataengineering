package com.fastcampus.de.clip18;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "https://reqres.in/";
    //BASE_URL에는 변하지 않는 URL주소를 입력해 주면 됩니다. 데이터의 위치에 따라 변하지 않는 주소를 말이죠.

    public static RetrofitService getApi() {
        return getInstance().create(RetrofitService.class);
    }//getInstance 메소드를 통해 인스턴스를 반환하게됩니다.

    private static Retrofit getInstance() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();//통신을 할 때 JSON 사용 및 해당 객체로의 파싱을 위해 생성합니다.
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();//서버에서는 JSON으로 응답하므로 우리는 build.gradle에 설정한 gson을 이용합니다.
    }
}
