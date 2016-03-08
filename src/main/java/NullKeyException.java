/**
 * Created by INV-6179 on 08.03.2016.
 */
public class NullKeyException extends Exception {
    private String message;
    public NullKeyException() {
        this.message="NullKeyException. Key cannot be null.\n";
    }
    @Override
    public String getMessage(){
        return message;
    }
}
