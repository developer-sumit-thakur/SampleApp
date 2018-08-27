
package com.example.sumitthakur.doordashlite.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("city")
    @Expose
    public String city;
    @SerializedName("subpremise")
    @Expose
    public String subpremise;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("printable_address")
    @Expose
    public String printableAddress;
    @SerializedName("state")
    @Expose
    public String state;
    @SerializedName("street")
    @Expose
    public String street;
    @SerializedName("country")
    @Expose
    public String country;
    @SerializedName("lat")
    @Expose
    public Float lat;
    @SerializedName("lng")
    @Expose
    public Float lng;
    @SerializedName("shortname")
    @Expose
    public String shortname;
    @SerializedName("zip_code")
    @Expose
    public String zipCode;

}
