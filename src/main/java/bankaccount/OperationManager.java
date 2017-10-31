package bankaccount;

/**
 * @author L.BOUKHERROUB
 * Cette classe Manager permettrait d'assurer l'unicit� de l'Id pour chaque op�ration 
 */
public final class OperationManager {

	public static Integer getNextOperationId() {
		return OperationContext.getOperationContextInstance().getNbOperations() + 1 ;
	}
}
