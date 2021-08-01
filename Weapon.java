package Player;

//22 Jul 2021
/**
 *
 *@author cen7
 *
 */
public class Weapon {
	private String name;
	private int price;
	private double damage;
	public Weapon() {
		
	}
	

	/**
	 * @param name
	 * @param price
	 */
	public Weapon(String name, int price, double damage) {
		this.name = name;
		this.price = price;
		this.damage = damage;
	}


	public double getDamage() {
		return damage;
	}


	public void setDamage(double damage) {
		this.damage = damage;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
