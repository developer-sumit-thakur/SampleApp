
package com.example.sumitthakur.doordashlite.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties("ignoreUnknown")
public class Restaurant {

    @SerializedName("phone_number")
    @Expose
    public String phoneNumber;
    @SerializedName("yelp_review_count")
    @Expose
    public Integer yelpReviewCount;
    @SerializedName("is_consumer_subscription_eligible")
    @Expose
    public Boolean isConsumerSubscriptionEligible;
    @SerializedName("offers_delivery")
    @Expose
    public Boolean offersDelivery;
    @SerializedName("max_order_size")
    @Expose
    public Object maxOrderSize;
    @SerializedName("delivery_fee")
    @Expose
    public Integer deliveryFee;
    @SerializedName("max_composite_score")
    @Expose
    public Integer maxCompositeScore;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("average_rating")
    @Expose
    public Float averageRating;
    @SerializedName("tags")
    @Expose
    public List<String> tags = null;
    @SerializedName("delivery_radius")
    @Expose
    public Integer deliveryRadius;
    @SerializedName("inflation_rate")
    @Expose
    public Float inflationRate;
    @SerializedName("menus")
    @Expose
    public List<Menu> menus = null;
    @SerializedName("show_store_menu_header_photo")
    @Expose
    public Boolean showStoreMenuHeaderPhoto;
    @SerializedName("composite_score")
    @Expose
    public Integer compositeScore;
    @SerializedName("offers_pickup")
    @Expose
    public Object offersPickup;
    @SerializedName("number_of_ratings")
    @Expose
    public Integer numberOfRatings;
    @SerializedName("status_type")
    @Expose
    public String statusType;
    @SerializedName("is_only_catering")
    @Expose
    public Boolean isOnlyCatering;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("delivery_fee_details")
    @Expose
    public DeliveryFeeDetails deliveryFeeDetails;
    @SerializedName("object_type")
    @Expose
    public String objectType;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("business")
    @Expose
    public Business business;
    @SerializedName("yelp_biz_id")
    @Expose
    public String yelpBizId;
    @SerializedName("asap_time")
    @Expose
    public Object asapTime;
    @SerializedName("yelp_rating")
    @Expose
    public Float yelpRating;
    @SerializedName("extra_sos_delivery_fee")
    @Expose
    public Integer extraSosDeliveryFee;
    @SerializedName("business_id")
    @Expose
    public Integer businessId;
    @SerializedName("special_instructions_max_length")
    @Expose
    public Object specialInstructionsMaxLength;
    @SerializedName("cover_img_url")
    @Expose
    public String coverImgUrl;
    @SerializedName("address")
    @Expose
    public Address address;
    @SerializedName("price_range")
    @Expose
    public Integer priceRange;
    @SerializedName("slug")
    @Expose
    public String slug;
    @SerializedName("show_suggested_items")
    @Expose
    public Boolean showSuggestedItems;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("is_newly_added")
    @Expose
    public Boolean isNewlyAdded;
    @SerializedName("is_good_for_group_orders")
    @Expose
    public Boolean isGoodForGroupOrders;
    @SerializedName("service_rate")
    @Expose
    public Float serviceRate;
    @SerializedName("merchant_promotions")
    @Expose
    public List<MerchantPromotion> merchantPromotions = null;
    @SerializedName("header_image_url")
    @Expose
    public Object headerImageUrl;

}
