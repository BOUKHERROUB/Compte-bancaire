package bankaccount;

import java.text.DateFormat;
import java.util.Date;

import common.Identifiable;

/**
 * @author L. BOUKHERROUB
 * L'attribut operationId pourrait être un nombre auto-incrémenté et unique pour chaque opération
 */
public final class Operation implements Identifiable, Comparable<Operation> {
	
	private Integer operationId; 
	private Date operationDate;
	private OperationTypeEnum operationType;
	private BankAccount bankAccount;
	private double amount;
	private double balance;
	
	public Operation(BankAccount bankAccount, OperationTypeEnum operationType, double amount, double balance) {
		this.operationId = OperationManager.getNextOperationId();
		this.bankAccount = bankAccount;
		this.operationType = operationType;
		this.amount = amount;
		this.balance = balance;
		this.operationDate = new Date();
	}
	
	public Date getOperationDate() {
		return operationDate;
	}
	
	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}
	
	public OperationTypeEnum getOperationType() {
		return operationType;
	}
	
	public void setOperationType(OperationTypeEnum operationType) {
		this.operationType = operationType;
	}
	
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	public Integer getId() {
		return operationId;
	}
	
	public void setId(Integer id) {
		operationId = id;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		DateFormat mediumDateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
		StringBuffer sb =  new StringBuffer() ;
		sb.append(getOperationType())
		.append("   ").append(mediumDateFormat.format((getOperationDate()))).append(("   "))
		.append("   ").append(getAmount()).append("   ").append(getBalance());
		return sb.toString() ;
	}

	public int compareTo(Operation operation) {
		return operation.getOperationDate().compareTo(this.getOperationDate());
	}
																
}
