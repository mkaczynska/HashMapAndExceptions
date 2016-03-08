/**
 * Class NullKeyException handles the exception which occurs when value of key is null
 */
public class NullKeyException extends Exception {
    private String message;

    /**
     * Constructor that sets error message
     */
    public NullKeyException() {
        this.message="Key cannot be null.\n";
    }

    /**
     * @return message String error message
     */
    @Override
    public String getMessage(){
        return message;
    }
}
