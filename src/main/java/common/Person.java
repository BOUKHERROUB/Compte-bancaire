package common;
import utils.Address;

/**
 * @author L. BOUKHERROUB
 * Cette calsse est réutilisable pour la création de classes telles que Client, Employé de la banque ...
 *
 */
public class Person implements Identifiable {
	
	private Integer personId;
	private String name; 
	private String fullName;
	private String dateOfBirth;
	private Address address;
	private String phoneNumber;
	private String mailAddress;
	
	public Person(String name, String fullName, String dateOfBirth, Address address, 
			String phoneNumber, String mailAddress) {
		this.name = name; 
		this.fullName = fullName;
		this.address = address; 
		this.phoneNumber = phoneNumber;
		this.mailAddress =  mailAddress;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Integer getId() {
		return personId;
	}
	
	public void setId(Integer id) {
		personId = id;
	}
	
	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getName()).append("   ").append(getFullName()).append("   ").append(getDateOfBirth())
		.append(getAddress().toString()).append("   ").append(getPhoneNumber().toString()).append("   ")
		.append(getMailAddress());
		return  sb.toString();
	}
}
