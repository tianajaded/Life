package Life;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.*;

/**
 * Description: GUI Class for the lifeBoard
 *
 */
public class lifeGUI {
    // Declaring the Window
    private javax.swing.JFrame win;

    // Declaring the Content Pane
    static java.awt.Container c;

    static ArrayList<Label> label = new ArrayList<Label>();

    // Background color for the layout, will form the board's gridlines
    private static final Color live = Color.black;
    private static final Color dead = Color.white;

    public lifeGUI() {
        // Main Window
        win = new javax.swing.JFrame("Life");
        // Content Panel
        c = win.getContentPane();
        c.setLayout(new BorderLayout());
        // c.add(Buttons.toolbar, BorderLayout.NORTH);

        // Assigning default window parameters
        win.setLocation(50, 50);
        win.setSize(1000, 1000);
        win.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        win.setVisible(true);
        win.toFront();

    }

    /**
     * Constructor for layout objects
     */
    public void drawGridLayout(int[][] gridArr) {
        int x = gridArr.length;

        JInternalFrame grid = new JInternalFrame();
        grid.pack();
        grid.setVisible(true);

        grid.setBackground(live);
        grid.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 1d;
        gc.weighty = 1d;
        gc.insets = new Insets(0, 0, 1, 1);
        gc.fill = GridBagConstraints.BOTH;

        int index = 0;
        // fill the whole panel with labels
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                Label l = new Label();
                l.setBackground(dead);
                gc.gridx = i;
                gc.gridy = j;
                grid.add(l, gc);
                label.add(index, l);
                index += 1;
            }
        }

        updateGridLayout(gridArr);
        c.add(grid, BorderLayout.CENTER);

    }

    public void updateGridLayout(int[][] gridArr) {

        int x = gridArr.length;
        int index;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                index = (x * j) + i;
                // Check grid cell for live or dead state and update string
                if (gridArr[i][j] == 0) {
                    label.get(index).setBackground(live);
                } else {
                    label.get(index).setBackground(dead);
                }
                index += 1;
            }
        }
    }

}
