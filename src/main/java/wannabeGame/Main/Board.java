package wannabeGame.Main;

import wannabeGame.Exceptions.*;
import wannabeGame.Classes.*;
import wannabeGame.Entities.*;
import wannabeGame.Events.*;

public class Board {

    private int i_size;
    private int j_size;
    private Tile[][] map_matrix;
    private int pi = 4;
    private int pj = 4;

    private Player player = new Player(50, 100);

    public Board(int heigth, int width) {
        i_size = heigth;
        j_size = width;
        map_matrix = new Tile[i_size][j_size];

        for (int i=0;i<i_size;i++){
            for (int j=0;j<j_size;j++){

                if (i == 0 || i == i_size-1 || j == 0 || j == 1 || j == j_size-2 || j == j_size-1) {
                    map_matrix[i][j] = new Tile(null,true);
                }
                else if (i == pi && j == pj) {
                    map_matrix[i][j] = new Tile(player,false);
                }
                else if (i == 7 && j == 5) {
                        map_matrix[i][j] = new Tile(new Enemy(300, 16),false);
                }
                else if (i == i_size-4 && j == j_size-4) {
                        map_matrix[i][j] = new Tile(new TheEnd(),false);
                }
                else {
                    map_matrix[i][j] = new Tile(null,false);
                }
            }   
        }
    }

    public void movePlayer(char move) throws Exception {

        // WIP MISSING OLD TILE INTERACTION VERIFICATION
        // if tile is blocked throw exception 
        // if tile has other tile interaction trigger event
        
        Player player = (Player) map_matrix[pi][pj].getTileInteraction();
        int npi = pi, npj = pj;
        switch(move) {
            case 'w':
                npi = pi-1;
                break;
            case 'a': 
                npj = pj-1;
                break;
            case 's':
                npi = pi+1;
                break;
            case 'd': 
                npj = pj+1;
                break;
        }
        if (map_matrix[npi][npj].isSolid()) {
            throw new MoveBlockedException();
        }
        if (map_matrix[npi][npj].getTileInteraction() != null) {
            TileInteraction interaction = map_matrix[npi][npj].getTileInteraction();
            try {
                interaction.interact(player);
            }
            catch (FinishGameException e) {
                throw e;
            }
            catch (Exception e) {
                throw new MoveBlockedException();
            }
        }
        map_matrix[pi][pj].setTileInteraction(null);
        pi = npi;
        pj = npj;
        map_matrix[pi][pj].setTileInteraction(player);
    }

    public void doAction (char action) throws Exception {
        
        switch(action) {
            // Movement Actions
            case 'w':
            case 'a':  
            case 's':
            case 'd':
                try {
                    movePlayer(action);
                    break;
                }
                catch (FinishGameException e) {
                    throw e;
                }
                catch (Exception e) {
                    throw new IllegalActionException(e.toString());
                }
            // Help Action
            case 'h':
                System.out.printf("w,a,s,d to move\n");
                break;
            // Char Stats
            case 'c':
                System.out.printf(player.toString());
                break;
            // Quit Game
                case 'q':
                throw new FinishGameException("Quitting Game...\n");
            // Wrong/Illegal Action
            default:
                throw new IllegalActionException("Invalid Command : use 'h' for help");
        }
    }

    public String toString() {
        String res = "";

        for (int i=0;i<i_size;i++){
            for (int j=0;j<j_size;j++){
                res += map_matrix[i][j].toString();
            }
            res+="\n";
        }
        return res;
    }
}
