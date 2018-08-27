
package com.example.sumitthakur.doordashlite.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Menu {

    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("menu_version")
    @Expose
    public Integer menuVersion;
    @SerializedName("subtitle")
    @Expose
    public String subtitle;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("open_hours")
    @Expose
    public List<List<OpenHour>> openHours = null;
    @SerializedName("is_business_enabled")
    @Expose
    public Object isBusinessEnabled;
    @SerializedName("is_catering")
    @Expose
    public Boolean isCatering;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("status_type")
    @Expose
    public String statusType;

}
