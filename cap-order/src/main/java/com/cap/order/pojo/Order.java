package com.cap.order.pojo;

import java.util.List;

import com.cap.pojo.CapOrder;
import com.cap.pojo.CapOrderItem;
import com.cap.pojo.CapOrderShipping;

public class Order extends CapOrder {

	private List<CapOrderItem> orderItems;
	private CapOrderItem orderItem;

    public CapOrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(CapOrderItem orderItem) {
        this.orderItem = orderItem;
    }

    private CapOrderShipping orderShipping;

	public List<CapOrderItem> getOrderItems() {

		return orderItems;
	}
	public void setOrderItems(List<CapOrderItem> orderItems) {

		this.orderItems = orderItems;
	}
	public CapOrderShipping getOrderShipping() {

		return orderShipping;
	}
	public void setOrderShipping(CapOrderShipping orderShipping) {

		this.orderShipping = orderShipping;
	}
	
	
}
