package Game;

import Facade.PokemonFacade;
import Factory.PokemonFactory;

import java.util.Scanner;

public class V1GameCustom extends V1Game {
    private Scanner scan;
    private PokemonFactory factory;

    public V1GameCustom() {
        this.scan = new Scanner(System.in);
        this.factory = PokemonFactory.getInstance();
    }

    @Override
    public void fill() {
        System.out.println("Combien de pokemons vont participer au tournoi ?");
        int nbPokemons = this.scan.nextInt();

        for (int i = 1; i < nbPokemons + 1; i++) {
            int pokemonType = Integer.MAX_VALUE;
            int length = PokemonFacade.pokemonTypes.length;

            while (pokemonType < 0 || pokemonType > length) {
                System.out.println("Quel type de pokemon voulez-vous ajouter au tournoi ?");
                for (int j = 0; j < length; j++) {
                    System.out.println(j + " : " + PokemonFacade.pokemonTypes[j]);
                }

                pokemonType = scan.nextInt();
                scan.nextLine();

                if (pokemonType < 0 || pokemonType > length) {
                    System.out.println("Veuillez choisir un nombre entre 0 et " + length);
                }
            }


            System.out.println("Entrez un nom pour le pokemon numéro " + i + " : ");
            String name = scan.nextLine();
            System.out.println("Entrez son niveau : ");
            int lvl = scan.nextInt();
            scan.nextLine();

            try {
                this.pokemons.add(factory.create(
                        name,
                        lvl,
                        PokemonFacade.pokemonTypes[pokemonType]
                ));
            } catch (Exception e) {
                System.out.println("La création du pokemon a échoué. Veuillez recommencer.");
                i--;
            }
        }
    }
}
