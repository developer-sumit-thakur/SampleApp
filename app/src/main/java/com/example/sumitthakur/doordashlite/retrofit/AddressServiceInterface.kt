package com.example.sumitthakur.doordashlite.retrofit

import com.example.sumitthakur.doordashlite.model.Restaurant
import io.reactivex.Observable
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Url

interface AddressServiceInterface {
    @GET
    fun getRestaurantList(@Url url: String): Observable<List<Restaurant>>
}