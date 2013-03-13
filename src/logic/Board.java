/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.Observable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import logic.BoardPiece;
import logic.PieceParser;

/**
 *
 * @author tim
 */
public class Board {
    
    public ArrayList<BoardPiece> pieces = new ArrayList<BoardPiece>();
    private String description = "";
    private String[] currentLayout;
    private PieceParser pieceParser;
    
    public Board() {
        initPieces();
    }
    
    public void initPieces() {
        for (int i=1; i<51; i++) {
            pieces.add(new BoardPiece(i));
        }
    }
    
    /**
     * Export to black and white FEN.
     * Requires description to be appended for complete FEN notation
     * @return 
     */
    public String toString() {
        String piecesW = "W";
        String piecesB = "B";
        int i = 1;
        for ( BoardPiece piece : pieces ) {            
            switch(piece.getType()){
                case 1:
                    piecesW += i+",";
                    break;
                case 2:
                    piecesW += "K"+i+",";
                    break;
                case 3:
                    piecesB += i+",";
                    break;
                case 4:
                    piecesB += "K"+i+",";
                    break;
            }
            i++;
        }
        if(piecesW.length() > 1)
            piecesW = piecesW.substring(0, piecesW.length()-1);
        if(piecesB.length() > 1)
            piecesB = piecesB.substring(0, piecesB.length()-1);
        
        return piecesW+":"+piecesB;
    }
    
    public int getPieceType(int position) {
        return pieces.get(position).getType();
    }
    
    public void addPiece(int position, char color) {
        int type = ( color == 'W' ) ? 1 : 3;
        pieces.get(position-1).setType(type);
    }
    
    /**
     * DEBUG FUNCTION
     */
    private void loopall() {
        int i=0;
        for (BoardPiece p : pieces) {
            System.out.println(i+"="+p.getType());
            i++;
        }
    }
    
    
    public void updatePiece(int position) {
        pieces.get(position-1).upgradeType();
    }
    
    public void deletePiece(int position) {
        pieces.get(position-1).setType(0);
    }
    
    public void setPiece(int position, int type) {
        try{
            pieces.get(position-1).setType(type);
        }catch(ArrayIndexOutOfBoundsException e){
            //e.printStackTrace();
        }
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String desc) {
        this.description = desc;
    }
    
}
