package wannabeGame.Main;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

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

    public Board(String mapFile) {
        try {
            File myObj = new File("src/main/java/wannabeGame/BoardMaps/"+mapFile);
            Scanner scan = new Scanner(myObj);
            //map init
            i_size = Integer.parseInt(scan.nextLine());
            j_size = Integer.parseInt(scan.nextLine());
            map_matrix = new Tile[i_size][j_size];
            //map creation
            int i= 0,j = 0;
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                for (int c=0; c < line.length(  ); c++) {
                    switch(line.charAt(c)) {
                        case 'W':
                            map_matrix[i][j++] = new Tile(null,true);
                            break;
                        case 'P':
                            pi = i; pj = j;
                            map_matrix[i][j++] = new Tile(player,false);
                            break;
                        case 'O':
                            map_matrix[i][j++] = new Tile(new Enemy(300, 16),false);
                            break;
                        case 'F':
                            map_matrix[i][j++] = new Tile(new Fountain(),false);
                            break;
                        case 'E': 
                            map_matrix[i][j++] = new Tile(new End(),false);
                            break;
                        case ' ': 
                            map_matrix[i][j++] = new Tile(null,false);
                            break;
                    }                    
                }
                i++; j = 0;                
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Invalid Map.");
            e.printStackTrace();
        }
    }

    public void movePlayer(char move) throws Exception {
        
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
