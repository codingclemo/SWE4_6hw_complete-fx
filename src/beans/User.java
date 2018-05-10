package beans;

public class User {

	private int id;
	private String username;
	private String password;
	private String address;
	private int regionId;
	private int countryId;
	// private ArrayList<Integer> stickers;

	private int count = 0;

	public User(String username, String password, String address, int regionId, int countryId) {
		this.id = count++;
		this.username = username;
		this.password = password;
		this.address = address;
		this.regionId = regionId;
		this.countryId = countryId;

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	// public ArrayList<Integer> getStickers() {
	// return stickers;
	// }
	//
	// public void setStickers(ArrayList<Integer> stickers) {
	// this.stickers = stickers;
	// }

	public int getId() {
		return id;
	}

}
