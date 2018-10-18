package Model.Player;

import Model.Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Exception.TeamIsFullException;

public class Team {
    private List<Pokemon> team;

    public Team() {
        this.team = new ArrayList<>();
    }

    public void add(Pokemon p) throws TeamIsFullException {
        if (this.team.size() == 6) {
            throw new TeamIsFullException();
        }

        this.team.add(p);
    }

    public void remove(Pokemon p) {
        this.team.remove(p);
    }

    public int size() {
        return this.team.size();
    }

    public Pokemon get() {
        Random rand = new Random();
        int index = rand.nextInt(this.team.size());
        return this.team.get(index);
    }

    public void displayTeam() {
        for (Pokemon p : this.team) {
            System.out.println(p);
        }
    }
}
