package bankaccount;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author L. BOUKHERROUB
 * Cette classe Singleton permet de faire le lien entre (Agence - Compte bancaire), (Agence - Client) et (Agence - Employé)
 */
public final class AgencyContext {

private static AgencyContext agencyContextInstance = null;
	
	private static Map<Agency, Set<BankAccount>> agencyBankAccounts = new HashMap<Agency, Set<BankAccount>>();
	private static Map<Agency, Set<Client>> agencyClients =  new HashMap<Agency, Set<Client>>(); 
	private static Map<Agency, Set<Employee>> agencyEmployes =  new HashMap<Agency, Set<Employee>>();
	
	private AgencyContext() {
	}
	
	public static AgencyContext getAgencyInstance() {
		if (agencyContextInstance != null) {
			return agencyContextInstance;
		}
		agencyContextInstance = new AgencyContext();
		return agencyContextInstance;
	}
	
	/**
	 * Permet d'associer une liste de comptes bancaires, une liste de clients et une liste d'emplyés vides
	 *  à une gence à sa création.
	 * @param agency 
	 */
	public void addAgency(Agency agency) {
		agencyBankAccounts.put(agency, new HashSet<BankAccount>());
		agencyClients.put(agency, new HashSet<Client>());
		agencyEmployes.put(agency, new HashSet<Employee>());
	}
	
	/**
	 * permet d'associer un compte bancaire à une agence
	 * @param agency 
	 * @param bankAccount
	 */
	public void addBankAccountToAgency(Agency agency, BankAccount bankAccount) {
		agencyBankAccounts.get(agency).add(bankAccount);
	}
	
	/**
	 * @param agency : l'agence pour laquelle on souhoite récupérer la liste des comptes
	 * @return la liste des comptes bancaires d'une agence de la banque
	 */
	public Set<BankAccount> getAgencyBankAccounts(Agency agency) {
		return agencyBankAccounts.get(agency);
	}
	
	/**
	 * Permet d'associer un client à une agence
	 * @param agency
	 * @param client
	 */
	public void addClientToAgency(Agency agency, Client client) {
		agencyClients.get(agency).add(client);
	}
	
	/**
	 * @param agency : l'agence pour laquelle on souhaite retouner la liste de ses clients
	 * @return La liste de clients d'une agence
	 */
	public Set<Client> getAgencyClients(Agency agency) {
		return agencyClients.get(agency);
	}
	
	/**
	 * Permet d'associer un employé à une agence de la banque
	 * @param agency
	 * @param employee
	 */
	public void addEmployeeToAgency(Agency agency, Employee employee) {
		agencyEmployes.get(agency).add(employee);
	}
	
	/**
	 * @param agency
	 * @return la liste des employés de l'agence fournie en entrée
	 */
	public Set<Employee> getAgencyEmployes(Agency agency) {
		return agencyEmployes.get(agency);
	}
}
