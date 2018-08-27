
package com.example.sumitthakur.doordashlite.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MerchantPromotion {

    @SerializedName("minimum_subtotal_monetary_fields")
    @Expose
    public MinimumSubtotalMonetaryFields minimumSubtotalMonetaryFields;
    @SerializedName("delivery_fee")
    @Expose
    public Integer deliveryFee;
    @SerializedName("delivery_fee_monetary_fields")
    @Expose
    public DeliveryFeeMonetaryFields deliveryFeeMonetaryFields;
    @SerializedName("minimum_subtotal")
    @Expose
    public Object minimumSubtotal;
    @SerializedName("new_store_customers_only")
    @Expose
    public Boolean newStoreCustomersOnly;
    @SerializedName("id")
    @Expose
    public Integer id;

}
