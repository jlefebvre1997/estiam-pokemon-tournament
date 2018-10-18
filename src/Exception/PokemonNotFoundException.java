package Exception;

public class PokemonNotFoundException extends Exception {
    private String type;

    public PokemonNotFoundException(String type) {
        this.type = type;
    }

    @Override
    public String getMessage() {
        return "Can't find a pokemon named " + type + ".";
    }
}
