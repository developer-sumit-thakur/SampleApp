package com.example.sumitthakur.doordashlite.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.sumitthakur.doordashlite.model.Restaurant
import com.example.sumitthakur.doordashlite.retrofit.DoorDashApi
import com.google.gson.Gson

class RestaurantsViewModel : ViewModel() {

    companion object {
        private val TAG: String = RestaurantsViewModel::class.java.simpleName
    }

    lateinit var doorDashApi: DoorDashApi

    var restaurantsList: MutableLiveData<List<Restaurant>>? = null
        get() {
            if (field == null) {
                field = MutableLiveData()
            }
            loadData(field)
            return field
        }

    private fun loadData(result: MutableLiveData<List<Restaurant>>?) {
        result?.apply {
            Log.d(TAG, "loadData()")
            doorDashApi = DoorDashApi.getInstance()
            doorDashApi.initService()
            doorDashApi.getRestraurants(object : DoorDashApi.ResponseListener {
                override fun onSuccess(response: List<Restaurant>) {
                    Log.d(TAG, "Response : " + Gson().toJson(response.toString()))
                    result?.postValue(response)
                }

                override fun onError(errorMsg: String) {
                    Log.e(TAG, errorMsg)
                    result?.postValue(null)
                }
            })
        }
    }
}