/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.Piece;

/**
 *
 * @author tim
 */
public class MainWindow {
    
    
    public view.MainWindow mainView;
    private model.MainWindow mainModel;
    
    public MainWindow() {
        mainModel = new model.MainWindow(this);
        mainView = new view.MainWindow(this);
        mainView.setVisible(true);
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainWindow();
            }
        });
    }
    
   public String getName() {
       return mainModel.getName();
   }
    
    public String getDialogPath() {
        return mainModel.getPrevPath();
    }
    
    public void setDialogPath(String p) {
        mainModel.setPrevPath(p);
    }
    
    public void addBoard() {
        mainModel.addBoard();
        mainView.updateBoards();
        this.mainView.setMaxScroll(mainModel.getBoardsTotal());
    }
    
    public void deleteBoard() {
        mainModel.deleteBoard();
        mainView.updateBoards();
        this.mainView.setMaxScroll(mainModel.getBoardsTotal());
    }
    
    public void setBoard(int b) {
        mainModel.setBoard(b);
    }
    
    public int getBoardsTotal() {
        return mainModel.getBoardsTotal();
    }
    
    public void setTitle(String title) {
        mainView.setTitle(title);
    }
    
    public String getTitle() {
        return mainModel.getTitle();
    }
    
    public void addPiece(int position, char color) {
        mainModel.addPiece(position, color);
        this.setBWFEN();
    }
    
    public void updatePiece(int position) {
        mainModel.updatePiece(position);
        this.setBWFEN();
    }
    
    public void deletePiece(int position) {
        mainModel.deletePiece(position);
        this.setBWFEN();
    }
    
    public void setPiece(int position, int type) {
        mainModel.currentBoard.setPiece(position, type);
//        mainModel.setChanged();
//        this.setBWFEN();
    }
    
    public int getPieceType(int position) {
        return mainModel.getPieceType(position);
    }

    public String getDescription() {
        return mainModel.getDescription();
    }
    
    public void setDescription(String desc) {
        mainModel.setDescription(desc);
    }
    
    public void setBWFEN() {
        mainView.setFENTxt(mainModel.getBWFENString());
        mainView.setDescription(mainModel.getDescription());
    }
    
   public String getFilePath() {
       return mainModel.getFilePath();
   }
    
    public void setChanged() {
        mainModel.setChanged();
    }
    
    public void setUnchanged() {
        mainModel.setUnchanged();
    }
    
    public boolean isChanged() {
        return mainModel.isChanged();
    }
    
    public int getType(int position) {
        return mainModel.getType(position);
    }
    
    public void setFile(String fPath, String name) {
        mainModel.setFile(fPath, name);
        mainModel.setPrevPath(fPath);
        this.mainView.setMaxScroll(mainModel.getBoardsTotal());
        this.setUnchanged();
        setTitle(getTitle());
    }
    
    public Piece getViewPiece(int index) {
        return mainView.pieces.get(index);
    }
    
    public void save(String to, String filename) {
        mainModel.save(to, filename);
        if(!this.getName().equals(""))
            mainView.jMenuItem6.setEnabled(false);
    }

    public void setPrevPath(String p) {
        mainModel.setPrevPath(p);
    }
    
}
