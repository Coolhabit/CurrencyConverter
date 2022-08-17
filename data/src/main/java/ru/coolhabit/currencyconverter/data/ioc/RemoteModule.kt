package ru.coolhabit.currencyconverter.data.ioc

import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.coolhabit.currencyconverter.data.network.CurrencyApi
import ru.coolhabit.currencyconverter.data.utils.API
import ru.coolhabit.currencyconverter.data.utils.ApiConstants
import javax.inject.Singleton

private const val APIKEY = "app_id"

@Module
class RemoteModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request()
            val url = request.url.newBuilder()
                .addQueryParameter(APIKEY, API.API_KEY)
                .build()
            val resultRequest = request.newBuilder().url(url).build()
            chain.proceed(resultRequest)
        }
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(ApiConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideCurrencyApi(retrofit: Retrofit): CurrencyApi = retrofit.create(CurrencyApi::class.java)
}

