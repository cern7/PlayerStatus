package Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//22 Jul 2021
/**
 *
 * @author cen7
 *
 */
public class PlayerStatus {

	/********** Instance variables ************/
	/***************************************/

	private String nickname;
	private int score;
	private int lives;
	private double health = 100;
	private Weapon weaponInHand;
	private double positionX;
	private double positionY;
	private Weapon knife = new Weapon("knife", 1000, 10);
	private Weapon sniper = new Weapon("sniper", 10000, 75);
	private Weapon kalashnikov = new Weapon("kalashnikov", 20000, 50);

	/*****************************************/
	/********** Instance variables ************/
	/*
	 * 
	 */
	/************ Class variables *************/
	/***************************************/

	private static Map<Integer, Weapon> weaponList = new TreeMap<Integer, Weapon>();
	private static String gameName; // "MindBattle";
	private static final double mapDimX = 5000;
	private static final double mapDimY = 3000;

	/*****************************************/

	/*********** Class variables **************/
	/*
	 * 
	 */
	/********************** Constructors ******************/
	/****************************************************/

	public PlayerStatus(String nickname, int lives, int score) {
		this.nickname = nickname;
		this.lives = lives;
		this.score = score;
		/*
		 * Player will start the game from a pseudo random position with knife as
		 * default weapon
		 */
		setWeaponList(knife, sniper, kalashnikov);
		setInitPosition();
	}

	public PlayerStatus(String nickname, int lives) {
		this(nickname, lives, 0);
	}

	public PlayerStatus(String nickname) {
		this(nickname, 0, 0);
	}

	/****************************************************/

	/********************** Constructors ******************/
	/*
	 * 
	 */
	/********************** Getters + Setters( ******************/
	/********************************************************/
	public double getPositionX() {
		return positionX;
	}

	public String getNickname() {
		return nickname;
	}

	public double getPositionY() {
		return positionY;
	}

	public static String getGameName() {
		return gameName;
	}

