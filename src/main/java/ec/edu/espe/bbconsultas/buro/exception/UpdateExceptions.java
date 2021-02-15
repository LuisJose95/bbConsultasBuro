package ec.edu.espe.bbconsultas.buro.exception;

/**
 *
 * @author soyjo
 */
public class UpdateExceptions extends Exception{
    
    private final String tableName;

    public UpdateExceptions(String tableName, String message) {
        super(message);
        this.tableName = tableName;
    }

    public UpdateExceptions(String tableName, String message, Throwable cause) {
        super(message, cause);
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }
    
}
