package mk.ukim.finki.tech_prototype.Model.Exception;

public class InvalidArgumentsException extends RuntimeException{
    public InvalidArgumentsException() {
        super("The arguments that you've entered are invalid");
    }
}
