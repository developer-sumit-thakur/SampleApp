
package com.example.sumitthakur.doordashlite.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeliveryFeeMonetaryFields {

    @SerializedName("currency")
    @Expose
    public String currency;
    @SerializedName("display_string")
    @Expose
    public String displayString;
    @SerializedName("unit_amount")
    @Expose
    public Integer unitAmount;
    @SerializedName("decimal_places")
    @Expose
    public Integer decimalPlaces;

}
