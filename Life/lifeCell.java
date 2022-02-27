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

/**
 * the lifecell class extends JButton
 */
public class lifeCell extends javax.swing.JButton {
    // Default fields, assigns to default color values
    private java.awt.Color lineColor = new java.awt.Color(0, 0, 0);
    private java.awt.Color backgroundColor = new java.awt.Color(255, 255, 255);

    /**
     * set preferred size, defaults etc
     */
    public lifeCell(java.awt.Color backgroundColor) {
        setPreferredSize(new java.awt.Dimension(50, 50));
        setContentAreaFilled(false);
        setBorderPainted(true);
        setOpaque(true);

    }

    /**
     * Method for returning line color of component
     *
     * @return lineColor Current line color settings
     */
    public java.awt.Color getLineColor() {
        return lineColor;
    }

    /**
     * Method for setting line color of component
     *
     * @param rgb Input color parameter
     */
    public void setLineColor(java.awt.Color rgb) {
        lineColor = rgb;
        repaint();
        
    }

    /**
     * Method for returning background color of component
     *
     * @return backgroundColor Current color settings
     */
    public java.awt.Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Method for setting Background Color of component
     *
     * @param rgb Input color parameter
     */
    public void setBackgroundColor(java.awt.Color rgb) {
        backgroundColor = rgb;
        repaint();
    }

    /**
     * Primary method for rendering the component
     *
     * @param g The Graphics object use to render
     */
    @Override
    public void paintComponent(java.awt.Graphics g) {
        // Inherits paintComponent
        super.paintComponent(g);   
        // Draws a borderless rectangle to fill the component cell
        g.fillRect(0, 0, getWidth(), getHeight());
        // Sets the background color for the rectangle
        g.setColor(backgroundColor);
    }
}
