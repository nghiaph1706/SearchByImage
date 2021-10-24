/*
 * Created by JFormDesigner on Sun Oct 24 09:34:53 ICT 2021
 */

package GUI.Custom;

import Model.ModelResult;
import Utilitie.Final;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author nghia pham
 */
public class ItemList extends JPanel {
    private boolean selected;
    private boolean over;

    public ItemList(ModelResult modelResult) {
        initComponents();
        txtpTitle.setText(modelResult.getTitle());
        txtpDescription.setText(modelResult.getDisplayed_link());
        txtpSnippet.setText(modelResult.getSnippet());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - nghia pham
        txtpDescription = new JTextPane();
        txtpTitle = new JTextPane();
        txtpSnippet = new JTextPane();

        //======== this ========
        setBackground(Color.white);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
        swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border
        . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog"
        ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder
        ( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
        .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException
        ( ); }} );

        //---- txtpDescription ----
        txtpDescription.setText("Description");
        txtpDescription.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        txtpDescription.setForeground(new Color(204, 204, 204));

        //---- txtpTitle ----
        txtpTitle.setText("Title");
        txtpTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        txtpTitle.setForeground(new Color(51, 51, 255));

        //---- txtpSnippet ----
        txtpSnippet.setText("Snippet");
        txtpSnippet.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtpSnippet.setForeground(Color.black);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(txtpSnippet, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                        .addComponent(txtpTitle, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                        .addComponent(txtpDescription, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                    .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(txtpTitle, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(txtpDescription, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(txtpSnippet, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addGap(0, 0, 0))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        super.repaint();
    }


    public void setOver(boolean over) {
        this.over = over;
        super.repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs){
        if (selected || over) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (selected) {
                g2.setColor(new Color(255,255,255,80));
            } else {
                g2.setColor(new Color(255,255,255,20));
            }
            g2.fillRoundRect(10, 0, getWidth() - 20, getHeight(), 5, 5);
            super.paintComponent(grphcs);
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - nghia pham
    private JTextPane txtpDescription;
    private JTextPane txtpTitle;
    private JTextPane txtpSnippet;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
