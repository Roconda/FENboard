/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.*;
import logic.FENParser;

/**
 *
 * @author tim
 */
public class MainWindow extends javax.swing.JFrame implements WindowListener {
    
    private Piece[] boardPieces = new Piece[100];
    public ArrayList<Piece> pieces = new ArrayList<Piece>();
    private controller.MainWindow controller;
    private final static String NOTATION_IS_OKAY = "Correct FEN - position";

    /**
     * Creates new form MainWindow
     */
    public MainWindow(controller.MainWindow controller) {
        this.controller = controller;
        this.addWindowListener(this);
        initComponents();
        initBoard();
        this.setTitle(controller.getTitle());
        this.setDescription(controller.getDescription());
        updateBoards();
        this.setPiecesInitial();
        this.jScrollBar1.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jContainer = new javax.swing.JPanel();
        jPanelFEN = new javax.swing.JPanel();
        jTextFieldFENW = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldFENB = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextFieldDesc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollBar1 = new javax.swing.JScrollBar();
        jPanelBoard = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(192, 211, 235));
        setMaximumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(650, 600));

        jContainer.setBackground(new java.awt.Color(192, 211, 235));

        jPanelFEN.setBackground(new java.awt.Color(192, 211, 235));
        jPanelFEN.setPreferredSize(new java.awt.Dimension(557, 224));

        jTextFieldFENW.setText("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20");
        jTextFieldFENW.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jTextFieldFENWComponentAdded(evt);
            }
        });
        jTextFieldFENW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFENWActionPerformed(evt);
            }
        });

        jLabel2.setText("B");

        jTextFieldFENB.setText("31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50");
        jTextFieldFENB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFENBActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setRows(5);
        jTextArea1.setText("Correct FEN - position");
        jScrollPane1.setViewportView(jTextArea1);

        jTextFieldDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDescActionPerformed(evt);
            }
        });
        jTextFieldDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDescKeyPressed(evt);
            }
        });

        jLabel1.setText("W");

        javax.swing.GroupLayout jPanelFENLayout = new javax.swing.GroupLayout(jPanelFEN);
        jPanelFEN.setLayout(jPanelFENLayout);
        jPanelFENLayout.setHorizontalGroup(
            jPanelFENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFENLayout.createSequentialGroup()
                .addGroup(jPanelFENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDesc)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanelFENLayout.createSequentialGroup()
                        .addGroup(jPanelFENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelFENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldFENB)
                            .addComponent(jTextFieldFENW))))
                .addContainerGap())
        );
        jPanelFENLayout.setVerticalGroup(
            jPanelFENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFENLayout.createSequentialGroup()
                .addComponent(jTextFieldDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFENW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFENB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        jButton1.setText("Empty board");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollBar1.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                jScrollBar1AdjustmentValueChanged(evt);
            }
        });
        jScrollBar1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jScrollBar1MouseDragged(evt);
            }
        });
        jScrollBar1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jScrollBar1PropertyChange(evt);
            }
        });

        jPanelBoard.setBackground(java.awt.Color.red);
        jPanelBoard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelBoard.setPreferredSize(new java.awt.Dimension(232, 232));

        javax.swing.GroupLayout jPanelBoardLayout = new javax.swing.GroupLayout(jPanelBoard);
        jPanelBoard.setLayout(jPanelBoardLayout);
        jPanelBoardLayout.setHorizontalGroup(
            jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        jPanelBoardLayout.setVerticalGroup(
            jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        jButton2.setText("Initial position");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jContainerLayout = new javax.swing.GroupLayout(jContainer);
        jContainer.setLayout(jContainerLayout);
        jContainerLayout.setHorizontalGroup(
            jContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jContainerLayout.createSequentialGroup()
                        .addComponent(jPanelBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addComponent(jPanelFEN, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jContainerLayout.setVerticalGroup(
            jContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jContainerLayout.createSequentialGroup()
                .addGroup(jContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jContainerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jContainerLayout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2))
                            .addComponent(jPanelBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(jPanelFEN, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
                    .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("New");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Open");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);
        jMenu1.add(jSeparator3);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Save");
        jMenuItem6.setEnabled(false);
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText("Save as");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);
        jMenu1.add(jSeparator2);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setText("Revert");
        jMenuItem8.setEnabled(false);
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);
        jMenu1.add(jSeparator1);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Quit");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Add diagram");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Delete diagram");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Extra");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldFENWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFENWActionPerformed
        parseFENInput(this.jTextFieldFENW, 'W');
    }

    private void parseFENInput(JTextField field, char color) {
        ArrayList<Integer> tmpBefore = new ArrayList<Integer>();
        ArrayList<Integer> tmpNew = new ArrayList<Integer>();
        for(int i=0; i<50; i++){
            int type = controller.getPieceType(i);
            int[] allowed = new int[2];
            allowed[0] = (color == 'W')? 1 : 3;
            allowed[1] = (color == 'W')? 2 : 4;
            //System.out.println(""+allowed[0] + allowed[1]);
            if(type == allowed[0] || type == allowed[1]){
                tmpBefore.add(i);
            }
        }
        FENParser fp = new FENParser();
        int pos = 0;
        for(String s : field.getText().split(",")) {
            if(!fp.isFEN(s)) {
                field.setSelectionStart(pos);
                field.setSelectionEnd(pos+s.length());
                this.jTextArea1.setText(fp.getErrors().get(0));
                break;
            }else{
                tmpNew.add(this.getPos(s)-1);
                //System.out.println("POS: "+this.getPos(s) +"  TYPE: "+ this.getType(s, color));
                controller.setPiece(this.getPos(s), this.getType(s, color));
                //System.out.println(controller.getType(this.getPos(s)));
                this.pieces.get(this.getPos(s)-1).setType(controller.getType(this.getPos(s)));
                this.jTextArea1.setText(NOTATION_IS_OKAY);
            }
            pos += s.length()+1;
        }
        for(int p=0; p<tmpBefore.size(); p++){
            boolean hasItem = false;
            for(Integer pp : tmpNew) {
                if(pp == p) {
                    //System.out.println("is true"+ pp + " en "+ p);
                    hasItem = true;
                }else{
                    //System.out.println("is false!! "+pp+" en "+p);
                }
            }
            if(!hasItem){
                controller.deletePiece(tmpBefore.get(p)+1);
                this.pieces.get(tmpBefore.get(p)).setType(0);
            }
        }
        controller.setBWFEN();
    }//GEN-LAST:event_jTextFieldFENWActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setPiecesInitial();
        controller.setChanged();
        controller.setBWFEN();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        for ( Piece p : pieces ) {
            controller.deletePiece(p.getPosition());
            p.setType(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(controller.isChanged()) {
            FrameDialog f = new FrameDialog();
            NewDialog od = new NewDialog(f, true, controller);
            od.setVisible(true);
        }else{
            Chooser c = new Chooser(controller, controller.getDialogPath());
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        controller.addBoard();
        this.jScrollBar1.setEnabled(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        controller.deleteBoard();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jTextFieldDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDescActionPerformed

    }//GEN-LAST:event_jTextFieldDescActionPerformed

    private void jTextFieldDescKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDescKeyPressed
        if(evt.getKeyCode() == 10) {
            controller.setDescription(jTextFieldDesc.getText());
        }
    }//GEN-LAST:event_jTextFieldDescKeyPressed

    private void jTextFieldFENWComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jTextFieldFENWComponentAdded
    }//GEN-LAST:event_jTextFieldFENWComponentAdded

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        closeApp();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if(controller.isChanged()) {
            FrameDialog fd = new FrameDialog();
            OpenDialog od = new OpenDialog(fd, true, controller);
            od.setVisible(true);
        }else{
            Chooser c = new Chooser(controller, controller.getDialogPath());
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        RevertDialog rd = new RevertDialog(new FrameDialog(), true, controller);
        rd.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        controller.save(controller.getFilePath(), controller.getName());
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Saver saver = new Saver(controller, controller.getDialogPath());
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jScrollBar1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollBar1MouseDragged

    }//GEN-LAST:event_jScrollBar1MouseDragged

    private void jScrollBar1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jScrollBar1PropertyChange
    }//GEN-LAST:event_jScrollBar1PropertyChange

    private void jScrollBar1AdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_jScrollBar1AdjustmentValueChanged
        controller.setBoard(evt.getValue());
    }//GEN-LAST:event_jScrollBar1AdjustmentValueChanged

    private void jTextFieldFENBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFENBActionPerformed
        parseFENInput(this.jTextFieldFENB, 'B');
    }//GEN-LAST:event_jTextFieldFENBActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
    }
    
    private int diffInt( int i ) {
        return ( i == 0 ) ? 1 : 0;
    }
    
    public void setMaxScroll(int max) {
        this.jScrollBar1.setVisibleAmount(0);
        this.jScrollBar1.setValue(0);
        this.jScrollBar1.setMaximum(max-1);
        this.jScrollBar1.setEnabled(true);
    }
    
    private int getPos(String str) {
        if(str.substring(0, 1).equals("K"))
            return Integer.parseInt(str.substring(1, str.length()));
        else
            return Integer.parseInt(str);
    }
    
    private int getType(String str, char color) {
        int val;
        if(str.substring(0, 1).equals("K"))
            val = 2;
        else
            val = 1;
        
        if(color == 'B')
            val += 2;
        
        return val;
    }
    
    private void closeApp() {
        if(controller.isChanged()) {
            FrameDialog f = new FrameDialog();
            ShutdownDialog d = new ShutdownDialog(f, false);
            d.setVisible(true);
        }else
            System.exit(0);
    }
    
    public void setFENTxt(String str) {
        String[] bw = str.split(":");
        jTextFieldFENW.setText(bw[0].substring(1));
        jTextFieldFENB.setText(bw[1].substring(1));
    }
    
    public void updateBoards() {
        if(controller.getBoardsTotal() < 2) {
            jMenuItem3.setEnabled(false);
        }else{
            jMenuItem3.setEnabled(true);
        }
    }
   
    
    private void initBoard() {
        int i=0;
        int counter = 0;
        int pos_x = 1;
        int pos_y = 1;
        int locationNumber = 1;
        String locationName = null;
        for ( Piece label : boardPieces ) {
            // welke image moeten we gebruiken?
            if ( counter == 0 ) {
                label = new Piece(controller);
                label.setType(-1);
                label.setName("");
                locationName = null;
            }else {
                // hier kan een steen op staan
                locationName = "vak_"+locationNumber;
                label = new Piece(controller);
                label.setType(0);
                JLabel ll = new JLabel();
                ll.setHorizontalTextPosition(ll.LEFT);
                ll.setVerticalTextPosition(ll.BOTTOM);
                ll.setText("B");
                ll.setVisible(true);
                label.add(ll);
                label.setName(locationName);
                label.setPosition(locationNumber);
                this.pieces.add(label);
                locationNumber++;
            } 
            jPanelBoard.add(label);
            label.setName(locationName);
            label.setBounds(pos_x, pos_y, 23, 23);
            if ( jPanelBoard.getWidth()-24 == pos_x ) {
                // einde regel, nieuwe regel beginnen en weer bij links beginnen
                pos_x = 1;
                pos_y += 23;
                counter = this.diffInt(counter);
            }else{
                pos_x += 23;
            }
            counter = this.diffInt(counter);
            i++;
        }
    }
    
    private void setPiecesInitial() {
        int i=0;
        for (Piece p : pieces) {
            if(p.getPosition() <= 20) {
                p.setType(1);
                controller.setPiece(i+1, 1);
            }else if (p.getPosition() > 30){
                p.setType(3);
                controller.setPiece(i+1, 3);
            }
            i++;
            
        }
    }
    
    public String getDescription() {
        return jTextFieldDesc.getText();
    }
    
    public void setDescription(String desc) {
        jTextFieldDesc.setText(desc);
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jContainer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    public javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    public javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanelBoard;
    private javax.swing.JPanel jPanelFEN;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldDesc;
    private javax.swing.JTextField jTextFieldFENB;
    private javax.swing.JTextField jTextFieldFENW;
    // End of variables declaration//GEN-END:variables

    @Override
    public void windowOpened(WindowEvent arg0) {
    }

    @Override
    public void windowClosing(WindowEvent arg0) {
        closeApp();
    }

    @Override
    public void windowClosed(WindowEvent arg0) {
    }

    @Override
    public void windowIconified(WindowEvent arg0) {
    }

    @Override
    public void windowDeiconified(WindowEvent arg0) {
    }

    @Override
    public void windowActivated(WindowEvent arg0) {
    }

    @Override
    public void windowDeactivated(WindowEvent arg0) {
    }
}
