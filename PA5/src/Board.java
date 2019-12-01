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
        score = 0;
        grid = new char[GRID_SIZE][GRID_SIZE];
        visited = new boolean[GRID_SIZE][GRID_SIZE];
        pacman = new PacCharacter(GRID_SIZE/2,GRID_SIZE/2,'P');
        ghosts = new PacCharacter[4];
        ghosts[0] = new PacCharacter(0,0,'G');
        ghosts[1] = new PacCharacter(0,GRID_SIZE-1,'G');
        ghosts[2] = new PacCharacter(GRID_SIZE-1,0,'G');
        ghosts[3] = new PacCharacter(GRID_SIZE-1,GRID_SIZE-1,'G');
        setVisited(GRID_SIZE/2, GRID_SIZE/2);
    }


    public void setVisited(int x, int y) {
        if (x < 0 || y < 0 || x >= GRID_SIZE || y > GRID_SIZE){
            return;
        }
        visited[x][y]=true;
    }

    public void refreshGrid() {
        grid[pacman.getRow()][pacman.getCol()] = pacman.getAppearance();
        for (PacCharacter ghost : ghosts) {
            grid[ghost.getRow()][ghost.getCol()] = ghost.getAppearance();
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;i<grid[i].length;i++){
                if(!visited[i][j]){
                    grid[i][j]='*';
                }
                else{
                    grid[i][j]=' ';
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
        int row = pacman.getRow() + direction.getX();
        int col = pacman.getCol() + direction.getY();
        pacman.setPosition(row, col);
        if(!visited[row][col]){
            score+=10;
            visited[row][col]=true;
        }
        for (PacCharacter ghost: ghosts) {
            ghostMove(ghost);
        }
        refreshGrid();
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
        if(ghost.getRow()==pacman.getRow() && ghost.getCol()==pacman.getCol()){
            return Direction.STAY;
        }
        int possX = ghost.getRow() - pacman.getRow();
        int possY = ghost.getCol() - pacman.getCol();
        if(possY>=possX){
            return (possX>0)? Direction.UP: Direction.DOWN;
        }
        else{
            return (possY>0)? Direction.LEFT: Direction.RIGHT;
        }
    }


    public String toString(){

        StringBuilder outputString = new StringBuilder();
        outputString.append(String.format("Score: %d\n", this.score));
        for(char[] row:grid){
            for(char spot:row){
                outputString.append(" " + spot);
            }
            outputString.append("\n");
        }
        return outputString.toString();
    }




}
