/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fulviotarable;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 * Classe che descrive la struttura di un Libro della Libreria
 *
 * @author Fulvio
 */
public class Libro implements Serializable {
// Variabili di istanza

    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";

    private String titoloLibro;
    private String autoreLibro;
    private String annoLibro;

    private PropertyChangeSupport propertySupport;

// Costruttore di Default    
    public Libro() {
        propertySupport = new PropertyChangeSupport(this);
    }
// Costruttore a 3 argomenti    

    public Libro(String titoloLibro, String autoreLibro, String annoLibro) {
        this.titoloLibro = titoloLibro;
        this.autoreLibro = autoreLibro;
        this.annoLibro = annoLibro;
    }
// Metodi getter    

    public String getTitoloLibro() {
        return titoloLibro;
    }

    public String getAutoreLibro() {
        return autoreLibro;
    }

    public String getAnnoLibro() {
        return annoLibro;
    }

// Metodi setter    
    public String setTitoloLibro(String titoloLibro) {
        this.titoloLibro = titoloLibro;
        return titoloLibro;
    }

    public String setAutoreLibro(String autoreLibro) {
        this.autoreLibro = autoreLibro;
        return autoreLibro;
    }

    public String setAnnoLibro(String annoLibro) {
        this.annoLibro = annoLibro;
        return annoLibro;
    }

// Metodi Listener del JavaBean Libro    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
}