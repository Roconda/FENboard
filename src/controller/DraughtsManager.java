package controller;

import java.awt.EventQueue;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author tim
 */
public class DraughtsManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainWindow m = new MainWindow();
		} catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
    }
    
}
