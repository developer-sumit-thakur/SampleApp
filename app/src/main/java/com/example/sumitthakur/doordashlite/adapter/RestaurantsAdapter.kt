package com.example.sumitthakur.doordashlite.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.budiyev.android.imageloader.ImageLoader
import com.example.sumitthakur.doordashlite.R
import com.example.sumitthakur.doordashlite.model.Restaurant


class RestaurantsAdapter(private var restaurantsList: List<Restaurant>, var listerner: OnItemChangeListener)
    : RecyclerView.Adapter<RestaurantsAdapter.ViewHolder>() {

    var favoriteRestaurants: HashSet<Int> = HashSet()

    interface OnItemChangeListener {
        fun onFavorite(isChecked: HashSet<Int>)
    }

    fun setFavorites(favorites: HashSet<Int>) {
        favoriteRestaurants = favorites
    }

    override fun getItemCount(): Int {
        return if (restaurantsList != null) restaurantsList?.size else 0
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView
        var distance: TextView
        var cusineType: TextView
        var restaurantImage: ImageView
        var favButton: CheckBox

        init {
            name = view.findViewById(R.id.restaurant_name)
            distance = view.findViewById(R.id.restaurant_distance)
            cusineType = view.findViewById(R.id.cuisine_type)
            restaurantImage = view.findViewById(R.id.restaurant_image)
            favButton = view.findViewById(R.id.fav_button)
        }
    }

    fun setRestaurants(location: List<Restaurant>) {
        this.restaurantsList = location
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsAdapter.ViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.item_list_view, parent, false)

        return ViewHolder(root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position % 2 == 0)
            holder.itemView.setBackgroundResource(R.color.itemViewColor1)
        else
            holder.itemView.setBackgroundResource(R.color.itemViewColor2)

        holder.name.setText(restaurantsList[position]?.name)
        holder.cusineType.setText(restaurantsList[position]?.description)
        holder.distance.setText(restaurantsList[position].status)
        holder.favButton.isChecked = false
        if (favoriteRestaurants.contains(restaurantsList[position].id)) {
            holder.favButton.isChecked = true
        }

        holder.favButton.setOnCheckedChangeListener { favButton, isChecked ->
            if (isChecked) {
                favoriteRestaurants.add(restaurantsList[position].id)
                listerner?.onFavorite(favoriteRestaurants)
            } else {
                if (favoriteRestaurants.contains(restaurantsList[position].id)) {
                    favoriteRestaurants.remove(restaurantsList[position].id)
                    listerner?.onFavorite(favoriteRestaurants)
                }
            }
        }

        ImageLoader.with(holder.itemView.context).from(restaurantsList[position].coverImgUrl).load(holder.restaurantImage)
    }
}
