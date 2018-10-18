package Game;

public class V2GameRandom extends V2Game implements GameInterface {
    public void fill(){
        this.player1.setTeam(this.facade.createTeam("Joueur 1"));
        this.player2.setTeam(this.facade.createTeam("Joueur 2"));
    }

    public V2GameRandom() {
        super();
        this.player1.setTeamName("Joueur 1");
        this.player2.setTeamName("Joueur 2");
    }
}
