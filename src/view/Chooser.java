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
public class Chooser extends JFileChooser {
    
    private File file;
    private controller.MainWindow controller;
    
    public Chooser(controller.MainWindow controller, String path) {
        this.controller = controller;
        this.setPath(path);
        this.setMultiSelectionEnabled(false);
        this.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("FEN diagrams", "dmd");
        this.setFileFilter(filter);
        this.showOpenDialog(null);
        file = this.getSelectedFile();
        controller.setFile(file.getAbsolutePath(), file.getName());
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
