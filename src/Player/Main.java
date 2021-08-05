package Player;

//23 Jul 2021
/**
 *
 * @author cen7
 *
 */
// private Weapon knife = new Weapon("knife", 1000, 10);
// private Weapon sniper = new Weapon("sniper", 10000, 65);
// private Weapon kalashnikov = new Weapon("kalashnikov", 20000, 40);

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        PlayerStatus.setGameName("MindBattle");
        /************************************** name**lives**score ****/
        /***********************************************************/
        PlayerStatus goofy = new PlayerStatus("Goofy", 3, 10000);
        PlayerStatus guido = new PlayerStatus("Guido", 3, 10000);
        PlayerStatus baloo = new PlayerStatus("Baloo", 3, 10000);

      
        // set knife as a weapon for all players;
        goofy.setWeaponInHand(1);
        guido.setWeaponInHand(1);
        baloo.setWeaponInHand(1);
        // Goofy found artifact perfect number 496
        goofy.findArtifact(496);
        // Guido found artifact prime number 11
        guido.findArtifact(11);
        // Baloo found artifact trap(even number and digit sum is divided by 3)
        baloo.findArtifact(300);

        System.out.println(goofy.toString());
        System.out.println(guido.toString());
        System.out.println(baloo.toString());
        System.out.println("-----------------");
        // moving players to different position
        goofy.movePlayerTo(301, 946);
        guido.movePlayerTo(946, 1254);
        baloo.movePlayerTo(5, 1257);

        // Goofy and Baloo found one more artifact perfect number
        goofy.findArtifact(28);
        baloo.findArtifact(28);
        // all tree players found

        System.out.println(goofy.toString());
        System.out.println(guido.toString());
        System.out.println(baloo.toString());
        System.out.println("-----------------");

        // Goofy bought kalashnikov
        // Guido and Baloo bought sniper
        goofy.setWeaponInHand(3);
        guido.setWeaponInHand(2);
        baloo.setWeaponInHand(2);
        
        System.out.println(goofy.toString());
        System.out.println(guido.toString());
        System.out.println(baloo.toString());
        System.out.println("-----------------");
        
        // Goofy and Guido check who he can attack;
       System.out.println("Goofy will win in the battle with Guido => " + goofy.shouldAttackOpponent(guido));
       System.out.println("Guido will win in the battle with Baloo => " + guido.shouldAttackOpponent(baloo));
       System.out.println("-----------------");
       
       // Guido attacks Goofy
       // Baloo attacks Goofy
       // Goofy attacks Baloo
       guido.attackEnemy(goofy);
       baloo.attackEnemy(goofy);
       goofy.attackEnemy(baloo);
       
       System.out.println(goofy.toString());
       System.out.println(guido.toString());
       System.out.println(baloo.toString());
       

        
    }

}