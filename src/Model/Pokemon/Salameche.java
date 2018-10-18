package Model.Pokemon;

public class Salameche extends Pokemon {
    public static final String type = "Model.Pokemon.Salameche";

    public Salameche(String name, int level) {
        super(name, level);
    }

    @Override
    public int attack() {
        System.out.println(this.name + " attacks with fire !");
        return this.attackPoints;
    }
}