	protected static void setGameName(String gameName) {
		PlayerStatus.gameName = gameName;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public int getScore() {
		return score;
	}

	public int getLives() {
		return lives;
	}

	public double getHealth() {
		return health;
	}

	public Weapon getWeaponInHand() {
		return weaponInHand;
	}

	/**********************************************************/

	/********************** Getters + Setters ****************/
	/*
	 * 
	 */
	/********************** Private functions ****************/
	/********************************************************/

	private void setInitPosition() {
		setPositionX((Math.random() * (mapDimX - 0)) + 0);
		setPositionY((Math.random() * (mapDimY - 0)) + 0);
	}

	private double distanceBetweenPlayers(PlayerStatus opponent) {

		return Math.sqrt(Math.pow((getPositionX() - opponent.getPositionX()), 2)
				+ Math.pow((getPositionY() - opponent.getPositionY()), 2));
	}

	private void setNickname(String nickname) {
		this.nickname = nickname;
	}

	private void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	private void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	private void scoreUpdate(int x) {
		score += x;
	}

	private void livesUpdate(int x) {
		lives += x;
		if (lives == 0) {
			System.out.println("GAME OVER");
		}
	}

	private boolean trap(int x) {
		if (x % 2 == 0 && sumDiv3(x)) {
			return true;
		}
		return false;
	}

	private boolean sumDiv3(int x) {
		int digitSum = 0;
		while (x > 0) {
			digitSum += x % 10;
			x /= 10;
		}
		if (digitSum % 3 == 0) {
			return true;
		} else
			return false;
	}

	private boolean isPrime(int x) {
		boolean is = true;
		for (int i = 2; i * i <= x; i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return is;
	}

	private boolean isPerfect(int x) {
		int copyN = x;
		for (int i = 1; i < x; i++) {
			if (x % i == 0) {
				copyN -= i;
			}
		}
		if (copyN == 0)
			return true;
		else
			return false;
	}

	private void setWeaponInHand(Weapon weaponInHand) {
		this.weaponInHand = weaponInHand;
	}

	private void setWeaponList(Weapon knife, Weapon sniper, Weapon ak47) {
		weaponList.put(1, knife);
		weaponList.put(2, sniper);
		weaponList.put(3, ak47);
	}

	private void healthUpdate(double x) {
		health += x;
		if (health > 100)
			health = 100;
		if (health < 0) {
			livesUpdate(-1);
			health = 100;
		}
	}

	/**********************************************************/

	/********************** Private functions ****************/
	/*
	 * 
	 */
	/********************** Public functions ****************/
	/*******************************************************/

	public void attackEnemy(PlayerStatus opponent) {
		if (getWeaponInHand().getName().equals(opponent.getWeaponInHand().getName())) {
			double generatedDagamge = (3 * getHealth() + getScore() / 1000) / 4;
			double receivedDamage = (3 * opponent.getHealth() + opponent.getScore() / 1000) / 4;
			/*
			 * 1st case if aggressor generates more damage, then defender defender health -=
			 * generatedDamage; 1.1 if receivedDamage / generatedDagamge >= 0.5 aggressor
			 * health -= receivedDamage * 0.35; 1.2 if receivedDamage / generatedDagamge <
			 * 0.5 aggressor health -= receivedDamage * 0.035;
			 */
			if (generatedDagamge > receivedDamage) {
				if (receivedDamage / generatedDagamge >= 0.5) {
					opponent.healthUpdate(-generatedDagamge);
					healthUpdate(-receivedDamage * 0.35);
				} else {
					opponent.healthUpdate(-generatedDagamge);
					healthUpdate(-receivedDamage * 0.035);
				}
			}
			/*
			 * 2nd case if defender generates more damage, then aggressor health -=
			 * receivedDamage; 2.1 if generatedDagamge / receivedDamage >= 0.5 defender
			 * health -= generatedDagamge * 0.35; 2.2 if generatedDagamge / receivedDamage <
			 * 0.5 defender health -= generatedDagamge * 0.035;
			 *
			 */
			else if (generatedDagamge < receivedDamage) {
				if (generatedDagamge / receivedDamage >= 0.5) {
					healthUpdate(-receivedDamage);
					opponent.healthUpdate(-generatedDagamge * 0.35);
				} else {
					healthUpdate(-receivedDamage);
					opponent.healthUpdate(-generatedDagamge * 0.035);
				}
			}
		} else if (!getWeaponInHand().getName().equals(opponent.getWeaponInHand().getName())) {
			/*
			 * if distance between two players is grater then 1000, the weapon damage
			 * decreases as follows: sniper > kalash> knife; the damage generated by the
			 * weapon is computed as follows: weapon.damage * (1 - distanceBetweenPlayers /
			 * 10000)
			 */
			if (distanceBetweenPlayers(opponent) > 1000) {
				double generatedDagamge = getWeaponInHand().getDamage()
						* (1 - distanceBetweenPlayers(opponent) / 10000);
				double receivedDamage = opponent.getWeaponInHand().getDamage()
						* (1 - distanceBetweenPlayers(opponent) / 10000);

				opponent.healthUpdate(-generatedDagamge);
				healthUpdate(-receivedDamage);
			} else if (distanceBetweenPlayers(opponent) <= 1000) {
				/*
				 * if distance between two players is less/equal then/to 1000, the weapon damage
				 * decreases as follows: kalash > sniper > knife kalash damage is updated to 40
				 * / 0.57 = 70.17; sniper damage is updated to 65 * 0.62= 40.3
				 * 
				 */

				kalashnikov.setDamage(kalashnikov.getDamage() / 0.57);
				sniper.setDamage(sniper.getDamage() * 0.62);

				double generatedDagamge = getWeaponInHand().getDamage()
						* (1 - distanceBetweenPlayers(opponent) / 10000);
				double receivedDamage = opponent.getWeaponInHand().getDamage()
						* (1 - distanceBetweenPlayers(opponent) / 10000);

				opponent.healthUpdate(-generatedDagamge);
				healthUpdate(-receivedDamage);
			}

		}
	}

	public boolean shouldAttackOpponent(PlayerStatus opponent) {
		boolean attack = true;
		if (getWeaponInHand().getName().equals(opponent.getWeaponInHand().getName())) {
			double generatedDagamge = (3 * getHealth() + getScore() / 1000) / 4;
			double reveivedDamage = (3 * opponent.getHealth() + opponent.getScore() / 1000) / 4;
			if (reveivedDamage > generatedDagamge)
				attack = false;
		} else if (!getWeaponInHand().getName().equals(opponent.getWeaponInHand().getName())) {
			if (distanceBetweenPlayers(opponent) > 1000) {
				if (opponent.getWeaponInHand().getName().equals("sniper")) {
					attack = false;
				} else if (opponent.getWeaponInHand().getName().equals("kalashnikov")
						&& getWeaponInHand().getName().equals("knife")) {
					attack = false;
				}
			} else if (distanceBetweenPlayers(opponent) <= 1000) {
				if (opponent.getWeaponInHand().getName().equals("kalashnikov")) {
					attack = false;
				} else if (opponent.getWeaponInHand().getName().equals("sniper")
						&& getWeaponInHand().getName().equals("knife")) {
					attack = false;
				}
			}
		}
		return attack;
	}

	public void movePlayerTo(double positionX, double positionY) {
		setPositionX(positionX);
		setPositionY(positionY);
	}

	public void findArtifact(int artifactCode) {
		if (isPerfect(artifactCode)) {
			scoreUpdate(5000);
			livesUpdate(1);
			setHealth(100);
		} else if (isPrime(artifactCode)) {
			scoreUpdate(1000);
			livesUpdate(2);
			healthUpdate(25);
		} else if (trap(artifactCode)) {
			scoreUpdate(-3000);
			healthUpdate(-25);
		} else
			scoreUpdate(artifactCode);

	}

	public boolean setWeaponInHand(int weaponID) {
		boolean set = false;
		/*
		 * checking the provided weaponID weaponInHand is assigned a weapon from the
		 * weaponList with corresponding ID
		 */
		if (weaponID < 1 || weaponID > 3) {
			System.out.println("No such weapon");

		} else if (getScore() >= weaponList.get(weaponID).getPrice()) {
			/*
			 * (1, knife); (2, sniper); (3, ak47);
			 */
			setWeaponInHand(weaponList.get(weaponID));
			scoreUpdate(-(weaponList.get(weaponID).getPrice()));
			set = true;
		} else
			System.out.println("Increase the score\nYou need " + weaponList.get(weaponID).getPrice() + " points for "
					+ weaponList.get(weaponID).getName());
		return set;
	}

	@Override
	public String toString() {
		return "PlayerStatus [nickname=" + nickname + ", score=" + score + ", lives=" + lives + ", health=" + health
				+ ", weaponInHand=" + weaponInHand.getName() + ", positionX=" + positionX + ", positionY=" + positionY
				+ "]";
	}

	/*********************************************************/
	/********************** Public functions ****************/
}
