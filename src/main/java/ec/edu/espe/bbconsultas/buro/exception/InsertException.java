package ec.edu.espe.bbconsultas.buro.exception;

/**
 *
 * @author soyjo
 */
public class InsertException extends Exception{
    
    private final String tableName;

    public InsertException(String tableName, String message) {
        super(message);
        this.tableName = tableName;
    }

    public InsertException(String tableName, String message, Throwable cause) {
        super(message, cause);
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

}
