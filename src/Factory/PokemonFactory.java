package Factory;

import Exception.PokemonNotFoundException;
import Model.Pokemon.Pokemon;

public class PokemonFactory {
    private static PokemonFactory instance;

    private PokemonFactory() {}

    public static PokemonFactory getInstance() {
        if (instance == null) {
            instance = new PokemonFactory();
        }

        return instance;
    }

    public Pokemon create(String name, int level, String type) throws Exception {
        try {
            return (Pokemon)Class.forName(type).getConstructor(String.class, int.class).newInstance(name, level);
        } catch (Exception e) {
            throw new PokemonNotFoundException(type);
        }
    }
}
