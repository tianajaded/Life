/*
 * Name: Elisha Phillips
 * Name: Tiana Noll-Walker
 * Date: 02/26/2022
 * Course: CPT_S 132 Section 01, Spring 22
 * Assignment: HW6 - LifeGUI
 * Description: Calculates John Conway's Game of Life and prints GUI
 * Grade Level: Challenge
 */

package Life;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.BorderLayout;

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
    private static final Color live = Color.WHITE;
    private static final Color dead = Color.BLACK;

    /**
     * Constructor for the GUI, constructs a JFrame to display window
     */
    public lifeGUI() {
        // Main Window
        win = new javax.swing.JFrame("Game of Life");
        // Content Panel
        c = win.getContentPane();
        c.setLayout(new BorderLayout());

        // Assigning default window parameters
        win.setLocation(50, 50);
        win.setSize(500, 500);
        win.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        win.toBack();
        win.setVisible(true);

    }

    /**
     * Constructor to that draws the grid layout via an internal JFrame
     * 
     * @param gridArr the grid array of cells to be displayed
     */
    public void drawGridLayout(int[][] gridArr) {
        int x = gridArr.length;

        JInternalFrame grid = new JInternalFrame();
        grid.pack();
        grid.setBackground(dead);
        grid.setLayout(new GridBagLayout());
        grid.setVisible(true);

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
                // l.setBackground(dead);
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

    /**
     * Constructor to update the grid layout with live or dead cells
     * 
     * @param gridArr the grid array of cells to be displayed
     */

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
