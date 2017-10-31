package bankaccount;

import utils.Address;
import common.Identifiable;

/**
 * @author L. BOUKHERROUB
 * Cette classe permet de représenter une Agence de la banque.
 * l'attribut headOffice vaut 1 si l'agence est le siège social de la banque  0 sinon
 */
public class Agency implements Identifiable {

	private Integer agencyId;
	private Bank bank;
	private Address address;
	private String phoneNumber;
	private Integer headOffice;
	private Employee agencyManager;
	
	public Agency( Address address, String phoneNumber,
			Integer headOffice, Employee agencyManager) {
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.headOffice = headOffice;
		this.agencyManager = agencyManager;
		this.bank = Bank.getBankInstance();
		Bank.getBankInstance().addAgency(this);
		AgencyContext.getAgencyInstance().addAgency(this);
	}

	public Integer getId() {
		return agencyId;
	}

	public void setId(Integer id) {
		this.agencyId = id;
	}

	public Integer getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
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

	public Integer getHeadOffice() {
		return headOffice;
	}

	public void setHeadOffice(Integer headOffice) {
		this.headOffice = headOffice;
	}

	public Employee getAgencyManager() {
		return agencyManager;
	}

	public void setAgencyManager(Employee agencyManager) {
		this.agencyManager = agencyManager;
	}
	
	public Bank getBank() {
		return bank;
	}
}
