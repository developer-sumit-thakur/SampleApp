
package com.example.sumitthakur.doordashlite.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeliveryFeeDetails {

    @SerializedName("final_fee")
    @Expose
    public FinalFee finalFee;
    @SerializedName("discount")
    @Expose
    public Discount discount;
    @SerializedName("surge_fee")
    @Expose
    public SurgeFee surgeFee;
    @SerializedName("original_fee")
    @Expose
    public OriginalFee originalFee;

}
