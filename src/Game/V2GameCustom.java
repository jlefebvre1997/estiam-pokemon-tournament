package Game;

public class V2GameCustom extends V2Game implements GameInterface {
    public V2GameCustom() {
        System.out.println("Choisissez un nom pour l'équipe du joueur 1");
        this.player1.setTeamName(this.scan.nextLine());
        System.out.println("Choisissez un nom pour l'équipe du joueur 2");
        this.player2.setTeamName(this.scan.nextLine());
    }

    @Override
    void fill() {
        this.player1.fillTeam(this.factory, this.scan);
        this.player2.fillTeam(this.factory, this.scan);
    }
}
