import Facade.PokemonFacade;
import Factory.PokemonFactory;
import Game.*;
import Model.Player.Player;

import java.util.Scanner;

public class Main {
    private static final int RANDOM_TYPE = 1;
    private static final int CUSTOM_TYPE = 2;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Quel type de tournoi souhaitez-vous organiser ?\n1 : Tournoi généré aléatoirement\n2 : Tournoi personnalisé\n3 : Tournoi généré aléatoirement (V1)\n4 : Tournoi personnalisé (V1)");
        int tournamentType = scan.nextInt();
        scan.nextLine();

        GameInterface game = new V1GameRandom();

        if (tournamentType == 1) {
            game = new V2GameRandom();
        } else if (tournamentType == 2) {
            game = new V2GameCustom();
        } else if (tournamentType == 3) {
            game = new V1GameRandom();
        } else if (tournamentType == 4) {
            game = new V1GameCustom();
        } else {
            System.exit(0);
        }

        game.main();
    }
}
