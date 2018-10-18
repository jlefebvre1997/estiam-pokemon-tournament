package Exception;

public class TeamIsFullException extends Exception {
    @Override
    public String getMessage() {
        return "The team is full ! Remember that you can't have more than 6 pokemons in your team !";
    }
}
