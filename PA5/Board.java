import java.lang.StringBuilder;
import java.util.*;
import java.io.*;

/**
 * @author      Firstname Lastname <address @ example.com>
 */
public class Board {

    // FIELD
    public final int GRID_SIZE;

    private char[][] grid;          // String Representation of Pac-man Game Board
    private boolean[][] visited;    // Record of where Pac-man has visited
    private PacCharacter pacman;    // Pac-man that user controls
    private PacCharacter[] ghosts;  // 4 Ghosts that controlled by the program
    private int score;              // Score Recorded for the gamer


    /*
     * Constructor
     *
     * <p> Description: TODO
     *
     * @param:  TODO
     * @return: TODO
     */
    public Board(int size) {
        GRID_SIZE = size;

    }


    public void setVisited(int x, int y) {
        visited[x][y]=true;
    }

    public void refreshGrid() {
        for(int i=0;i<grid.length;i++){
            for(int j=0;i<grid[i].length;i++){
                if(i==pacman.getRow() && j==pacman.getCol()){
                    grid[i][j]=pacman.getAppearance();
                }
                else if(true){
                    for(int k=0;k<4;k++){
                        if(i==ghosts[k].getRow() && j==ghosts[k].getCol()){
                            grid[i][j]=ghosts[k].getAppearance();
                            break;
                        }
                    }
                }
                else if(visited[i][j]){
                    grid[i][j]="*";
                }
                else{
                    grid[i][j]=" ";
                }
            }
        }
    }


    public boolean canMove(Direction direction) {
        int possX = pacman.getRow() + direction.getX();
        int possY = pacman.getCol() + direction.getY();
        if(possX<0 || possY<0 || possX>=GRID_SIZE || possY>=GRID_SIZE){
            return false;
        }
        return true;
    }


    public void move(Direction direction) {
        // TODO
    }


    public boolean isGameOver() {
        for(int i=0;i<4;i++){
            if(pacman.getRow()==ghosts[i].getRow() && pacman.getCol()==ghosts[i].getCol()){
                return true;
            }
        }
        return false;
    }

    // Monster always move towards Pac-man
    public Direction ghostMove(PacCharacter ghost) {
        // TODO
    }


    public String toString(){

        StringBuilder outputString = new StringBuilder();
        outputString.append(String.format("Score: %d\n", this.score));
        for(char row:grid){
            for(char spot:row){
                outputString.append(" " + grid[i][j]);
            }
            outputString.append("\n");
        }
        return outputString.toString();
    }




}
