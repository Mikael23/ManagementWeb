package management;

public class UnauthorizedException extends Exception {


    String message;


    public UnauthorizedException() {
    }

    public UnauthorizedException(String message) {
        super(message);

    }
}
