package Model.Player;

import Facade.PokemonFacade;
import Factory.PokemonFactory;

import java.util.Scanner;

public class Player {
    private Team team;
    private String teamName;

    public Player(Team team) {
        this.team = team;
    }

    public boolean loses() {
        return this.team.size() == 0;
    }

    public Team getTeam() {
        return this.team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void fillTeam(PokemonFactory factory, Scanner scan) {
        for (int i = 0; i < 6; i++) {
            int pokemonType = Integer.MAX_VALUE;
            int length = PokemonFacade.pokemonTypes.length;

            while (pokemonType < 0 || pokemonType > length) {
                System.out.println("Quel type de pokemon voulez-vous ajouter à l'équipe " + this.getTeamName() + " ?");
                for (int j = 0; j < length; j++) {
                    System.out.println(j + " : " + PokemonFacade.pokemonTypes[j]);
                }

                pokemonType = scan.nextInt();
                scan.nextLine();

                if (pokemonType < 0 || pokemonType > length) {
                    System.out.println("Veuillez choisir un nombre entre 0 et " + length);
                }
            }


            System.out.println("Entrez un nom pour le pokemon numéro " + i + " de l'équipe " + this.getTeamName() + " : ");
            String name = scan.nextLine();
            System.out.println("Entrez son niveau : ");
            int lvl = scan.nextInt();
            scan.nextLine();

            try {
                this.getTeam().add(factory.create(
                        this.getTeamName() + " - " + name,
                        lvl,
                        PokemonFacade.pokemonTypes[pokemonType]
                ));
            } catch (Exception e) {
                System.out.println("La création du pokemon a échoué. Veuillez recommencer.");
                i--;
            }
        }
    }
}
