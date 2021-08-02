package Player;

//23 Jul 2021
/**
 *
 * @author cen7
 *
 */

/*
 * private Weapon knife = new Weapon("knife", 1000, 10); 
 * private Weapon sniper =new Weapon("sniper", 10000, 65); 
 * private Weapon kalashnikov = new Weapon("kalashnikov", 20000, 40);
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PlayerStatus.setGameName("MindBattle");
		/************************************** name**lives**score ****/
		/***********************************************************/
		PlayerStatus goofy = new PlayerStatus("Goofy", 3, 20000);
		PlayerStatus guido = new PlayerStatus("Guido", 3, 20000);

		goofy.setWeaponInHand(3);
		guido.setWeaponInHand(2);

		goofy.attackEnemy(guido);

		System.out.println("First atack");

		System.out.println(goofy.toString());
		System.out.println(guido.toString());

		System.out.println("Second atack, \ngoofy is moving to position X10, Y100 ");
		System.out.println(" guido is moving towards goofy X300, Y90");

		goofy.movePlayerTo(10, 100);
		guido.movePlayerTo(300, 90);
		goofy.attackEnemy(guido);

		System.out.println(goofy.toString());
		System.out.println(guido.toString());

		System.out.println("Third attack \nguido is running ");
		guido.movePlayerTo(4305, 2750);
		goofy.attackEnemy(guido);

		System.out.println(goofy.toString());
		System.out.println(guido.toString());

//		if (guido.shouldAttackOpponent(goofy)) {
//			System.out.println("Guido win");
//		} else
//			System.out.println("Guido lost");
//		System.out.println("After battle============================");
//		System.out.println(goofy.toString());
//		System.out.println(guido.toString());
	}

}