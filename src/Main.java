import Facade.PokemonFacade;
import Factory.PokemonFactory;
import Game.*;
import Model.Player.Player;

import java.util.Scanner;

public class Main {
    private static final int V2_RANDOM_TYPE = 1;
    private static final int V2_CUSTOM_TYPE = 2;
    private static final int V1_RANDOM_TYPE = 3;
    private static final int V1_CUSTOM_TYPE = 4;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Quel type de tournoi souhaitez-vous organiser ?\n1 : Tournoi généré aléatoirement\n2 : Tournoi personnalisé\n3 : Tournoi généré aléatoirement (V1)\n4 : Tournoi personnalisé (V1)");
        int tournamentType = scan.nextInt();
        scan.nextLine();

        GameInterface game = new V1GameRandom();

        if (tournamentType == V2_RANDOM_TYPE) {
            game = new V2GameRandom();
        } else if (tournamentType == V2_CUSTOM_TYPE) {
            game = new V2GameCustom();
        } else if (tournamentType == V1_RANDOM_TYPE) {
            game = new V1GameRandom();
        } else if (tournamentType == V1_CUSTOM_TYPE) {
            game = new V1GameCustom();
        } else {
            System.exit(0);
        }

        game.main();
    }
}
