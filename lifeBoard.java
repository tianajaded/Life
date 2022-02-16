package Life;

/**
 * Description: lifeBoard manages constructing and modifying the game boards
 */
public class lifeBoard {
    // Character array for the Life board
    private char grid[][];
    // Displayed dead and live print characters
    private char dead = '.';
    private char live = 'O';

    /**
     * Generates an empty board per size params
     * 
     * @param size
     * @return grid[][]
     */
    public char[][] generateEmptyBoard(int size) {
        // create square initial grid per user dimensions
        grid = new char[size][size];
        // assign default fill with dead cells
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                grid[i][j] = '.';
        // return grid
        return grid;

    }

    /**
     * Generates board with starting cells
     * 
     * @param size - min 19
     * @return grid[][]
     *         These are just temporary starters, you could also
     *         make some separate patterns and randomly distribute
     *         across different sized grids n stuff
     */
    public char[][] generateStartingBoard(int size) {
        // create square initial grid per user dimensions

        char[][] grid = generateEmptyBoard(size);

        // Array containing the shapes in the assignment
        int[][][] cells = {
                { { 2, 3 }, // Shape a
                        { 3, 3 } },
                { { 2, 12 }, // Shape b
                        { 2, 13 },
                        { 3, 12 },
                        { 3, 13 } },
                { { 7, 6 }, // Shape c
                        { 7, 7 },
                        { 8, 5 },
                        { 8, 8 },
                        { 9, 6 },
                        { 9, 7 } },
                { { 12, 12 }, // Shape d
                        { 12, 13 },
                        { 12, 14 },
                        { 8, 8 },
                        { 9, 6 },
                        { 9, 7 } },
                { { 14, 5 }, // Shape e
                        { 15, 3 },
                        { 15, 5 },
                        { 16, 4 },
                        { 16, 5 } } };

        // Iterate through the above array and update the live cells at the coordinates
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                grid = setAlive(cells[i][j][0], cells[i][j][1]);

            }
        }

        return grid;
    }

    /**
     * Description: Marks a character in the grid as live
     *
     * 
     * @param x Input row to be modified
     * @param x Input column to be modified
     * @return grid
     */
    public char[][] setAlive(int x, int y) {
        // Throw OOB exception
        if (x > grid.length || y > grid[0].length) {
            throw new IndexOutOfBoundsException("Index is out of bounds!");
        }
        grid[x][y] = live;
        // live = "O";
        return grid;
    }

    /**
     * Description: Marks a character in the grid as dead
     *
     * @param grid Input grid
     * @param x    Input row to be modified
     * @param x    Input column to be modified
     * @return grid
     */
    public char[][] setDead(int x, int y) {
        // Throw OOB exception
        if (x > grid.length || y > grid[0].length) {
            throw new IndexOutOfBoundsException("Index is out of bounds!");
        }

        grid[x][y] = dead;
        // dead = ".";
        return grid;
    }

    // method so you can check to see if a cell is dead or alive
    public int isAlive(int x, int y) {
        if (x <= 0 || y <= 0 || x >= grid.length || y >= grid.length) {
            return 0;
        }
        if (grid[x][y] == live) {
            return 1;
        } else {
            return 0;
        }
    }

    // method to count neighboring cells
    public int countAliveNeighbors(int x, int y) {

        int count = 0;
        // the center of the board is [i][j].
        // we need to check all the surrounding cells

        // top left cell
        count += isAlive(x - 1, y - 1);
        // same row left
        count += isAlive(x, y - 1);
        // left below
        count += isAlive(x + 1, y - 1);
        // same above
        count += isAlive(x - 1, y);
        // same col below
        count += isAlive(x + 1, y);
        // right above
        count += isAlive(x - 1, y + 1);
        // same row right
        count += isAlive(x, y + 1);
        // right below
        count += isAlive(x + 1, y + 1);

        return count;
    }

    // goes from one board to next
    public char[][] Step() {

        // iterate thru the arrays
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                int AliveNeighbors = countAliveNeighbors(i, j);

                if (isAlive(i, j) ==1) {
                    if (AliveNeighbors < 2 || AliveNeighbors > 4) {
                        // if amount of live cells around is less than two it dies
                        grid[i][j] = dead;
                    }
                    // else it is alive
                } else if (AliveNeighbors == 2 || AliveNeighbors == 3) {
                    grid[i][j] = live;

                } else if (AliveNeighbors > 3) {
                    grid[i][j] = dead;
            }}

        }
        return grid;

    }
}
