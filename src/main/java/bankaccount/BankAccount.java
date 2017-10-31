package bankaccount;

import java.util.Date;
import common.Identifiable;

/**
 * @author L. BOUKHERROUB
 */
public class BankAccount implements Identifiable {
	//id unique qui permet d'identifier un compte
	private Integer bankAccountId;
	private double balance;
	// un compte peut appartenir à plusieurs personnes en même temps. Dans ce cas on utilisera un Set de Clients
	private Client client;
	private Agency agency;
	private Date createdDate;
	
	/**
	 * Initialement le solde est à 0
	 * Dès que le compte est créé, il sera ajouté à la liste des comptes de notre banque
	 * On associe un Set d'opérations (vide) dès la création de notre compte
	 * @param client correpond à la personne pour laquelle un compte sera créé
	 */
	public BankAccount(Integer bankAccountId, Client client, Agency agency) {
		this.bankAccountId = bankAccountId;
		this.balance = 0;
		this.client = client;
		this.createdDate = new Date ();
		this.agency = agency;
		AgencyContext.getAgencyInstance().addBankAccountToAgency(agency, this);
		
		OperationContext operationContextInstance = OperationContext.getOperationContextInstance();
		operationContextInstance.addBankAccount(this);
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	

	public Integer getId() {
		return bankAccountId;
	}

	public void setId(Integer id) {
		bankAccountId = id;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	/**
	 * @param toDeposit : correpond au montant à déposer 
	 * Cette méthode permet de déposer de l'argent dans un  compte bancaire.
	 * On crée un Objet de type Opération qu'on associe au compte bancaire.
	 * Ceci nous permettera d'avoir l'historique de toutes les opérations de dépôt effectuées sur le compte.
	 */
	public void deposit (double toDeposit) {
		setBalance(getBalance() + toDeposit);
		Operation depositOperation = new Operation(this, OperationTypeEnum.DEPOT, toDeposit, getBalance());
		OperationContext operationContextInstance = OperationContext.getOperationContextInstance();
		operationContextInstance.addOperationForAccount(this, depositOperation);
		System.out.println(" Vous venez de verser " + toDeposit + " euros sur votre compte bancaire."
				+ " Votre nouveau solde est de :" + getBalance() + " euros\n");
	}

	/**
	 * @param toRetreive : correpond au montant à retirer
	 * Cette méthode permet de retirer de l'argent de son compte bancaire.
	 * On crée un Objet de type Opération qu'on associe au compte bancaire.
	 * Ceci nous permettera d'avoir l'historique de toutes les opérations de retrait effectuées sur le compte.
	 */
	public void retreive (double toRetreive) {
		if (toRetreive > getBalance()) {
			System.out.println(" Le montant à retirer dépasse votre solde de compte!");
		} else {
			setBalance(getBalance() - toRetreive);
			Operation retreiveOperation = new Operation(this, OperationTypeEnum.RETRAIT, toRetreive, getBalance());
			OperationContext operationContextInstance = OperationContext.getOperationContextInstance();
			operationContextInstance.addOperationForAccount(this, retreiveOperation); 
			System.out.println(" Vous venez de retirer "+ toRetreive + " euros de votre compte bancaire."
					+ " Votre nouveau solde est de :" + getBalance() + " euros\n");
		}
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getClient().getInformationResume()).append("   ").append(getId())
		.append("   ").append(getBalance());
		return sb.toString();
	}
}
