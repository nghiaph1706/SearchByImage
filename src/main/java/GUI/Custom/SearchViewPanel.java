/*
 * Created by JFormDesigner on Sun Oct 24 13:38:35 ICT 2021
 */

package GUI.Custom;

import GUI.Event.IEventMenuSelected;
import Model.ModelResult;
import Utilitie.GetDataImage;
import Utilitie.ScreenCaptureRectangle;
import Utilitie.SearchAPI;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import static Main.main.mF;
import static Utilitie.Final.*;
import static Utilitie.GetDataImage.checkText;
import static Utilitie.GetDataImage.text_in_picture;

/**
 * @author nghia pham
 */
public class SearchViewPanel extends JPanel {
    private IEventMenuSelected event;
    public String imagepath;

    public void addEventMenuSelected(IEventMenuSelected event){
        this.event=event;
        list_Model.addEventMenuSelected(event);
    }
    
    public SearchViewPanel() {
        initComponents();
        intit();
        list_Model.addEventMenuSelected(new IEventMenuSelected() {
            @Override
            public void selected(int index) throws URISyntaxException, IOException {
                if(index == 0 ){
                    Desktop.getDesktop().browse(new URI(list_Result.get(index).getLink()));
                } else if(index == 1 ){
                    Desktop.getDesktop().browse(new URI(list_Result.get(index).getLink()));
                } else if(index == 2 ){
                    Desktop.getDesktop().browse(new URI(list_Result.get(index).getLink()));
                } else if(index == 3 ){
                    Desktop.getDesktop().browse(new URI(list_Result.get(index).getLink()));
                } else if(index == 4 ){
                    Desktop.getDesktop().browse(new URI(list_Result.get(index).getLink()));
                } else if(index == 5 ){
                    Desktop.getDesktop().browse(new URI(list_Result.get(index).getLink()));
                } else if(index == 6 ){
                    Desktop.getDesktop().browse(new URI(list_Result.get(index).getLink()));
                } else if(index == 7 ){
                    Desktop.getDesktop().browse(new URI(list_Result.get(index).getLink()));
                } else if(index == 8 ){
                    Desktop.getDesktop().browse(new URI(list_Result.get(index).getLink()));
                } else if(index == 9 ){
                    Desktop.getDesktop().browse(new URI(list_Result.get(index).getLink()));
                }
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - nghia pham
        lblImage = new JLabel();
        btnCap = new JButton();
        btnImport = new JButton();
        label1 = new JLabel();
        panelListResult = new JPanel();
        scrollPane1 = new JScrollPane();
        list_Model = new JList_Model();
        lblTag1 = new JLabel();
        lblTag2 = new JLabel();
        lblTag3 = new JLabel();
        lblTag4 = new JLabel();
        lblTag5 = new JLabel();
        btnPin = new JButton();

        //======== this ========
        setBackground(Color.white);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
        javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax
        . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
        .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans.
        PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .
        equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

        //---- lblImage ----
        lblImage.setForeground(new Color(0, 204, 0));
        lblImage.setBorder(new LineBorder(Color.red, 3));

        //---- btnCap ----
        btnCap.setText("Capture");

        //---- btnImport ----
        btnImport.setText("Import");

        //---- label1 ----
        label1.setText("Result");
        label1.setForeground(new Color(255, 0, 51));
        label1.setFont(new Font("Segoe UI", Font.BOLD, 36));

        //======== panelListResult ========
        {

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(list_Model);
            }

            GroupLayout panelListResultLayout = new GroupLayout(panelListResult);
            panelListResult.setLayout(panelListResultLayout);
            panelListResultLayout.setHorizontalGroup(
                panelListResultLayout.createParallelGroup()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
            );
            panelListResultLayout.setVerticalGroup(
                panelListResultLayout.createParallelGroup()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
            );
        }

        //---- lblTag1 ----
        lblTag1.setText("TAG1");
        lblTag1.setHorizontalAlignment(SwingConstants.CENTER);
        lblTag1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblTag1.setForeground(Color.black);

        //---- lblTag2 ----
        lblTag2.setText("TAG2");
        lblTag2.setHorizontalAlignment(SwingConstants.CENTER);
        lblTag2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblTag2.setForeground(Color.black);

        //---- lblTag3 ----
        lblTag3.setText("TAG3");
        lblTag3.setHorizontalAlignment(SwingConstants.CENTER);
        lblTag3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblTag3.setForeground(Color.black);

        //---- lblTag4 ----
        lblTag4.setText("TAG4");
        lblTag4.setHorizontalAlignment(SwingConstants.CENTER);
        lblTag4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblTag4.setForeground(Color.black);

        //---- lblTag5 ----
        lblTag5.setText("TAG5");
        lblTag5.setHorizontalAlignment(SwingConstants.CENTER);
        lblTag5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblTag5.setForeground(Color.black);

        //---- btnPin ----
        btnPin.setText("Pin");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(18, 18, 18)
                            .addComponent(lblTag1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblTag2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblTag3, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblTag4, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblTag5, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(23, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCap, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnImport, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(btnPin))
                            .addGap(61, 61, 61))))
                .addComponent(panelListResult, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(btnCap)
                            .addGap(18, 18, 18)
                            .addComponent(btnImport)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnPin))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label1)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE, false)
                                .addComponent(lblTag1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTag2, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(lblTag3, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(lblTag4, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(lblTag5))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                    .addComponent(panelListResult, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void intit(){
        JScrollPane jScrollPane = new JScrollPane();
        panelListResult.add(jScrollPane,BorderLayout.CENTER);
        panelListResult.setEnabled(false);

        btnPin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (btnPin.getText().equals("Pin")){
                    mF.setSize(590,305);
                    btnPin.setText("UnPin");
                } else {
                    mF.setSize(620, 990);
                    btnPin.setText("Pin");
                }
            }
        });
        
        btnCap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    mF.dispose();
                    Thread.sleep(700);
                    imagepath = new ScreenCaptureRectangle().getScreenCapture();
                } catch (AWTException e) {
                    e.printStackTrace();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
                ScreenCaptureRectangle.jFrame.addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent windowEvent) {
                        
                    }

                    @Override
                    public void windowClosing(WindowEvent windowEvent) {

                    }

                    @Override
                    public void windowClosed(WindowEvent windowEvent) {
                        try {
                            new GetDataImage().getImageContent(imagepath);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        imagepath = "test.jpg";
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imagepath).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_DEFAULT));
                        lblImage.setIcon(imageIcon);
                        try {
                            new SearchAPI().getResult(list_Tags.get(0).replaceAll("\\s+","+"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if(checkText){
                            JOptionPane.showMessageDialog(mF,"TEXT IN PICTURE: \n"+text_in_picture);
                            list_Tags.set(0,text_in_picture);
                        }
                        fillResult();
                        mF.setVisible(true);
                    }

                    @Override
                    public void windowIconified(WindowEvent windowEvent) {

                    }

                    @Override
                    public void windowDeiconified(WindowEvent windowEvent) {

                    }

                    @Override
                    public void windowActivated(WindowEvent windowEvent) {

                    }

                    @Override
                    public void windowDeactivated(WindowEvent windowEvent) {

                    }
                });
            }
        });

        btnImport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser chooser = new JFileChooser();
                chooser.setDialogTitle("Open");
                FileNameExtensionFilter f = new FileNameExtensionFilter("image", "jpg");
                chooser.setFileFilter(f);
                chooser.showOpenDialog(null);
                try {
                    imagepath = chooser.getSelectedFile().getAbsolutePath();
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon(imagepath).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_DEFAULT));
                    lblImage.setIcon(imageIcon);
                    try {
                        new GetDataImage().getImageContent(imagepath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    try {
                        new SearchAPI().getResult(list_Tags.get(0).replaceAll("\\s+","+"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if(checkText){
                        JOptionPane.showMessageDialog(mF,"TEXT IN PICTURE: \n"+text_in_picture);
                        list_Tags.set(0,text_in_picture);
                    }
                    fillResult();
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }
            }
        });
    }

    void fillList(){
        list_Model.removeAllItem();
        for (ModelResult modelResult : list_Result){
            list_Model.addItem(modelResult);
        }
    }
    
    void fillResult(){
        fillList();
        try {
            lblTag1.setText(list_Tags.get(0));
            lblTag1.setForeground(Color.yellow);
            lblTag1.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent mouseEvent) {
                    try {
                        new SearchAPI().getResult(list_Tags.get(0).replaceAll("\\s+","+"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    fillList();
                    lblTag1.setForeground(Color.yellow);
                    lblTag2.setForeground(Color.black);
                    lblTag3.setForeground(Color.black);
                    lblTag4.setForeground(Color.black);
                    lblTag5.setForeground(Color.black);
                }

                @Override
                public void mousePressed(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseReleased(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseEntered(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseExited(MouseEvent mouseEvent) {

                }
            });
            lblTag2.setText(list_Tags.get(1));
            lblTag2.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent mouseEvent) {
                    try {
                        new SearchAPI().getResult(list_Tags.get(1).replaceAll("\\s+","+"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    fillList();
                    lblTag1.setForeground(Color.black);
                    lblTag2.setForeground(Color.yellow);
                    lblTag3.setForeground(Color.black);
                    lblTag4.setForeground(Color.black);
                    lblTag5.setForeground(Color.black);
                }

                @Override
                public void mousePressed(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseReleased(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseEntered(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseExited(MouseEvent mouseEvent) {

                }
            });
            lblTag3.setText(list_Tags.get(2));
            lblTag3.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent mouseEvent) {
                    try {
                        new SearchAPI().getResult(list_Tags.get(2).replaceAll("\\s+","+"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    fillList();
                    lblTag1.setForeground(Color.black);
                    lblTag2.setForeground(Color.black);
                    lblTag3.setForeground(Color.yellow);
                    lblTag4.setForeground(Color.black);
                    lblTag5.setForeground(Color.black);
                }

                @Override
                public void mousePressed(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseReleased(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseEntered(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseExited(MouseEvent mouseEvent) {

                }
            });
            lblTag4.setText(list_Tags.get(3));
            lblTag4.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent mouseEvent) {
                    try {
                        new SearchAPI().getResult(list_Tags.get(3).replaceAll("\\s+","+"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    fillList();
                    lblTag1.setForeground(Color.black);
                    lblTag2.setForeground(Color.black);
                    lblTag3.setForeground(Color.black);
                    lblTag4.setForeground(Color.yellow);
                    lblTag5.setForeground(Color.black);
                }

                @Override
                public void mousePressed(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseReleased(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseEntered(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseExited(MouseEvent mouseEvent) {

                }
            });
            lblTag5.setText(list_Tags.get(4));
            lblTag5.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent mouseEvent) {
                    try {
                        new SearchAPI().getResult(list_Tags.get(4).replaceAll("\\s+","+"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    fillList();
                    lblTag1.setForeground(Color.black);
                    lblTag2.setForeground(Color.black);
                    lblTag3.setForeground(Color.black);
                    lblTag4.setForeground(Color.black);
                    lblTag5.setForeground(Color.yellow);
                }

                @Override
                public void mousePressed(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseReleased(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseEntered(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseExited(MouseEvent mouseEvent) {

                }
            });
        } catch (Exception e){}

        mF.setSize(620, 990);
        btnPin.setText("Pin");
    }
    
    

    @Override
    protected void paintChildren(Graphics grphcs){
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0,0,Color.decode("#4286f4"),0,getHeight(),Color.decode("#373B44"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth()-20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - nghia pham
    private JLabel lblImage;
    private JButton btnCap;
    private JButton btnImport;
    private JLabel label1;
    private JPanel panelListResult;
    private JScrollPane scrollPane1;
    private JList_Model list_Model;
    private JLabel lblTag1;
    private JLabel lblTag2;
    private JLabel lblTag3;
    private JLabel lblTag4;
    private JLabel lblTag5;
    private JButton btnPin;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
