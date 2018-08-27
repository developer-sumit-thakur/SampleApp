
package com.example.sumitthakur.doordashlite.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Amount {

    @SerializedName("display_string")
    @Expose
    public String displayString;
    @SerializedName("unit_amount")
    @Expose
    public Integer unitAmount;

}
