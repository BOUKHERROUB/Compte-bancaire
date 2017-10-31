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
	// un compte peut appartenir � plusieurs personnes en m�me temps. Dans ce cas on utilisera un Set de Clients
	private Client client;
	private Agency agency;
	private Date createdDate;
	
	/**
	 * Initialement le solde est � 0
	 * D�s que le compte est cr��, il sera ajout� � la liste des comptes de notre banque
	 * On associe un Set d'op�rations (vide) d�s la cr�ation de notre compte
	 * @param client correpond � la personne pour laquelle un compte sera cr��
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
	 * @param toDeposit : correpond au montant � d�poser 
	 * Cette m�thode permet de d�poser de l'argent dans un  compte bancaire.
	 * On cr�e un Objet de type Op�ration qu'on associe au compte bancaire.
	 * Ceci nous permettera d'avoir l'historique de toutes les op�rations de d�p�t effectu�es sur le compte.
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
	 * @param toRetreive : correpond au montant � retirer
	 * Cette m�thode permet de retirer de l'argent de son compte bancaire.
	 * On cr�e un Objet de type Op�ration qu'on associe au compte bancaire.
	 * Ceci nous permettera d'avoir l'historique de toutes les op�rations de retrait effectu�es sur le compte.
	 */
	public void retreive (double toRetreive) {
		if (toRetreive > getBalance()) {
			System.out.println(" Le montant � retirer d�passe votre solde de compte!");
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
