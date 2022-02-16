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

    /**
     * Generates the initial board and printout
     */
    public void initiateGame(int size) {
        // set generation counter to zero
        generation = 0;
        // Starting board fill with initial cells
        gridCurrent = life.generateStartingBoard(size);

        gridNext = life.generateStartingBoard(size);
        // update cells
        gridNext = life.setDead(2, 3);
        gridNext = life.setDead(3, 3);
        gridNext = life.setDead(15, 3);
        gridNext = life.setDead(14, 5);
        gridNext = life.setDead(12, 12);
        gridNext = life.setDead(12, 14);
        gridNext = life.setAlive(16, 5);
        gridNext = life.setAlive(15, 6);
        gridNext = life.setAlive(15, 5);
        gridNext = life.setAlive(14, 4);
        gridNext = life.setAlive(13, 13);
        gridNext = life.setAlive(11, 13);

        // Headers
        System.out.println("Conway's Game of Life");
        // print does the 'toString' override formatting stuff
        System.out.println(print.toString(gridCurrent));
        System.out.println("\n");
        generation = 2;

        System.out.println("\nCurrent Generation: " + generation + "\n");

        // System.out.println(generation + "\n");
        System.out.println(print.toString(gridNext));

        generation = 3;
        System.out.println(generation + "\n");
        gridNext = life.Step();
        System.out.println(print.toString(gridNext));
        generation = 4;
        System.out.println(generation + "\n");
        gridNext = life.Step();
        System.out.println(print.toString(gridNext));
        generation = 5;
        System.out.println(generation + "\n");
        gridNext = life.Step();
        System.out.println(print.toString(gridNext));
        generation = 6;
        System.out.println(generation + "\n");
        gridNext = life.Step();
        System.out.println(print.toString(gridNext));
        generation = 7;
        System.out.println(generation + "\n");
        gridNext = life.Step();
        System.out.println(print.toString(gridNext));

    }

    // Testing class for checking arrays, erase once everything's working
    public void test() {
        System.out.println(print.toString(gridCurrent));
        System.out.println(print.toString(gridNext));
    }
}
