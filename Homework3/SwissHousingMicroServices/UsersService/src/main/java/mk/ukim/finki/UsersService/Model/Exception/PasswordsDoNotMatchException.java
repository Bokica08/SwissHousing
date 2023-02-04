package mk.ukim.finki.UsersService.Model.Exception;

public class PasswordsDoNotMatchException extends RuntimeException{
    public PasswordsDoNotMatchException() {
        super("Passwords do not match exception.");
    }
}
