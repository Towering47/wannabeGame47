package wannabeGame.Interfaces;

import wannabeGame.Entities.*;

public class Interactions {

    public static boolean Battle(Player player, Enemy enemy) {
        // return true on win, false on lose
        while(true) {
            // player atk
            enemy.takeDamage(player.getAtkPower());
            if (enemy.getCurrentHP() < 1) {
                return true;
            } 
            // enemy atk
            player.takeDamage(enemy.getAtkPower());
            if (player.getCurrentHP() < 1) {
                return false;
            }
        }
    }

}
