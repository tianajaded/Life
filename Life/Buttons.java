package Life;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This is a simple client for the BigOval class
 */
public class Buttons extends lifeGUI
        implements java.awt.event.ActionListener {

    // fields for counter
    private int genCount=0;
    private int length=0;
    // fields for the buttons
    static javax.swing.JButton nextButton = new javax.swing.JButton(">> ");
    static javax.swing.JButton prevButton = new javax.swing.JButton("<< ");
    static javax.swing.JToolBar toolbar = new JToolBar();
    static ArrayList<int[][]> gridList = new ArrayList<int[][]>();


    public Buttons() {
        toolbar.add(prevButton, BorderLayout.WEST);
        toolbar.add(nextButton, BorderLayout.EAST);

        c.add(toolbar, BorderLayout.NORTH);

        nextButton.addActionListener(new java.awt.event.ActionListener() {
            // inner class for button event
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // call method to set next dot color and update buttons
                nextGen();
            }
        });
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            // inner class for button event
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // call method to set previous dot color and update buttons
                prevGen();

            }
        });
    }
    /**
     * The method from ActionListener
     * @param e The action that triggered this handler
     */
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {

    }


    public void retrieveGrid(ArrayList<int[][]> l) {
        gridList = l;
        length = gridList.size()-1;
    }


    /**
     * method to set next Generation
     */
    public void nextGen() {
        // Advance counter, loop back to zero at last value
        genCount = nextIndex(genCount);

        // update next button text
        nextButton.setText(">> " + String.valueOf(nextIndex(genCount)));
        // update previous button text
        prevButton.setText(String.valueOf(prevIndex(genCount)) + " <<");

        // Set next generation
        //System.out.println(gridList.get(genCount));
        super.updateGridLayout(gridList.get(genCount));

    }

    /**
     * method to set previous Generation
     */
    public void prevGen() {
        // Advance counter, loop back to zero at last value
        genCount = prevIndex(genCount);

        // update next button text
        nextButton.setText(">> " + String.valueOf(nextIndex(genCount)));
        // update previous button text
        prevButton.setText(String.valueOf(genCount) + " <<");

        // Set prev generation
        //System.out.println(gridList.get(genCount));
        super.updateGridLayout(gridList.get(genCount));
    }


    /**
     * method to get prev index
     *
     * @param Count input counter integer
     * @return next index integer
     */
    public int prevIndex(int Count) {
        int index;
        // if minimum, set index to end value
        // else, set index one step back
        if (Count == 0) {
            index = length;
        } else {
            index = Count - 1;
        }
        return index;
    }

    /**
     * method to get next index
     *
     * @param Count input counter integer
     * @return next index integer
     */
    public int nextIndex(int Count) {
        int index;
        // if minimum, set index to end value
        // else, set index one step back
        if (Count == length) {
            index = 0;
        } else {
            index = Count + 1;
        }
        return index;
    }

}
