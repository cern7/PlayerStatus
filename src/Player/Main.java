package Player;

//23 Jul 2021
/**
 *
 * @author cen7
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PlayerStatus.setGameName("MindBattle");
		/************************************** name**lives**score ****/
		/***********************************************************/
		PlayerStatus goofy = new PlayerStatus("Goofy", 3, 15000);
		PlayerStatus guido = new PlayerStatus("Guido", 3, 15000);

		
		System.out.println("Goofy bought a Sniper: " + goofy.setWeaponInHand(2));
		System.out.println("Guido found an artifact 8128");
		guido.findArtifact(8128);
		System.out.println("Guido score update: " + guido.getScore());
		System.out.println("Guido bought an AK47: " + guido.setWeaponInHand(3));
		System.out.println("Distance between " + guido.getNickname() + " and " + goofy.getNickname() + " is " + guido.distanceBetweenPlayers(goofy));
		System.out.println("Guido score update(after purchase) : " + guido.getScore());
		System.out.println("Guido attacking Goofy: ");
		if (guido.shouldAttackOpponent(goofy)) {
			System.out.println("Guido win");
		} else
			System.out.println("Guido lost");

	}

}