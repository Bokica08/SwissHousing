package mk.ukim.finki.tech_prototype.Model.Exception;

public class LocationNotFoundException extends RuntimeException{
    public LocationNotFoundException() {
        super("The location does not exist");
    }
}
