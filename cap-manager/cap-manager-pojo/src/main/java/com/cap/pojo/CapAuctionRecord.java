package com.cap.pojo;

import java.util.Date;

public class CapAuctionRecord {
    private Integer id;

    private Long userId;

    private Long itemId;

    private Date auctiontime;

    private Long auctionprice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Date getAuctiontime() {
        return auctiontime;
    }

    public void setAuctiontime(Date auctiontime) {
        this.auctiontime = auctiontime;
    }

    public Long getAuctionprice() {
        return auctionprice;
    }

    public void setAuctionprice(Long auctionprice) {
        this.auctionprice = auctionprice;
    }
}