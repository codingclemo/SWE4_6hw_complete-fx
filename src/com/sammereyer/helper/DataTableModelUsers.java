package com.sammereyer.helper;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DataTableModelUsers {
	
	private SimpleIntegerProperty id;
	private SimpleStringProperty username;
	private SimpleStringProperty country;
	private SimpleStringProperty region;
	private SimpleIntegerProperty stickersTotal;
	private SimpleIntegerProperty stickersDuplicate;
	private SimpleIntegerProperty stickersIntersect;
	

	public DataTableModelUsers(int id, String username, String country,String region, int stickersTotal, int stickersDuplicate, int stickersIntersect) {
		this.id = new SimpleIntegerProperty(id);
		this.username = new SimpleStringProperty(username);
		this.country = new SimpleStringProperty(country);
		this.region = new SimpleStringProperty(region);
		this.stickersTotal = new SimpleIntegerProperty(stickersTotal);
		this.stickersDuplicate = new SimpleIntegerProperty(stickersDuplicate);
		this.stickersIntersect = new SimpleIntegerProperty(stickersIntersect);
	}

	public int getId() {
		return id.get();
	}


	public void setId(int id) {
		this.id.set(id);
	}

	
	public String getUsername() {
		return username.get();
	}

	public void setUsername(String username) {
		this.username.set(username);
	}

	public String getCountry() {
		return country.get();
	}

	public void setCountry(String country) {
		this.country.set(country);
	}

	public String getRegion() {
		return region.get();
	}

	public void setRegion(String region) {
		this.region.set(region);
	}

	public int getStickersTotal() {
		return stickersTotal.get();
	}

	public void setStickersTotal(int stickersTotal) {
		this.stickersTotal.set(stickersTotal);
	}

	public int getStickersDuplicate() {
		return stickersDuplicate.get();
	}

	public void setStickersDuplicate(int stickersDuplicate) {
		this.stickersDuplicate.set(stickersDuplicate);
	}

	public int getStickersIntersect() {
		return stickersIntersect.get();
	}

	public void setStickersIntersect(int stickersIntersect) {
		this.stickersIntersect.set(stickersIntersect);
	}

	

}
