/*
 * Created by JFormDesigner on Sun Oct 24 11:58:55 ICT 2021
 */

package GUI.Custom;

import GUI.Event.IEventMenuSelected;
import Model.ModelListIem;
import Model.ModelResult;
import Utilitie.Final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.net.URISyntaxException;

import GUI.Custom.*;

/**
 * @author nghia pham
 */
public class JList_Model<E extends Object> extends JList<E>{
    DefaultListModel model;
    public static int selectedIndex = -1;
    private int overIndex = -1;

    private IEventMenuSelected event;

    public void addEventMenuSelected(IEventMenuSelected event){
        this.event=event;
    }

    public JList_Model() {
        initComponents();
        intit();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - nghia pham
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    void intit(){
        setOpaque(false);
        model = new DefaultListModel();
        setModel(model);
        JScrollPane jScrollPane = new JScrollPane();
        add(jScrollPane,BorderLayout.CENTER);
        setAutoscrolls(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me){
                if (SwingUtilities.isLeftMouseButton(me)) {
                    int index = locationToIndex(me.getPoint());
                    Object o = model.getElementAt(index);
                    if (o instanceof ModelResult) {
                        selectedIndex=index;
                        if (event!=null) {
                            try {
                                event.selected(index);
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        selectedIndex=index;
                    }
                    repaint();
                }
            }

            @Override
            public void mouseExited(MouseEvent me){
                overIndex = -1;
                repaint();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent me){
                int index = locationToIndex(me.getPoint());
                if (index != overIndex) {
                    Object o = model.getElementAt(index);
                    if (o instanceof ModelResult) {
                        overIndex=index;
                    } else {
                        overIndex=-1;
                    }
                    repaint();
                }
            }
        });
    }

    public ListCellRenderer<? super E> getCellRenderer(){
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> jList, Object o , int index , boolean selected , boolean focus){
                ModelResult data;
                if (o instanceof ModelResult) {
                    data = (ModelResult) o;
                } else {
                    data = new ModelResult();
                }
                ItemList item = new ItemList(data);
                item.setSelected(selectedIndex==index);
                item.setOver(overIndex==index);
                return item;
            }
        };
    }

    public void addItem(ModelResult modelResult){
        model.addElement(modelResult);
    }

    public void removeAllItem(){
        model.removeAllElements();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - nghia pham
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
