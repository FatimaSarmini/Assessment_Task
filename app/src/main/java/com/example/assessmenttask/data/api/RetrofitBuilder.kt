package com.example.assessmenttask.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val URL ="https://jsonplaceholder.typicode.com/"
    //CREATE HTTP CLIENT
    private val okHttp =OkHttpClient.Builder()

    //retrofit builder
    private val builder =Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    //create retrofit Instance
    private val retrofit = builder.build()

    //we will use this class to create an anonymous inner class function that
    //implements Country service Interface


    fun <T> buildService (serviceType :Class<T>):T{
        return retrofit.create(serviceType)
    }

//    private const val BASE_URL = "http://jsonplaceholder.typicode.com/"
//    private var sOkHttpClient: OkHttpClient? = null
//    private var sslContext: SSLContext? = null
//    private var sslSocketFactory: javax.net.ssl.SSLSocketFactory? = null
//    private fun getRetrofit(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(getOkHttpClient())
//            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//            .build()
//    }
//
//    private fun getOkHttpClient(): OkHttpClient? {
//        // Create an ssl socket factory with our all-trusting manager
//        sslSocketFactory = sslContext?.getSocketFactory()
//        val okHttpClientBuilder = OkHttpClient().newBuilder()
//            .connectTimeout(30, TimeUnit.SECONDS)
//            .readTimeout(30, TimeUnit.SECONDS)
//            .writeTimeout(30, TimeUnit.SECONDS)
//            .addInterceptor { chain ->
//                val original = chain.request()
//                //int maxAge = 60 * 60 * 24; // tolerate 1 day
//                val request = original.newBuilder()
//                    //.header("Content-Type", "application/x-www-form-urlencoded")
//                    .method(original.method(), original.body())
//                    .build()
//                chain.proceed(request)
//            }
//
//        sOkHttpClient = okHttpClientBuilder.build()
//
//
//        return sOkHttpClient
//    }
//
//    val apiService: ApiService = getRetrofit().create(ApiService::class.java)
}