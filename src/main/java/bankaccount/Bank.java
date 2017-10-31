package bankaccount;

import java.util.HashSet;
import java.util.Set;

import utils.Address;

/**
 * @author L. BOUKHERROUB
 * la banque est représentée par une classe Singleton
 */
public final class Bank {
	private String name;
	private Address address;
	private static Bank bank = null;
	// on utilise un HashSet pour stocker la liste des comptes de la banque pour éviter les doublons
	private static Set<Agency> agences = new HashSet<Agency>();

	private Bank () {
	}
	
	public static Bank getBankInstance() {
		if (bank!= null) {
			return bank;
		}
		bank = new Bank();
		return bank;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public static void setAgences(Set<Agency> agences) {
		Bank.agences = agences;
	}

	public static Set<Agency> getAgences() {
		return agences;
	}

	public void addAgency(Agency agency) {
		getAgences().add(agency);
	}
}
