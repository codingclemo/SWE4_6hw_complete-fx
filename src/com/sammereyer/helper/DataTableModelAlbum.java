package com.sammereyer.helper;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DataTableModelAlbum {
	private SimpleIntegerProperty id;
	private SimpleStringProperty team;
	private SimpleStringProperty name;
	private SimpleIntegerProperty numberOfTickets;

	public DataTableModelAlbum(int id, String team, String name, int numberOfTickets) {
		this.id = new SimpleIntegerProperty(id);
		this.team = new SimpleStringProperty(team);
		this.name = new SimpleStringProperty(name);
		this.numberOfTickets = new SimpleIntegerProperty(numberOfTickets);
	}

	public String getTeam() {
		return team.get();
	}

	public String getName() {
		return name.get();
	}

	public int getId() {
		return id.get();
	}

	public int getNumberOfTickets() {
		return numberOfTickets.get();
	}

	public void setTeam(String t) {
		team.set(t);
	}

	public void setName(String n) {
		name.set(n);
	}

	public void setId(int i) {
		id.set(i);
	}

	public void setNumberOfTickets(int n) {
		numberOfTickets.set(n);
	}

}
