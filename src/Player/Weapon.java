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
	
	public Weapon() {
		
	}
	

	/**
	 * @param name
	 * @param price
	 */
	public Weapon(String name, int price) {
		super();
		this.name = name;
		this.price = price;
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
