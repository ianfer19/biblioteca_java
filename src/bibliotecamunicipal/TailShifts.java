/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecamunicipal;

/**
 *
 * @author Iam Fernandez
 */
public class TailShifts {
    static final int n = 100;
    private int front;
    private int tailend;
    private String[] queuedata = new String[n];
    
    public TailShifts(){
        front = 0;
       tailend = -1;
    }
    
    public void crearVector(){
        queuedata = new String[n];
    }
    
    public int getFront(){
        return front;
    }
    
    public int getEnd(){
        return tailend;
    }
    
    private void Displace(){
        for(int i = 1; i <= getEnd(); i++){
            queuedata[i - 1] = queuedata[1];
        }
    }
    
    public boolean TailEmpty() {
        if (getEnd() == -1) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean TailFull() {
        if (getEnd() >= n - 1) {
            return true;
        } else {
            return false;
        }
    }
        
    public void add(String dato) {
        if (!TailFull()) {
            tailend = getEnd() + 1;
            queuedata[getEnd()] = dato; 
        }
    }    
    
    public void remove() {
        if (!TailEmpty()) { 
            Displace(); 
            tailend = getEnd() - 1;
        }
    }
    
    public String  valueFront() {
        return queuedata[getFront()];
    }

    public String valueEnd() {
        return queuedata[getEnd()];
    }

    public void cleanupTail() {
        while (!TailEmpty()) { 
            remove(); 
        }
    }
}


