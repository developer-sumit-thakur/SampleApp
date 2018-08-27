
package com.example.sumitthakur.doordashlite.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Discount {

    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("source_type")
    @Expose
    public String sourceType;
    @SerializedName("text")
    @Expose
    public String text;
    @SerializedName("discount_type")
    @Expose
    public String discountType;
    @SerializedName("amount")
    @Expose
    public Amount amount;
    @SerializedName("min_subtotal")
    @Expose
    public MinSubtotal minSubtotal;

}
