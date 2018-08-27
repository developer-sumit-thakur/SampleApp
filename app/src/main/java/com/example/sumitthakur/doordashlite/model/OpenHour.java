
package com.example.sumitthakur.doordashlite.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpenHour {

    @SerializedName("hour")
    @Expose
    public Integer hour;
    @SerializedName("minute")
    @Expose
    public Integer minute;

}
