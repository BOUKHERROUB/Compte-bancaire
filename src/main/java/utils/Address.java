package utils;

/**
 * @author L. BOUKHERROUB
 *
 */
public final class Address {
	private Integer streetNumber;
	private String streetType;
	private String streetName;
	private String city;
	private Integer postCode;
	private String country;
	
	public Address(Integer streetNumber, String streetType, String streetName,
			 Integer postCode, String city, String country) {
		this.streetNumber = streetNumber;
		this.streetType = streetType;
		this.streetName = streetName;
		this.city = city;
		this.postCode = postCode;
		this.country = country;
	}

	public Integer getStreetNumber() {
		return streetNumber;
	}
	
	public void setStreetNumber(Integer streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public String getStreetType() {
		return streetType;
	}
	
	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public Integer getPostCode() {
		return postCode;
	}
	
	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getStreetNumber()).append(" ").append(getStreetType()).append(" ").
		append(getStreetName()).append(" ").append(getPostCode()).append(" ").
		append(getCity()).append(" ").append(getCountry());
		return sb.toString();
	}
	
}