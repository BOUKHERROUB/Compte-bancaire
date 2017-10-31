package bankaccount;

/**
 * @author L.BOUKHERROUB
 * Cette classe Manager permettrait d'assurer l'unicité de l'Id pour chaque opération 
 */
public final class OperationManager {

	public static Integer getNextOperationId() {
		return OperationContext.getOperationContextInstance().getNbOperations() + 1 ;
	}
}
