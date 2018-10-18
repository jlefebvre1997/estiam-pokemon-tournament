package Game;

import Facade.PokemonFacade;
import Factory.PokemonFactory;
import Model.Player.Player;
import Model.Player.Team;
import Model.Pokemon.Pokemon;

import java.util.Scanner;

public class V2GameRandom implements GameInterface {
    private Player player1;
    private Player player2;
    private Scanner scan;
    private PokemonFacade facade;
    private PokemonFactory factory;

    public V2GameRandom() {
        this.facade = PokemonFacade.getInstance();
        this.factory = PokemonFactory.getInstance();
        this.scan = new Scanner(System.in);
        this.player1 = new Player(this.facade.createTeam("Joueur 1"));
        this.player2 = new Player(this.facade.createTeam("Joueur 2"));
        this.player1.setTeamName("Joueur 1");
        this.player2.setTeamName("Joueur 2");
    }

    @Override
    public void main() {
        this.fight();
    }

    public void fight() {
        Team team1 = player1.getTeam();
        Team team2 = player2.getTeam();

        Pokemon p1 = team1.get();
        Pokemon p2 = team2.get();

        int index = 0;

        while (!player1.loses() && !player2.loses()) {
            System.out.println("-------------------- PLAYER 1 " + team1.size() + " POKEMONS REMAINING");
            System.out.println("-------------------- PLAYER 2 " + team2.size() + " POKEMONS REMAINING");

            while (true) {
                GameInterface.turn(index, p1, p2);

                if (p1.faints()) {
                    team1.remove(p1);

                    if (!player1.loses()) {
                        System.out.println(team1.size() + " pokemons remaining in " + player1.getTeamName() + " team !\n");
                        p1 = team1.get();
                    }

                    break;
                }

                if (p2.faints()) {
                    team2.remove(p2);

                    if (!player2.loses()) {
                        System.out.println(team2.size() + " pokemons remaining in " + player2.getTeamName() + " team !\n");
                        p2 = team2.get();
                    }

                    break;
                }

                index++;
            }
        }

        if (player1.getTeam().size() == 0) {
            System.out.println(player2.getTeamName() + " WINS");
        } else if (player2.getTeam().size() == 0) {
            System.out.println(player1.getTeamName() + " WINS");
        }
    }

//    private void checkIfLose(Pokemon p, Team t, Player p) {
//
//    }
}
