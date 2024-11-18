package com.mycompany.xml_evaluable.model;

import java.util.Date;


public class RSS {
    private String titulo;
    private Date fecha;
    private String Autor;
    private String URL;

    

    public RSS() {
    }



    public RSS(String titulo, Date fecha, String autor, String uRL) {
        this.titulo = titulo;
        this.fecha = fecha;
        Autor = autor;
        URL = uRL;
    }



    public String getTitulo() {
        return titulo;
    }



    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }



    public Date getFecha() {
        return fecha;
    }



    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }



    public String getAutor() {
        return Autor;
    }



    public void setAutor(String autor) {
        Autor = autor;
    }



    public String getURL() {
        return URL;
    }



    public void setURL(String uRL) {
        URL = uRL;
    }



    @Override
    public String toString() {
        return "RSS [titulo=" + titulo + "\n fecha=" + fecha + "\nAutor=" + Autor + "\n URL=" + URL + "]";
    }

    

    
}
