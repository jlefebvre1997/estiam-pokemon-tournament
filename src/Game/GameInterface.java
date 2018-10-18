package Game;

import Model.Pokemon.Pokemon;

public interface GameInterface {
    void main();

    static void turn(int index, Pokemon p1, Pokemon p2) {
        if (index % 2 == 0) {
            int attack = p1.attack();
            p2.losesHealthPoints(attack);
        } else {
            int attack = p2.attack();
            p1.losesHealthPoints(attack);
        }
    }
}
