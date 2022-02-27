package Life;

/**
 * First button handler class
 */
public class buttonHandler implements java.awt.event.ActionListener {
    /**
     * Method inherited from ActionListener
     * @param e The event source
     */
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        javax.swing.JOptionPane.showMessageDialog(null, "Button clicked");
    }
}