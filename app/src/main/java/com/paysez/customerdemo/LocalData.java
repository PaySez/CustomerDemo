package com.paysez.customerdemo;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class LocalData {
    @ColumnInfo(name = "status")
    @SerializedName("status")
    @Expose
    private String status;

    @ColumnInfo(name = "merchant_name")
    @SerializedName("merchant_name")
    @Expose
    private String merchantName;


    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "unique_id")
    @SerializedName("unique_id")
    @Expose
    private String uniqueId;



    @ColumnInfo(name = "amount")
    @SerializedName("amount")
    @Expose
    private String amount;

    @ColumnInfo(name = "purchase_purpose")
    @SerializedName("purchase_purpose")
    @Expose
    private String purchasePurpose;



    @ColumnInfo(name = "trans_id")
    @SerializedName("trans_id")
    @Expose
    private String transId;



    @ColumnInfo(name = "trans_status")
    @SerializedName("trans_status")
    @Expose
    private String transStatus;


    @ColumnInfo(name = "link_creation_date")
    @SerializedName("link_creation_date")
    @Expose
    private String linkCreationDate;


    @ColumnInfo(name = "link_expiry_date")
    @SerializedName("link_expiry_date")
    @Expose
    private String linkExpiryDate;


    @ColumnInfo(name = "paylink_url")
    @SerializedName("paylink_url")
    @Expose
    private String paylinkUrl;


    @ColumnInfo(name = "link_expiry_status")
    @SerializedName("link_expiry_status")
    @Expose
    private String linkExpiryStatus;

    @ColumnInfo(name = "pay_status_code")
    @SerializedName("pay_status_code")
    @Expose
    private String payStatusCode;


    @ColumnInfo(name = "rrn_no")
    @SerializedName("rrn_no")
    @Expose
    private String rrnNo;

    @ColumnInfo(name = "trans_type")
    @SerializedName("trans_type")
    @Expose
    private String transType;

    @ColumnInfo(name = "trans_data_time")
    @SerializedName("trans_datetime")
    @Expose
    private String transDatetime;

    @ColumnInfo(name = "masked_card")
    @SerializedName("masked_card")
    @Expose
    private String maskedCard;

    @ColumnInfo(name = "mobile_no")
    @Expose
    @SerializedName("mobile_no")
    private String mobile_no;

    @ColumnInfo(name = "email")
    @SerializedName("email")
    @Expose
    private String email;


    public LocalData() {
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile_no() {
        return mobile_no;
    }
    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPurchasePurpose() {
        return this.purchasePurpose;
    }

    public void setPurchasePurpose(String purchasePurpose) {
        this.purchasePurpose = purchasePurpose;
    }

    public String getTransId() {
        return this.transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getTransStatus() {
        return this.transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus;
    }

    public String getLinkCreationDate() {
        return this.linkCreationDate;
    }

    public void setLinkCreationDate(String linkCreationDate) {
        this.linkCreationDate = linkCreationDate;
    }
    public void setTransDatetime(String transDatetime) {
        this.transDatetime = transDatetime;
    }
    public String getTransDatetime() {
        return transDatetime;
    }
    public String getLinkExpiryDate() {
        return this.linkExpiryDate;
    }

    public void setLinkExpiryDate(String linkExpiryDate) {
        this.linkExpiryDate = linkExpiryDate;
    }

    public String getPaylinkUrl() {
        return this.paylinkUrl;
    }

    public void setPaylinkUrl(String paylinkUrl) {
        this.paylinkUrl = paylinkUrl;
    }

    public String getLinkExpiryStatus() {
        return this.linkExpiryStatus;
    }

    public void setLinkExpiryStatus(String linkExpiryStatus) {
        this.linkExpiryStatus = linkExpiryStatus;
    }

    public String getPayStatusCode() {
        return this.payStatusCode;
    }

    public void setPayStatusCode(String payStatusCode) {
        this.payStatusCode = payStatusCode;
    }

    public String getRrnNo() {
        return this.rrnNo;
    }

    public void setRrnNo(String rrnNo) {
        this.rrnNo = rrnNo;
    }

    public String getTransType() {
        return this.transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getMaskedCard() {
        return this.maskedCard;
    }

    public void setMaskedCard(String maskedCard) {
        this.maskedCard = maskedCard;
    }
}
