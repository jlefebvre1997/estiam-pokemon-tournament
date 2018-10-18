package Game;

import Facade.PokemonFacade;
import Model.Pokemon.Pokemon;
import java.util.Random;

public class V1GameRandom extends V1Game implements GameInterface {
    public V1GameRandom() {
        super();
    }

    private static final int NB_POKEMONS = 10;

    public void fill() {
        PokemonFacade facade = PokemonFacade.getInstance();

        for (int i = 0; i < NB_POKEMONS; i++) {
            try {
                this.pokemons.add(facade.createRandomPokemon(i));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
