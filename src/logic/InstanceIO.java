/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author tim
 */
public class InstanceIO {
    
    private String fPath;
    private ArrayList<String> content = new ArrayList<String>();
    private BufferedReader bufferR;
    private boolean success = true;

    public InstanceIO() {
    }
    
    public void setLocation(String p) {
        this.fPath = p;
    }
    
    public String getLocation() {
        return this.fPath;
    }
    
    public void setContent(ArrayList<String> arr) {
        this.content = arr;
    }
    
    public void readFile() throws FileNotFoundException, IOException {
        try {
            bufferR = new BufferedReader(new FileReader(fPath));
            String str;
            while((str = bufferR.readLine()) != null) {
                content.add(str);
            }
        }catch(IllegalArgumentException e){
            this.success = true;
            e.printStackTrace();
        }
        bufferR.close();
    }
    
    public void writeFile() {
        try {
            BufferedWriter bufferW = new BufferedWriter(new FileWriter(this.getLocation()));
            for(String str : this.content) {
                bufferW.write(str);
                bufferW.newLine();
            }
            bufferW.close();
        } catch (IOException e) {
            this.success = false;
            e.printStackTrace();
        }
    }
    
    public ArrayList<String> getContent() {
        return this.content;
    }
}
