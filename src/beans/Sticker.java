package beans;

public class Sticker {
//	Nummer, Kurzbezeichnung, Marktwert etc.
	
	private int id;
	private String team;
    private String name;
    
    private int count = 0;
    
    public Sticker(String team, String name) {
        this.id = count++;
        this.team = team;
        this.name = name;
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
	
}
