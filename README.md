# Player Status 

## Design description

##### The PlayerStatus class maintains the player state up-to-date in a game
###### Implemented for self-learing 

## Class attributes
* nickname
* score
* lives
* energy
* Weapon
* xPos
* yPos
* gameName (static field)
* weaponList (static field)
* mapDimX (static field)
* mapDimY (static field)

## Game rules
* **energy** :
    * *0 < energy < 100*
    * *if energy == 0*
        * lives -= 1
        * energy = 100
* **lives** : 
    * *if lives == 0*
        * Game Over
* **Weapon** :
    * *knife (1000$)*
    * *remingtonM24 (10000$)*
    * *m16Rifle (20000$)*
* **fight**
    * *if player1.weapon == player2.weapon*
        * player.win = (5 * player.energy + player.score / 100) / 6
    * *if player1.weapon != player2.weapon*
        * if distance > 100 
            * weapon.power -> remingtonM24 > m16Rifle > knife
        * if distance <= 100 
            * weapon.power -> m16Rifle > remingtonM24 > knife
* **distance** (Euclidean distance)
![euclideanDistance](https://user-images.githubusercontent.com/62252282/127844982-7eceb6fd-451b-4e15-bb1e-624d5050f0fa.png)


## API
##### public class PlayerStatus
## 
	PlayerStatus(String nickname)                       // Initializing the player object with score = 0 and lives =0
	PlayerStatus(String nickname, int lives)            // Initializing the player object with score = 0
	PlayerStatus(String nickname, int lives, int score) // Initializing the player object with all three fields, creating the weapon list, and get a random position for player
	double getPositionX()                              // return the player oX position
	double getPositionY()                              // return the player oY position
	String getNickname()                               // return the player Nickname
	String getGameName()                        // return the game name
	void setScore(int score)                           // set the player score
   	void setLives(int lives)                           // set the player lives
	void setEnergy(int energy)                         // set the player energy
	int getScore()                                     // return the player score
	int getLives()                                     // return the player lives
	int getEnergy()                                    // return the player energy
	Weapon getWeaponInHand()                           // return the player weapon
	void attackEnemy(PlayerStatus opponent)		   // attacking the opponent
	boolean shouldAttackOpponent(PlayerStatus opponent)// attacking advice
	void movePlayerTo(double positionX, double positionY)	// moving the player
	void findTreasure					// function for treasure objects
	boolean setWeaponInHand(int weaponID)			// function for weapon purchase
