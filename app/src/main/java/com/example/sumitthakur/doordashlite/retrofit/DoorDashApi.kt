package com.example.sumitthakur.doordashlite.retrofit

import com.example.sumitthakur.doordashlite.model.Restaurant
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient

class DoorDashApi {

    interface ResponseListener {
        fun onSuccess(respones: List<Restaurant>)
        fun onError(errorMsg: String)
    }

    companion object {
        private val baseUrl = "https://api.doordash.com/v2/restaurant/?lat=37.422740&lng=-122.139956"

        lateinit var dataService: AddressServiceInterface
        private var instance: DoorDashApi? = null

        fun getInstance(): DoorDashApi {
            if (instance == null) instance = DoorDashApi()
            return instance as DoorDashApi
        }
    }

    fun initService() {

        val clientBuilder = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        clientBuilder.addInterceptor(loggingInterceptor)

        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(clientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        dataService = retrofit.create<AddressServiceInterface>(AddressServiceInterface::class.java)
    }

    fun getRestraurants(responseListener: ResponseListener): Observable<List<Restaurant>>? {
        var retVal: Observable<List<Restaurant>>? = null

        try {
            dataService.getRestaurantList(baseUrl)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : DisposableObserver<List<Restaurant>>() {
                        override fun onComplete() {}

                        override fun onNext(value: List<Restaurant>) {
                            if (responseListener != null) {
                                responseListener.onSuccess(value)
                            }
                        }

                        override fun onError(e: Throwable) {
                            if (responseListener != null) {
                                responseListener.onError("error: ${e.message}")
                            }
                        }
                    })
        } catch (ex: Exception) {
            if (responseListener != null) {
                responseListener.onError("error: ${ex.message}")
            }
        }

        return retVal
    }
}