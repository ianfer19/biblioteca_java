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
public class Books {
    private int code;
    private String name;
    private String author;
    private String editorial;
    private int yearp;
    private String category;
    private int cantidadejmplr;
    
    public void Books(){
        code =0;
        name="";
        author="";
        editorial="";
        yearp=0;
        category="";
        cantidadejmplr=0;
    }
    
    public void setCode(int cd){
      code=cd;  
    }
    public void setName( String nam){
        name=nam;
    }
    public void setAuthor(String aut){
        author=aut;
    }
    public void setEditorial(String edt){
        editorial=edt;
    }
    public void setYear(int yp){
        yearp=yp;
    }
    public void setCategory(String ctg){
        category=ctg;
    }
    public void setCantidadE(int cdjmp){
        cantidadejmplr= cdjmp;
    }
    
    public int getCode(){
        return code;
    }
    public String getName(){
        return name;
    }
    public String getAuthor(){
        return author;
    }
    public String getEditorial(){
        return editorial;
    }
    public int getYear(){
        return yearp;
    }
    public String getCategory(){
        return category;
    }
    public int getCantidadE(){
        return cantidadejmplr;
    }
}
