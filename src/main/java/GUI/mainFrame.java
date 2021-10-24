/*
 * Created by JFormDesigner on Sun Oct 24 13:51:05 ICT 2021
 */

package GUI;

import GUI.Custom.SearchViewPanel;
import GUI.Event.IEventMenuSelected;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.GroupLayout;

import static GUI.Custom.JList_Model.selectedIndex;

/**
 * @author nghia pham
 */
public class mainFrame extends JFrame {
    public mainFrame() {
        SearchViewPanel searchViewPanel = new SearchViewPanel();
        initComponents();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(searchViewPanel);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - nghia pham
        searchViewPanel1 = new SearchViewPanel();

        //======== this ========
        Container contentPane = getContentPane();

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(searchViewPanel1, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(searchViewPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - nghia pham
    private SearchViewPanel searchViewPanel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
