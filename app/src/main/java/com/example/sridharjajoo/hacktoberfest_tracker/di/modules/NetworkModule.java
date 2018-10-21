package com.example.sridharjajoo.hacktoberfest_tracker.di.modules;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;

@Module(includes = ApiModule.class)
public class NetworkModule {

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .cache(cache)
                .build();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofitBuilder(@Named("jsonapi") Converter.Factory jsonApiConverter, OkHttpClient client) {
        return new Retrofit.Builder()
                .addConverterFactory(jsonApiConverter)
                .client(client)
                .baseUrl("https://api.github.com")
                .build();
    }
}
