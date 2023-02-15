package mk.ukim.finki.UsersService.Model.Exception;

public class LocationNotFoundException extends RuntimeException{
    public LocationNotFoundException() {
        super("The location does not exist");
    }
}
