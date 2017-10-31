package bankaccount;

import java.util.Set;

/**
 * @author L. BOUKHERROUB
 *
 */
public class BankAccountTest {

	public static void main(String[] args) throws InterruptedException {
		Agency agency = new Agency(null, null, 0, null);
		Client client = new Client(60126232, "Dupré", "Benoit", null , null, null, null, agency);
		BankAccount bankAccount = new BankAccount(1222151299, client, agency);
		
		bankAccount.deposit(500);
		Thread.sleep(120);
		bankAccount.retreive(20);
		Thread.sleep(120);
		bankAccount.deposit(800);
		
		System.out.println("*********************************** COMPTE BANCAIRE ***********************************\n" );
		System.out.println("| IDENTIFIANT CLIENT | NOM ET PRENOM | IDENTIDIANT COMPTE | SOLDE |" );
		System.out.println("____________________________________________________________________________________________________" );
		System.out.println(bankAccount.toString() + "\n");
		displayOperationsForBankAccount(bankAccount); 
	}

	private static void displayOperationsForBankAccount(BankAccount bankAccount) {
		OperationContext operationContextInstance = OperationContext.getOperationContextInstance();
		Set<Operation> allOperationsForBankAccount = operationContextInstance.getAllOperationsForBankAccount(bankAccount);
		
		System.out.println("*********************************** LISTE DES  OPERATIONS BANCAIRES ***********************************\n" );
		System.out.println("| TYPE OPERATION | DATE | MONTANT | SOLDE | " );
		System.out.println("_______________________________________________________________________________________________________" );
		for (Operation operation : allOperationsForBankAccount) {
			System.out.println( operation.toString());
			System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _\n " );
		}
	}

}
