package mk.ukim.finki.LocationsService.Model.Exception;

public class LocationNotFoundException extends RuntimeException{
    public LocationNotFoundException() {
        super("The location does not exist");
    }
}
