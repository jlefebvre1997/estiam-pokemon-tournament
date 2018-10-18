package Model.Pokemon;

public class Caninos extends Pokemon {
    public static final String type = "Model.Pokemon.Caninos";

    public Caninos(String name, int level) {
        super(name, level);
    }

    @Override
    public int attack() {
        System.out.println(this.name + " attacks with his tail !");
        return this.attackPoints;
    }
}
