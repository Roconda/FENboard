/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import logic.PieceParser;

/**
 *
 * @author tim
 */
public class Piece extends JLabel implements MouseListener {
    
    private controller.MainWindow controller;
    private int position;
    private int type = 0;
    private JLayeredPane lp = new JLayeredPane();
    
    public Piece(controller.MainWindow controller) {
        lp.add(this, 1);
        this.controller = controller;
        this.addMouseListener(this);
        this.addLayer();
    }
    
    public void setPosition(int pos) {
        this.position = pos;
    }
    
    public int getPosition() {
        return this.position;
    }
    
    public void setType(int type) {
        this.type = type;
        setBG();
    }
    
    public int getType() {
        return this.type;
    }
    
    private void setBG() {
        String pic = new PieceParser().getType2IMG(this.getType());
        InputStream is = new BufferedInputStream(this.getClass().getResourceAsStream("/resources/icons/pieces/"+pic+".gif"));
        BufferedImage img;
        try {
            img = ImageIO.read(is);
        } catch (IOException ex) {
            ex.printStackTrace();
            // om te garanderen dat img altijd geinitaliseerd wordt
            img = null;
        }
        this.setIcon(new ImageIcon(img));
        this.updateUI();
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        boolean shift = ( arg0.getModifiersEx() == arg0.SHIFT_DOWN_MASK + arg0.BUTTON1_DOWN_MASK );
        switch(getType()) {
            case 0:
                if(shift) controller.addPiece(getPosition(), 'B');
                else controller.addPiece(getPosition(), 'W');
                break;
            case 1:
            case 3:
                if(shift && type == 1) controller.addPiece(getPosition(), 'B');
                else if(shift && type == 3) controller.addPiece(getPosition(), 'W');
                else controller.updatePiece(getPosition());
                break;
            case 2:
            case 4:
                if(shift && type == 2) controller.setPiece(getPosition(), 4);
                else if(shift && type == 4) controller.setPiece(getPosition(), 2);
                else
                    controller.deletePiece(getPosition());
                controller.setBWFEN();
        }
        controller.isChanged();
        if(!controller.getName().equals(""))
            controller.mainView.jMenuItem6.setEnabled(true);
        setType(controller.getType(getPosition()));
        setBG();
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    private void addLayer() {
        lp.add(new JLabel("B"), 2);
    }

}
