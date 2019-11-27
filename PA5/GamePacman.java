public class GamePacman {


    private static final int DEFAULT_SIZE = 10;

    private static int boardSize;
    private static Board board;


    public static void main(String[] args) {

        processArgs(args);

        System.out.println("Welcome to Pac-Man!");
        
        board = new Board( boardSize );
        
        // print initial board
        System.out.println(board);

        // Examples on how to move the Pac-Man in main.
        if ( board.canMove(Direction.UP) ) {
                board.move(Direction.UP);
        } // If cannot move, don't change anything.
        System.out.println(board);
        if ( board.isGameOver() ) {
            System.out.println("Game Over!");
        }

        if ( board.canMove(Direction.LEFT) ) {
                board.move(Direction.LEFT);
        } // If cannot move, don't change anything.
        System.out.println(board);
        if ( board.isGameOver() ) {
            System.out.println("Game Over!");
        }

        if ( board.canMove(Direction.DOWN) ) {
                board.move(Direction.DOWN);
        } // If cannot move, don't change anything.
        System.out.println(board);
        if ( board.isGameOver() ) {
            System.out.println("Game Over!");
        }

        if ( board.canMove(Direction.RIGHT) ) {
                board.move(Direction.RIGHT);
        } // If cannot move, don't change anything.
        System.out.println(board);
        if ( board.isGameOver() ) {
            System.out.println("Game Over!");
        }

    }

    private static void processArgs(String[] args) {

        // Arguments must come in pairs
        if((args.length % 2) != 0)
        {
            printUsage();
            System.exit(-1);
        }

        // TODO

    }

    // Print the Usage Message
    private static void printUsage()
    {
        System.out.println("Pac-Man");
        System.out.println("Usage:  GamePacman [-s size]");
        System.out.println();
        System.out.println("  Command line arguments come in pairs of the form: <command> <argument>");
        System.out.println();
        System.out.println("  -s [size]  -> Specifies the size of the Pac-Man board if an input file hasn't been");
        System.out.println("                specified.  If both -s and -i are used, then the size of the board");
        System.out.println("                will be determined by the input file. If board size declared is less");
        System.out.println("                than 3, the board size will be modified to the default size. The default");
        System.out.println("                size is 10.");

    }
}
