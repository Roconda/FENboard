/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author tim
 */
public class PieceParser {
    
    private String pattern = "";
    
    public int FEN2Value(String val, char color) {
        switch(color) {
            case 'W':
                if (val.substring(0, 1).equals("K"))
                    return 2;
                else
                    return 1;
            case 'B':
                if (val.substring(0,1).equals("K"))
                    return 4;
                else
                    return 3;
        }
        return 0;
    }
    
    public String getType2IMG(int type) {
        switch(type){
            case 0:
                return "sqb";
            case 1:
                return "wm";
            case 2:
                return "wk";
            case 3:
                return "bm";
            case 4:
                return "bk";
            default:
                return "sqw";
        }
    }
    
    public int getIMG2Type(String img) {
        if(img.equals("sqb"))
            return 0;
        else if(img.equals("wm"))
            return 1;
        else if(img.equals("wk"))
            return 2;
        else if(img.equals("bm"))
            return 3;
        else if(img.equals("bk"))
            return 4;
        else
            return 0;
//        switch(img){
//            case "sqb":
//                return 0;
//            case "wm":
//                return 1;
//            case "wk":
//                return 2;
//            case "bm":
//                return 3;
//            case "bk":
//                return 4;
//            default:
//                return 0;
        }
    }
    
//    private void setBoard(String[] white, String[] black) {
//        Pattern p = Pattern.compile("[0-9]+");
//
//        for ( String str : white) {
//            int value = pieceParser.FEN2Value(str, 'W');
//            Matcher place = p.matcher(str);
//            setPiece(Integer.parseInt(place.group()), value);
//        }
//        for (String str : black) {
//            int value = pieceParser.FEN2Value(str, 'B');
//            Matcher place = p.matcher(str);
//            setPiece(Integer.parseInt(place.group()) ,value);
//        }
//    }