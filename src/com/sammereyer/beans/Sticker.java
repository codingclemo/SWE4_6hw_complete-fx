package com.sammereyer.beans;

public class Sticker {
	
	private int id;
	private String team;
    private String name;
    private int numberOfTickets;
    
    private int count = 0;
    
    public Sticker(String team, String name, int numberOfTickets) {
        this.id = count++;
        this.team = team;
        this.name = name;
        this.numberOfTickets = numberOfTickets;
    }
    
    public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}

	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}
	
}
