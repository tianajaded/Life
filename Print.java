package Life;

/**
 * Description: Formats the board array to a printable string
 */
public class print {
    // Override toString, make it into a printable 'picture'
    public String toString(char[][] grid) {
        String boardStr = "";
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length - 1; j++) {
                boardStr += grid[i][j] + " ";

            }
            boardStr += "\n";

        }

        return boardStr;
    }

}