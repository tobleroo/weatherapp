package model;

public class WeatherBean {

	private String cityStr;

	private String countryStr;

	private String cloudsStr;

	private String sunRise;

	private String lastUpdate;

	private String dateOfSearch;

	public WeatherBean(String cityStr, String countryStr) {

		this.cityStr = cityStr;
		this.countryStr = countryStr;

	}

	public String getCityStr() {
		return cityStr;
	}

	public String getCountryStr() {
		return countryStr;
	}

	public String getCloudsStr() {
		return cloudsStr;
	}

	public void setCloudsStr(String cloudsStr) {
	this.cloudsStr = cloudsStr;
	}

	public void setCityStr(String cityStr) {
		this.cityStr = cityStr;
	}

	public void setCountryStr(String countryStr) {
		this.countryStr = countryStr;
	}

	public String getDateOfSearch() {
		return dateOfSearch;
	}

	public void setDateOfSearch(String dateOfSearch) {
		this.dateOfSearch = dateOfSearch;
	}

	public void setSunRise(String sunRise) {
		this.sunRise = sunRise;
	}

	public String getSunRise() {
		return sunRise;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	

	
		
		
		
		
		
		
		
		
		
		
		

}
