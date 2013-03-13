/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author tim
 */
public class Saver extends JFileChooser {
    
    private File file;
    private controller.MainWindow controller;
    
    public Saver(controller.MainWindow controller, String path) {
        this.controller = controller;
        this.setPath(path);
        this.setMultiSelectionEnabled(false);
        this.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("FEN diagrams", "dmd");
        this.setFileFilter(filter);
        this.showSaveDialog(null);
        file = this.getSelectedFile();
        controller.setPrevPath(file.getAbsolutePath());
        if(controller.getName().equals(""))
            controller.save(file.getAbsolutePath()+".dmd", file.getName()+".dmd");
        else
            controller.save(file.getAbsolutePath(), file.getName());
        controller.setUnchanged();
    }

    
    private void setPath(String path) {
        if(path.equals("")) {
            controller.setDialogPath(System.getProperty("user.dir"));
            File f = new File(System.getProperty("user.dir"));
            this.setCurrentDirectory(f);
        }else{
            File f = new File(controller.getDialogPath());
            this.setCurrentDirectory(f);
        }
    }
    
    public String getFileName() {
        return file.getName();
    }
    
    public String getAbsPath() {
        return file.getAbsolutePath();
    }
    
}
