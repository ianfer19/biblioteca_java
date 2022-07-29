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
public class ArchiveBooks {
    
 private String routerecords;
    File records;
    
    public ArchiveBooks(){
        routerecords = "";
    }
    
    public void setRouteRecords(String nom){
        routerecords = nom;
    }
    
    public String getRouteRecords(){
        return routerecords;
    }
    
    public String Convert(int dato){
        return String.valueOf(dato);
    }
    
    public void GuardarArchivo(Books b) throws IOException {
        records = new File(getRouteRecords());
        BufferedWriter escribir;
        
        if(records.exists()){
            escribir = new BufferedWriter(new FileWriter(records, true));
            escribir.write(Convert(b.getCode()) + "--");
            escribir.write(b.getName()+ "--");
            escribir.write(b.getAuthor()+ "--");
            escribir.write(b.getEditorial()+ "--");
            escribir.write(Convert(b.getYear()) + "--");
            escribir.write(b.getCategory()+ "--");
            escribir.newLine();
        }
        else{
            escribir = new BufferedWriter(new FileWriter(records));
            escribir.write(Convert(b.getCode()) + "--");
            escribir.write(b.getName()+ "--");
            escribir.write(b.getAuthor()+ "--");
            escribir.write(b.getEditorial() + "--");
            escribir.write(Convert(b.getYear()) + "--");
            escribir.write(b.getCategory()+ "--");
            escribir.newLine();
        }
        escribir.close();
    }
    
    public void LeerArchivos(String rutaArchivo) throws FileNotFoundException, IOException {
        String linea = null;
        Books b;
        FileReader fichero = new FileReader(rutaArchivo);
        BufferedReader leer = new BufferedReader(fichero);
        
        while((linea = leer.readLine()) != null){
            StringTokenizer campo = new StringTokenizer(linea, "--");
            String cd = campo.nextToken().trim();
            String nam = campo.nextToken().trim();
            String aut = campo.nextToken().trim();
            String edt = campo.nextToken().trim();
            String yp = campo.nextToken().trim();
            String ctg = campo.nextToken().trim();
            b = new Books();
            b.setCode(Integer.parseInt(cd));
            b.setName(nam);
            b.setAuthor(aut);
            b.setEditorial(edt);
            b.setYear(Integer.parseInt(yp));
            b.setCategory(ctg);        
            
            JOptionPane.showMessageDialog(null, "======== ARCHIVE INFORMATION ========"
            + "\n\n" + "CODE: " + b.getCode()+ "\nNAME BOOK: " + b.getName()
            + "\nAUTHOR: " + b.getAuthor() + "\nEDITORIAL: " + b.getEditorial()
            + "\nYEAR OF PUBLICATION: " + b.getYear()+ "\nCATEGORY: " + b.getCategory()+ "\nCANTIDAD EXISTENTES: " + b.getCantidadE() +   "\n\n");
        }
        leer.close();
    }

    public void NumberBooks(String rutaArchivo) throws FileNotFoundException, IOException {
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
    
        String linea = null;
        Books b;
         FileReader fichero = new FileReader(rutaArchivo);
        BufferedReader leer = new BufferedReader(fichero);
        while((linea = leer.readLine())!= null){
            StringTokenizer campo = new StringTokenizer(linea, "--");
            String cd = campo.nextToken().trim();
            String nam = campo.nextToken().trim();
            String aut = campo.nextToken().trim();
            String edt = campo.nextToken().trim();
            String yp = campo.nextToken().trim();
            String ctg = campo.nextToken().trim();
         
            
            b = new Books();
            b.setCode(Integer.parseInt(cd));
            b.setName(nam);
            b.setAuthor(aut);
            b.setEditorial(edt);
            b.setYear(Integer.parseInt(yp));
            b.setCategory(ctg);
          
            
            if(b.getCategory().equalsIgnoreCase("HISTORIA")){
                counter1++;
            }
            else if(b.getCategory().equalsIgnoreCase("ARTE")){
                counter2++;
            }
            else if(b.getCategory().equalsIgnoreCase("TECNOLOGIA")){
                counter3++;
            }
            else if(b.getCategory().equalsIgnoreCase("ENTRETENIMIENTO")){
                counter4++;
            }
           
           
        }       
        JOptionPane.showMessageDialog(null, "======= NUMBER OF BOOKS ======= \n \n"
                + "HISTORIA: " + counter1 + "\n"
                + "ARTE: " + counter2 + "\n"
                + "TECNOLOGIA: " + counter3 + "\n"
                + "ENTRETENIMIENTO: " + counter4);
    }
        
   public String InformeCategoria() throws FileNotFoundException, IOException {
        Books bo = null; 
        String linea; 
        String htr=""; 
        String art="";
        String tec="";
        String etn="";  
        FileReader fichero = new FileReader(getRouteRecords());
        BufferedReader leer = new BufferedReader(fichero);
        while ((linea = leer.readLine()) != null) {
            StringTokenizer campo = new StringTokenizer(linea, "--");
            String cd = campo.nextToken().trim();
            String nam=campo.nextToken().trim();
            String aut = campo.nextToken().trim();
            String edt = campo.nextToken().trim();
            String yp = campo.nextToken().trim();
            String ctg = campo.nextToken().trim();

            
            bo = new Books();
            bo.setCode(Integer.parseInt(cd));
            bo.setName(nam);
            bo.setAuthor(aut);
            bo.setEditorial(edt);
            bo.setYear(Integer.parseInt(yp));
            bo.setCategory(ctg);
        
   
               if (bo.getCategory().equalsIgnoreCase("HISTORIA")) { 
                htr+="\n"+"--"+nam; 
            } else if (bo.getCategory().equalsIgnoreCase("ARTE")) { 
                art+="\n"+"--"+nam; 
            } else if (bo.getCategory().equalsIgnoreCase("TECNOLOGIA")) { 
                tec+="\n"+"--"+nam; 
            } else if (bo.getCategory().equalsIgnoreCase("ENTRETENIMIENTO")) { 
               etn+="\n"+"--"+nam; 
            }
               
        }
      
           return htr + "\n"+ art + "\n"+ tec + "\n"+ etn;         
    }
}
