package bankaccount;

import common.Person;
import utils.Address;

/**
 * @author L. BOUKHERROUB
 * Classe qui représente un Client de la banque
 * L'attribut clientId pourrait être un nombre auto-incrémenté et unique
 */
public final class Client extends Person {

	private Integer clientId; 
	private Agency agency;
	
	public Client(Integer clientId, String name, String fullName, String dateOfBirth, Address adress, 
			String phoneNumber, String mailAddress, Agency agency) {
		super(name, fullName, dateOfBirth, adress, phoneNumber, mailAddress);
		this.clientId = clientId;
		this.agency = agency;
		AgencyContext.getAgencyInstance().addClientToAgency(agency, this);
	}

	@Override
	public Integer getId() {
		return clientId;
	}

	@Override
	public void setId(Integer id) {
		this.clientId = id;
	}
	
	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	@Override
	public String toString() {
		return new StringBuffer().append(getId()).append("   ").append(super.toString()).toString();
	}
	
	public String getInformationResume(){
		return new StringBuffer().append(getId()).append("   ").
				append(getName()).append("   ").append(getFullName()).toString();
	}
}
