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
	private int health = 100;
	private Weapon weaponInHand;
	private double positionX;
	private double positionY;
	private Weapon knife = new Weapon("knife", 1000);
	private Weapon sniper = new Weapon("sniper", 10000);
	private Weapon kalashnikov = new Weapon("kalashnikov", 20000);

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

	public PlayerStatus() {
		setWeaponList(knife, sniper, kalashnikov);
		setInitPosition();

	}

	public PlayerStatus(String nickname) {
		this();
		this.nickname = nickname;
	}

	public PlayerStatus(String nickname, int lives) {
		this(nickname);
		this.lives = lives;
	}

	public PlayerStatus(String nickname, int lives, int score) {
		this(nickname, lives);
		this.score = score;
	}

	/****************************************************/

	/********************** Constructors ******************/
	/*
	 * 
	 */
	/********************** Getters + Setters ******************/
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

	public void setHealth(int health) {
		this.health = health;
	}

	public int getScore() {
		return score;
	}

	public int getLives() {
		return lives;
	}

	public int getHealth() {
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
	/*distanceBetweenPlayers should be private */
	public double distanceBetweenPlayers(PlayerStatus opponent) {

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

	private void healthUpdate(int x) {
		health += x;
		if (health > 100)
			health = 100;
		if (health < 0) {
			livesUpdate(-1);
			health = 100;
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

	/**********************************************************/

	/********************** Private functions ****************/
	/*
	 * 
	 */
	/********************** Public functions ****************/
	/*******************************************************/

	public boolean shouldAttackOpponent(PlayerStatus opponent) {
		boolean attack = true;
		if (getWeaponInHand().getName().equals(opponent.getWeaponInHand().getName())) {
			double assault = (3 * getHealth() + getScore() / 1000) / 4;
			double retreat = (3 * opponent.getHealth() + opponent.getScore() / 1000) / 4;
			if (retreat > assault)
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

	/*********************************************************/
	/********************** Public functions ****************/
}
