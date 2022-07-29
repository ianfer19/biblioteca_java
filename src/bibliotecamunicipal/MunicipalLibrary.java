/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecamunicipal;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Iam Fernandez
 */
public class MunicipalLibrary {
    public static int menu(){
        int opcion = 0;
        
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog("=============== MENÚ DE OPCIONES ===============\n\n"
            + "1. REGISTRAR UN LIBRO \n" 
            + "2. MOSTRAR INFORMACIÓN DE LOS LIBROS \n"
            + "3. PRESTAR UN LIBRO \n" 
            + "4. CANTIDAD DE LIBROS POR CATEGORÍA \n" 
            + "5. MOSTRAR HISTORIAL DE PRÉSTAMO \n"
            + "6. REGISTROS \n"
            + "7. ELIMINAR UNA PERSONA DE LA COLA DE TURNOS \n"
            + "8. BORRAR TODOS LOS TURNOS \n"
            + "9. SALIR \n\n"));
        }
        while(opcion <= 0 || opcion > 9);
        return opcion;
    }
    
    public static void GuardarUsuario(User us){
        int cod_l = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ISBN del libro que quiere prestar: "));
        us.setBookCode(cod_l);    
        String nom_u = JOptionPane.showInputDialog("Escriba su NOMBRE de usuario: ");
        us.setUserName(nom_u);     
        int id_u = Integer.parseInt(JOptionPane.showInputDialog("Digite su IDENTIFICACION de usuario: "));
        us.setUserIdentification(id_u);             
        String fecha = JOptionPane.showInputDialog("Digite la FECHA de hoy en formato (dd/mm/aa): ");
        us.setDate(fecha);
    }

    public static void Guardar(Books b){
        int Isbn = Integer.parseInt(JOptionPane.showInputDialog("INGRESE EL ISBN DEL LIBRO: "));
        b.setCode(Isbn);
        String nom = JOptionPane.showInputDialog("ESCRIBA EL NOMBRE DEL LIBRO: ");
        b.setName(nom);
        String aut = JOptionPane.showInputDialog("ESCRIBA EL NOMBRE DEL AUTOR: ");
        b.setAuthor(aut);
        String edit = JOptionPane.showInputDialog("ESCRIBA LA EDITORIAL DEL LIBRO: ");
        b.setEditorial(edit);
        int añopub = Integer.parseInt(JOptionPane.showInputDialog("INGRESE EL AÑO DE PUBLICACIÓN: "));
        b.setYear(añopub);
        
        
        int catg;
        do{
            catg = Integer.parseInt(JOptionPane.showInputDialog("ELIJA LA CATEGORÍA DEL LIBRO: \n\n"
            + "1. HISTORIA \n" + "2. ARTE \n" + "3. TECNOLOGÍA \n" + "4. ENTRETENIMIENTO \n\n"));
            
            switch(catg){
                case 1:
                    b.setCategory("HISTORIA");
                    break;
                case 2:
                    b.setCategory("ARTE");
                    break;
                case 3:
                  b.setCategory("TECNOLOGÍA");
                    break;
                case 4:
                    b.setCategory("ENTRETENIMIENTO");
                    break;
            }
        }
        while(catg < 1 || catg > 4);
    }
    
    public static void informeArchivo(ArchiveBooks arch){
 File inf = new File(arch.getRouteRecords());
 JOptionPane.showMessageDialog(null,"====== INFORMACÓN DEL ARCHIVO ======"+"\n"+"\n Ubicación: "+
 inf.getAbsolutePath()+"\n Tamaño: "+ inf.length()); 
     }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
          int opcion; 
        ArchiveBooks arch = new ArchiveBooks();
        ArchiveRecords archt = new ArchiveRecords();
        Books b = null;
        User us = null;
        arch.setRouteRecords("DatosLibros.txt");
        archt.setRoutaArchive("HistorialPrestamos.txt");
        do{
            opcion = menu();
            switch(opcion){
                case 1:
                    b = new Books();
                    Guardar(b);
                    arch.GuardarArchivo(b);
                    break;
                    case 2:
                    arch.LeerArchivos(arch.getRouteRecords());
                    break;
                case 3:
                    us = new User();
                    GuardarUsuario(us);
                    archt.guardarArchivo(us);
                    break;
                    case 4:
                    arch.NumberBooks(arch.getRouteRecords());
                   
                    break;
                case 5:
                    archt.leerArchivoDos(archt.getRoutaArchive());
             

                    break; 
                case 6:
                    
  JOptionPane.showMessageDialog(null,"====== NOMBRES DEL ARCHIVO ======"+"\n"+"\n"+"Se han registrado: "+ "\n" +arch.InformeCategoria());
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
            }
        }
        while(opcion != 9);
        System.exit(0);
       

    }

    
}
   
