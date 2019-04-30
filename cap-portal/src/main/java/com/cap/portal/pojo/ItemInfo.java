package com.cap.portal.pojo;

import com.cap.pojo.CapItem;

public class ItemInfo extends CapItem {

	public String[] getImages() {
		String image = getImage();
		if (image != null) {
			String[] images = image.split(",");
			return images;
		}
		return null;
	}
}
