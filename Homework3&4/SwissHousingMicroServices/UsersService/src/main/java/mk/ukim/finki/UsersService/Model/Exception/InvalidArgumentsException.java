package mk.ukim.finki.UsersService.Model.Exception;

public class InvalidArgumentsException extends RuntimeException{
    public InvalidArgumentsException() {
        super("The arguments that you've entered are invalid");
    }
}
