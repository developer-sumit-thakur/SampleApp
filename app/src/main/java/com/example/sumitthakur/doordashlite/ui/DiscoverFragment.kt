package com.example.sumitthakur.doordashlite.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sumitthakur.doordashlite.R
import com.example.sumitthakur.doordashlite.adapter.RestaurantsAdapter
import com.example.sumitthakur.doordashlite.model.Restaurant
import com.example.sumitthakur.doordashlite.viewmodel.RestaurantsViewModel
import android.support.v7.widget.LinearLayoutManager
import android.R.id.edit




class DiscoverFragment : Fragment(), RestaurantsAdapter.OnItemChangeListener {
    override fun onFavorite(isChecked: HashSet<Int>) {
        Log.d(TAG, "onChecked changed.")
        updatePreferences(isChecked)
    }

    private fun updatePreferences(isChecked: HashSet<Int>) {
        this.activity?.apply {

            val editor = prefs?.edit()

            val theSet = HashSet<String>()
            for (l in isChecked) {
                theSet.add(l.toString())
            }
            editor?.putStringSet(PREFS_KEY, theSet)
            editor?.commit()
        }

    }

    companion object {
        val TAG: String = "DiscoverFragment"
        val PREFS_KEY = TAG + "FavoritePref"
    }

    lateinit var adapter: RestaurantsAdapter
    lateinit var recyclerView: RecyclerView
    private var mLayoutManager: RecyclerView.LayoutManager? = null
    var prefs: SharedPreferences? = null

    var restaurantsViewModel: RestaurantsViewModel? = null
    var fragmentListener: FragmentListener? = null

    interface FragmentListener {
        fun onSuccess()
        fun onError()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (activity is FragmentListener) {
            fragmentListener = activity as FragmentListener
        }

        prefs = activity?.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        restaurantsViewModel = ViewModelProviders.of(this).get(RestaurantsViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View = inflater.inflate(R.layout.discover_fragment, container, false)

        recyclerView = view.findViewById(R.id.restaurants_list)
        recyclerView.setHasFixedSize(true)
        mLayoutManager = LinearLayoutManager(activity)
        recyclerView.setLayoutManager(mLayoutManager)

        adapter = RestaurantsAdapter(ArrayList(), listerner = this)
        recyclerView.setAdapter(adapter)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        restaurantsViewModel?.restaurantsList?.observe(this, Observer {
            it?.apply { showUI(it) } ?: showError()
        })

    }

    override fun onDetach() {
        super.onDetach()
        fragmentListener = null
    }

    fun showError() {
        Log.d(TAG, "Error in getting response")
        fragmentListener?.onError()
    }

    fun showUI(result: List<Restaurant>) {
        Log.d(TAG, "Response : $result")
        fragmentListener?.onSuccess()
        takeIf { result.size > 0 }?.apply {

            val theSet = this.prefs?.getStringSet(PREFS_KEY, null)
            val setOfFavs: HashSet<Int> = HashSet()
            if (theSet != null && !theSet!!.isEmpty()) {
                for (s in theSet) {
                    setOfFavs.add(Integer.valueOf(s))
                }
                adapter?.setFavorites(setOfFavs)

            }

            adapter?.setRestaurants(result)
        }
    }
}