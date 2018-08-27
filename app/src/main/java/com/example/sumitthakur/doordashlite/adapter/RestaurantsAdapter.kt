package com.example.sumitthakur.doordashlite.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.budiyev.android.imageloader.ImageLoader
import com.example.sumitthakur.doordashlite.R
import com.example.sumitthakur.doordashlite.model.Restaurant


class RestaurantsAdapter(private var restaurantsList: List<Restaurant>)
    : RecyclerView.Adapter<RestaurantsAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return if (restaurantsList != null) restaurantsList?.size else 0
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView
        var distance: TextView
        var cusineType: TextView
        var restaurantImage: ImageView

        init {
            name = view.findViewById(R.id.restaurant_name)
            distance = view.findViewById(R.id.restaurant_distance)
            cusineType = view.findViewById(R.id.cuisine_type)
            restaurantImage = view.findViewById(R.id.restaurant_image)
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

        ImageLoader.with(holder.itemView.context).from(restaurantsList[position].coverImgUrl).load(holder.restaurantImage)
    }
}
