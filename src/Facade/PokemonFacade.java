package Facade;

import Factory.PokemonFactory;
import Model.Player.Team;
import Model.Pokemon.Caninos;
import Model.Pokemon.Pikachu;
import Model.Pokemon.Pokemon;
import Model.Pokemon.Salameche;
import java.util.Random;

public class PokemonFacade {
    public static String[] pokemonTypes = {
            Pikachu.type,
            Salameche.type,
            Caninos.type
    };

    private static PokemonFacade instance;

    private PokemonFacade() {}

    public static PokemonFacade getInstance() {
        if (instance == null) {
            instance = new PokemonFacade();
        }

        return instance;
    }

    public Team createTeam(String teamName) {
        Random rand = new Random();

        int index = 0;

        PokemonFactory factory = PokemonFactory.getInstance();
        Team team = new Team();

        while(team.size() < 6) {
            try {
                Pokemon p = factory.create(
                        teamName + "-Pokemon-" + index++,
                        rand.nextInt(100) + 1,
                        pokemonTypes[rand.nextInt(pokemonTypes.length)]
                );

                team.add(p);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return team;
    }

    public Pokemon createRandomPokemon(int index) throws Exception {
        Random rand = new Random();
        PokemonFactory factory = PokemonFactory.getInstance();

        Pokemon p;

        try {
            p = factory.create(
                    "Pokemon - " + index,
                    rand.nextInt(100) + 1,
                    pokemonTypes[rand.nextInt(pokemonTypes.length)]
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        return p;
    }
}
