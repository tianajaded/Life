package Life;

/**
 * Description: nextGen calculates the next generation of the board
 */
public class nextGen {

    private lifeBoard life = new lifeBoard();
    private Print print = new Print();

    private char gridCurrent[][];
    private char gridNext[][];

    private int generation;

    public nextGen(){

    }

    /**
     * Generates the initial board and printout
     */
    public void initiateGame(int size) {
        // set generation counter to zero
        generation = 0;
        // Starting board fill with initial cells
        gridCurrent = life.generateStartingBoard(size);

        gridNext = life.generateStartingBoard(size);
    }


    public nextGen(char[][] gridCurrent) {
        this.gridCurrent = gridCurrent;
    
        // update cells
        gridNext = life.isDead(gridNext, 1, 2);
        gridNext = life.isDead(gridNext, 2, 2);
        gridNext = life.isDead(gridNext, 15, 2);
        gridNext = life.isDead(gridNext, 14, 4);
        gridNext = life.isDead(gridNext, 12, 11);
        gridNext = life.isDead(gridNext, 12, 13);
        gridNext = life.isLive(gridNext, 16, 3);
        gridNext = life.isLive(gridNext, 16, 4);
        gridNext = life.isLive(gridNext, 15, 5);
        gridNext = life.isLive(gridNext, 14, 3);
        gridNext = life.isLive(gridNext, 13, 12);
        gridNext = life.isLive(gridNext, 11, 12);

        generation = 2;
        gridNext = life.Step(this.gridCurrent,2,4 );

        // Headers
        System.out.println("Conway's Game of Life");

        System.out.println("\nCurrent Generation: " + generation + "\n");

        // print does the 'toString' override formatting stuff
        System.out.println(print.toString(gridCurrent));
        System.out.println("\n");

        System.out.println(generation + "\n");
        System.out.println(print.toString(gridNext));
    }


    // Testing class for checking arrays, erase once everything's working
    public void test() {
        System.out.println(print.toString(gridCurrent));
        System.out.println(print.toString(gridNext));
    }
}
