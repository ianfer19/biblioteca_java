/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecamunicipal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Iam Fernandez
 */
public class ArchiveRecords {
    
private String routerecords;
    File records;

    public void Archive() { 
        routerecords = "";
    }

    public void setRoutaArchive(String nom) { 
        routerecords = nom;
    }

    public String getRoutaArchive() {
        return routerecords;
    }

    public String Convert(int dato) {
        return String.valueOf(dato);
    }
    
    public void guardarArchivo(User us) throws IOException {
        records = new File(getRoutaArchive());
        BufferedWriter escribir;
        if (records.exists()) {
            escribir = new BufferedWriter(new FileWriter(records, true));
            escribir.write(Convert(us.getBookCode()) +"--");
            escribir.write(us.getUserName()+"--");
            escribir.write(Convert(us.getUserIdentification()) +"--");
            escribir.write(us.getDate()+"--");
            escribir.newLine();
            JOptionPane.showMessageDialog(null, "SUCCESSFULLY LOANED BOOK");
        } else {
            escribir = new BufferedWriter(new FileWriter(records));
            escribir.write(Convert(us.getBookCode()) + "--");
            escribir.write(us.getUserName()+ "--");
            escribir.write(Convert(us.getUserIdentification())+"--");
            escribir.write(us.getDate()+"--");
            escribir.newLine();
            JOptionPane.showMessageDialog(null, "SUCCESSFULLY LOANED BOOK");
        }
        escribir.close();
    }
    
    public void leerArchivoDos(String rutaArchivo) throws FileNotFoundException, IOException {
        String linea = null;
        User us;
        FileReader fichero = new FileReader(rutaArchivo);
        BufferedReader leer = new BufferedReader(fichero);
        
        while ((linea = leer.readLine()) != null) {
            StringTokenizer campo = new StringTokenizer(linea, "--");
            String  bc = campo.nextToken().trim();
            String  usn = campo.nextToken().trim();
            String  id = campo.nextToken().trim();
            String  dt = campo.nextToken().trim();
                        
            us = new User();
            us.setBookCode(Integer.parseInt(bc));
            us.setUserName(usn);
            us.setUserIdentification(Integer.parseInt(id));
            us.setDate(dt);
                        
            JOptionPane.showMessageDialog(null, "======== HISTORY INFORMATION ========"
            + "\n\n" + "CODE: " + us.getBookCode()+ "\nDate: " + us.getDate()
            + "\nUSER: " + us.getUserName()+ "\nUSER IDENTIFICATION: " + us.getUserIdentification()+ "\n\n");
        }
        leer.close();
    }

   
}

