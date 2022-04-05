package wannabeGame.Interfaces;

import wannabeGame.Entities.*;

public class Interactions {

    public static boolean Battle(Player player, Enemy enemy) {

        System.out.println("-----------------");
        System.out.println("BATTLE START");
        System.out.println("-----------------");
        System.out.print(player.toString());
        System.out.print(enemy.toString());
        System.out.println("-----------------");

        // return true on win, false on lose
        while(true) {
            // player atk
            enemy.takeDamage(player.getAtkPower());
            System.out.println("Player attacks for "+player.getAtkPower()+" damage!");
            System.out.print(enemy.toString());
            System.out.println("-----------------");
            if (enemy.getCurrentHP() < 1) {
                return true;
            } 
            // enemy atk
            player.takeDamage(enemy.getAtkPower());
            System.out.println("Enemy attacks for "+enemy.getAtkPower()+" damage!");
            System.out.print(player.toString());
            System.out.println("-----------------");
            if (player.getCurrentHP() < 1) {
                return false;
            }
        }
    }

}
