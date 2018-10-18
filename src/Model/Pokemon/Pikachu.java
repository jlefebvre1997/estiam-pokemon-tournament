package Model.Pokemon;

public class Pikachu extends Pokemon {
    public static final String type = "Model.Pokemon.Pikachu";

    public Pikachu(String name, int level) {
        super(name, level);
    }

    @Override
    public int attack() {
        System.out.println(this.name + " attacks with lightning !");
        return this.attackPoints;
    }
}
