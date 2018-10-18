package Game;

import Facade.PokemonFacade;
import Factory.PokemonFactory;
import Model.Player.Player;
import Model.Player.Team;
import Model.Pokemon.Pokemon;

import java.util.Scanner;

public abstract class V2Game implements GameInterface {
    Player player1;
    Player player2;
    Scanner scan;
    PokemonFacade facade;
    PokemonFactory factory;

    public V2Game() {
        this.player1 = new Player(new Team());
        this.player2 = new Player(new Team());
        this.scan = new Scanner(System.in);
        this.facade = PokemonFacade.getInstance();
        this.factory = PokemonFactory.getInstance();
    }

    @Override
    public void main() {
        this.fill();
        this.fight();
    }

    abstract void fill();

    private void fight() {
        Team team1 = this.player1.getTeam();
        Team team2 = this.player2.getTeam();

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
}
