/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author tim
 */
public class FENParser {
    
    private ArrayList<String> fens = new ArrayList<String>();
    private ArrayList<String> fensWd = new ArrayList<String>(); //zonder descriptie
    private ArrayList<String> descriptions = new ArrayList<String>();
    private ArrayList<String> errors = new ArrayList<String>();
    
    public FENParser() {
    }
    
    public void loadFENs(ArrayList<String> arr) {
        fens = arr;
        validateFENs();
    }
    
    private boolean parsableToInt(String str) {
        try{
            Integer.parseInt(str);
        }catch(NumberFormatException e){
            this.addError(4);
            return false;
        }
        if(betweenBounds(str)){
            return true;
        }else{
            this.addError(3);
            return false;
        }
    }
    
    private boolean betweenBounds(String str) {
        if(Integer.parseInt(str) > 0 && Integer.parseInt(str) <= 50)
            return true;
        else
            this.addError(3);
            return false;
    }
    
    private boolean parsePosition(String str) {
        //check if King
        if(str.substring(0,1).equals("K")){
            if(parsableToInt(str.split("K")[1])){
                if(betweenBounds(str.split("K")[1]))
                    return true;
                else
                    return false;
            }else
                return false;
        }else{
          return this.parsableToInt(str);  
        }
    }
    
    public boolean isFEN(String str) {
        if(str.length() == 0)
            return true;
        if(str.equals("")){
            this.addError(4);
            return false;
        }else
            return parsePosition(str);
    }

    
    private void validateFENs() {
        if(fens.size() > 0) {
            String w = null;
            String b = null;
            String c = null;
            
            for(String str : fens) {
                String[] split = str.split(":");
                if(split.length >= 2) {
                    c = "";
                    w = split[0];
                    String[] bc = split[1].split(" ");
                    b = bc[0];
                    for(int i=1; i<bc.length; i++)
                        c += bc[i]+" ";
                    c = c.trim();
                    this.fensWd.add(w+":"+b);
                    this.descriptions.add(c);
                }else{
                    this.addError(0);
                }
            
                if(!w.startsWith("W"))
                    this.addError(1);
                if(!b.startsWith("B"))
                    this.addError(2);
            }
        }
    }
    
    public ArrayList<String> getFENs() {
        return this.fensWd;
    }
    
    public String getDesc(int fen) {
        return this.descriptions.get(fen);
    }
    
    private void addError(int type) {
        switch(type) {
            case 0:
                errors.add("Not a valid FEN notation");
                break;
            case 1:
                errors.add("No white pieces detected; first character should be 'W'");
                break;
            case 2:
                errors.add("No black pieces detected; first character should be 'B'");
            case 3:
                errors.add("Out of bound");
            case 4:
                errors.add("Not a number");
            default:
                errors.add("Unspecified error");
        }
    }
    
    public ArrayList<String> getErrors() {
        return errors;
    }
    
    public int getBoardCnt() {
        return fens.size();
    }
    
    
    
}
