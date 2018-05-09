package beans;

public class Region {
	
    private int id;
    private String name;
    private int countryId;
    
    private int count = 0;
    
    public Region(String name, int countryId) {
        this.id = count++;
        this.name = name;
        this.countryId = countryId;
    }
    
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public int getId() {
		return id;
	}
	 
}
