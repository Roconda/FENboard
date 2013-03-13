/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Board;
import logic.FENParser;
import logic.InstanceIO;
import logic.PieceParser;
import view.ErrorDisplay;
import view.Piece;

/**
 *
 * @author tim
 */
public class MainWindow {

   private controller.MainWindow controller;
   private ArrayList<Board> boards = new ArrayList<Board>();
   private boolean isChanged = false;
   private String filePath = "";
   private String fileName = "";
   private String prevPath = "";
   public Board currentBoard;
   private int boardID = 0;
   
   public MainWindow(controller.MainWindow controller) {
       this.controller = controller;
       boards.add(new Board());
       currentBoard = boards.get(0);
   }

   public void setName(String name) {
       fileName = name;
   }
    
   public String getName() {
       return this.fileName;
   }
   
   public String getFilePath() {
       return this.filePath;
   }

   public void setPrevPath(String p) {
       prevPath = p;
   }
    
   public String getPrevPath() {
       return this.prevPath;
   }
   public void addBoard() {
       setChanged();
       boards.add(new Board());
       this.setTitle();
   }
   
   public void deleteBoard() {
       if(getBoardsTotal() > 1) {
        setChanged();
        boards.remove(boardID);
        this.setTitle();
       }
   }
   
   public void unloadBoards() {
       boards.removeAll(boards);
       this.isChanged = false;
       this.boardID = 0;
   }
   
   public int getBoardsTotal() {
       return boards.size();
   }
   
   public void nextBoard() {
       try {
        currentBoard = boards.get(boardID++);
        boardID++;
       }catch(IndexOutOfBoundsException e) {
           e.printStackTrace();
       }
       this.setTitle();
   }
   
   public void setBoard(int id) {
       currentBoard = boards.get(id);
       boardID = id;
       setViewPieces();
       controller.setBWFEN();
       controller.setDescription(controller.getDescription());
       setTitle();
       System.out.println(boardID);
   }
   
   public void previousBoard() {
       if( boards.size() > 1 ) {
           try {
            currentBoard = boards.get(boardID--);
            boardID--;
           }catch(IndexOutOfBoundsException e) {
               e.printStackTrace();
           }
           this.setTitle();
       }
   }
   
   public String getTitle() {
       Formatter form = new Formatter();
       
       String changed = ( isChanged() ) ? "*" : "";
       String fName = ( getName().equals("") ) ? "Untitled" : getName();
       
       Formatter tit = form.format("%s %s, diagram %d of %d", changed, fName, boardID+1, boards.size());
       
       return tit.toString();
   }
   
   public void setTitle() {
       controller.setTitle(getTitle());
   }
   
    public void addPiece(int position, char color) {
        setChanged();
        currentBoard.addPiece(position, color);
    }
    
    public void updatePiece(int position) {
        setChanged();
        currentBoard.updatePiece(position);
    }
    
    public void deletePiece(int position) {
        setChanged();
        currentBoard.deletePiece(position);
    }
    
    public int getPieceType(int position) {
        setChanged();
        return currentBoard.getPieceType(position);
    }
   
    public boolean isChanged() {
        return this.isChanged;
    }
    
    public void setUnchanged() {
        this.isChanged = false;
        controller.mainView.jMenuItem6.setEnabled(false);
        setTitle();
    }
    
    public void setChanged() {
        this.isChanged = true;
        if(!this.getName().equals(""))
            controller.mainView.jMenuItem8.setEnabled(true);
        setTitle();
    }
    
    public String getDescription() {
        return currentBoard.getDescription();
    }
    
    public void setDescription(String desc) {
        setChanged();
        currentBoard.setDescription(desc);
    }
    
    public String getBWFENString() {
        return currentBoard.toString();
    }
    
    public int getType(int position) {
        return currentBoard.getPieceType(position-1);
    }
  
   
    public void setFile(String path, String name) {
        this.unloadBoards();
        InstanceIO iio = new InstanceIO();
        iio.setLocation(path);
        try {
            iio.readFile();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        FENParser fp = new FENParser();
        fp.loadFENs(iio.getContent());
        throwErrors(fp.getErrors());
        loadFENs(fp.getFENs(), fp);
        this.fileName = name;
        this.filePath = path;
    }
    
    private void loadFENs(ArrayList<String> fen, FENParser fp) {
        ArrayList<String> fens = fen;
        int i=0;
        for(String f : fens) {
            String[] ff = f.split(":");
            String[] w = ff[0].split(",");
            String[] b = ff[1].split(",");
            String desc = fp.getDesc(i);
            Board board = new Board();
            boards.add(board);
            this.currentBoard = board;
            controller.setDescription(desc);
            
            for(String s : w){
                if(s.startsWith("W"))
                    s = s.substring(1, s.length());
                int position = 0;
                try{
                    position = ( s.startsWith("K") ) ? Integer.parseInt(s.substring(1, s.length())) : Integer.parseInt(s);
                }catch(NumberFormatException e){
                    //
                }
                controller.setPiece(position, new PieceParser().FEN2Value(s, 'W'));
            }
            
            for(String s : b){
                if(s.startsWith("B"))
                    s = s.substring(1, s.length());
                int position = ( s.startsWith("K") ) ? Integer.parseInt(s.substring(1, s.length())) : Integer.parseInt(s);
                controller.setPiece(position, new PieceParser().FEN2Value(s, 'B'));
            }
            i++;
        }
        setBoard(0);
        setViewPieces();
        controller.mainView.jMenuItem8.setEnabled(false);
        this.isChanged = false;
        controller.mainView.jMenuItem6.setEnabled(true);
    }
    
    private void setViewPieces() {
          for(int i=0; i<50; i++){
            view.Piece viewP = controller.getViewPiece(i);
            viewP.setType(currentBoard.pieces.get(i).getType());
          }
    }
    
    private void throwErrors(ArrayList<String> err){
        if(err.size() > 0) {
            ErrorDisplay ed = new ErrorDisplay(new view.FrameDialog(), true);
            for(String str : err)
                ed.txt.append(str+"\n");
            ed.setVisible(true);
        }
    }
    
    public void save(String path, String filename) {
        String file = null;
        if(path.equals("")){
            file = this.getFilePath();
        }else{
            file = this.filePath;
        }
        ArrayList<String> fen = new ArrayList<String>();

        for(Board board : boards )
            fen.add(board.toString()+" "+board.getDescription());

        InstanceIO iio = new InstanceIO();
        iio.setLocation(path);
        iio.setContent(fen);
        iio.writeFile();
        this.isChanged = false;
        this.setTitle();
        this.fileName = filename;
        this.filePath = path;
    }
}
