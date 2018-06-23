package com.diegodobelo.fineweather.injection

import com.diegodobelo.fineweather.BuildConfig
import com.diegodobelo.fineweather.network.DarkSkyService
import com.google.gson.Gson
import com.google.gson.GsonBuilder

import java.lang.reflect.Modifier

import javax.inject.Named
import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    companion object {
        const val NAME_BASE_URL = "NAME_BASE_URL"
        const val NAME_KEY = "NAME_KEY"
    }

    @Provides
    @Named(NAME_BASE_URL)
    fun provideBaseUrlString(): String {
        return BuildConfig.SERVER_BASE_URL
    }

    @Provides
    @Named(NAME_KEY)
    fun provideApiKey(): String {
        return BuildConfig.API_KEY
    }

    @Provides
    @Singleton
    fun providesGson(): Gson {
        return GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .create()
    }

    @Provides
    @Singleton
    fun provideGsonConverter(gson: Gson): Converter.Factory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    fun provideOkHttpBuilder(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
                .hostnameVerifier { hostname, session -> true }
    }

    @Provides
    @Singleton
    fun provideLogInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
    }

    @Provides
    @Singleton
    fun provideRetrofit(converter: Converter.Factory,
                                 clientBuilder: OkHttpClient.Builder,
                                 interceptor: HttpLoggingInterceptor,
                                 @Named(NAME_BASE_URL) url: String,
                                 @Named(NAME_KEY) key: String): Retrofit {
        clientBuilder.addInterceptor(interceptor)

        clientBuilder.addInterceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                    .method(original.method(), original.body())
                    .build()
            chain.proceed(request)
        }
        return Retrofit.Builder()
                .client(clientBuilder.build())
                .baseUrl("$url$key/")
                .addConverterFactory(converter)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    internal fun provideApiEndpoint(retrofit: Retrofit): DarkSkyService {
        return retrofit.create(DarkSkyService::class.java)
    }
}
