package Game;

import Model.Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class V1Game implements GameInterface {
    List<Pokemon> pokemons;

    V1Game() {
        this.pokemons = new ArrayList<>();
    }

    @Override
    public void main() {
        this.fill();
        this.fight();
    }

    public abstract void fill();

    private void fight() {
        Random rand = new Random();

        while(this.pokemons.size() != 1) {
            int index1 = rand.nextInt(this.pokemons.size());
            int index2 = rand.nextInt(this.pokemons.size());

            while (index2 == index1) {
                index2 = rand.nextInt(this.pokemons.size());
            }

            Pokemon p1 = this.pokemons.get(index1);
            Pokemon p2 = this.pokemons.get(index2);

            while(true) {
                int index = 0;

                GameInterface.turn(index, p1, p2);

                if (p1.faints()) {
                    this.pokemons.remove(p1);
                    p2.refillLife();
                    break;
                }

                if (p2.faints()) {
                    this.pokemons.remove(p2);
                    p1.refillLife();
                    break;
                }

                index++;
            }
        }

        System.out.println(this.pokemons.get(0).getName() + " wins !");
    }
}
