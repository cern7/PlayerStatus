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


## Game rules
* **energy** :
    * *0 <= energy <= 100*
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
   * ![euclideanDistance](https://user-images.githubusercontent.com/62252282/126804920-b0573d11-842d-462c-b794-9373aea11a7e.png)

    
## API
##### public class PlayerStatus
## 
    PlayerStatus()                                      // create a list of game weapons and initialize the player position
    PlayerStatus(String nickname)                       // calling the PlayerStatus() constructor and initialize the player nickname
    PlayerStatus(String nickname, int lives)            // calling PlayerStatus(String nickname) constructor and initialize the player lives
    PlayerStatus(String nickname, int lives, int score) // calling PlayerStatus(String nickname, int lives) constructor and initialize the player score
    double getPositionX()                               // return the player oX position
    double getPositionY()                               // return the player oY position
    static String getGameName()                         // return the game name
    void setGameName(String gameName)                   // set the game name
    void setScore(int score)                            // set the player score
    void setLives(int lives)                            // set the player lives
    void setEnergy(int energy)                          // set the player energy
    int getScore()                                      // return the player score
    int getLives()                                      // return the player lives
    int getEnergy()                                     // return the player energy
    Weapon getWeaponInHand()                            // return the player weapon

