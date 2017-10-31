package bankaccount;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author L.BOUKHERROUB
 * Classe singleton qui permet de garder trace des dep�ts et retraits pour chaque compte bancaire
 * Permet d'associer � chaque compte bancaire la liste des op�rations effectu�es 
 */
public class OperationContext {
	
	private static OperationContext operationContextInstance = null;
	
	private static Map<BankAccount, Set<Operation>> bankAccountOperations = new HashMap<BankAccount, Set<Operation>>();
	
	private OperationContext() {
	}
	
	public static OperationContext getOperationContextInstance() {
		if (operationContextInstance != null) {
			return operationContextInstance;
		}
		operationContextInstance = new OperationContext();
		return operationContextInstance;
	}
	
	/**
	 * Permet d'alimenter l'historique des op�rations r�alis�es sur un compte bancaire
	 * @param banckAccount 
	 * @param operation
	 */
	public void addOperationForAccount(BankAccount banckAccount, Operation operation) {
		bankAccountOperations.get(banckAccount).add(operation);
	}
	
	/**
	 * Permet d'ajouter une compte bancaire pour lequel on veut sauvegarder l'historique des op�rations
	 * Les op�rations sont sauvegard�es dans un HashSet pour �viter d'avoir des doublons
	 * @param bankAccount : compte � rajouter � la Map
	 */
	public void addBankAccount(BankAccount bankAccount) {
		bankAccountOperations.put(bankAccount, new HashSet<Operation>());
	}
	
	/**
	 * @param account
	 * On convertit le HashSet en TreeSet pour ordonner les op�rations par date
	 * @return la liste des op�raions r�alis�es sur un compte bancaire
	 */
	public Set<Operation> getAllOperationsForBankAccount(BankAccount account) {
		return new TreeSet<Operation>(bankAccountOperations.get(account));
	}
	
	public Integer  getNbOperations() {
			Integer nbOperations = 0;
		for (Map.Entry<BankAccount,Set<Operation>> bo : bankAccountOperations.entrySet()) {
			nbOperations = nbOperations + bo.getValue().size();
		}
		return nbOperations;
	}
}
