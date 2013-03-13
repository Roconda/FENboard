/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;


/**
 *
 * @author tim
 */
public class BoardPiece {
    
   private int boardPosition;
   private int pieceType = 0;
   // waardes:
   //   0 - empty
   //   1 - wit normaal
   //   2 - wit king
   //   3 - zwart normaal
   //   4 - zwart king
   
   
   public BoardPiece(int bPos){
       boardPosition = bPos;
   }
   
   public int getPos() {
       return boardPosition;
   }
   
   public int getType() {
       return pieceType;
   }
   
   public void setType(int type) {
       pieceType = type;
   }
   
   public void upgradeType() {
       if ( pieceType == 1 ^ pieceType == 3 ) {
           pieceType++;
       }
       
   }
      
   

}
