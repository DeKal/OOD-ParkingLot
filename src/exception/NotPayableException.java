package exception;

public class NotPayableException extends Exception {
    @Override
    public String getMessage() {
        return "Not Enough Money in Account";
    }
}
