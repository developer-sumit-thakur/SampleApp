
package com.example.sumitthakur.doordashlite.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Business {

    @SerializedName("business_vertical")
    @Expose
    public Object businessVertical;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;

}
