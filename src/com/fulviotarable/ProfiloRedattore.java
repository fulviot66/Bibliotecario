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
 * Classe che descrive la struttura del file Elenco-Libri.txt
 * @author Fulvio
 */
    public class ProfiloRedattore implements Serializable {
// Variabili di Istanza    

        private char inizioAutore;
        private char fineAutore;
        private char inizioTitolo;
        private char fineTitolo;
        private char inizioAnno;
        private char fineAnno;
        private String regexTrovaTitolo;
        private String regexTrovaAnno;

        public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
        private String sampleProperty;
        private PropertyChangeSupport propertySupport;

// Costruttore di Default    
        public ProfiloRedattore() {
            propertySupport = new PropertyChangeSupport(this);
        }
// Costruttore con tutti gli argomenti    

        public ProfiloRedattore(char inizioAutore, char fineAutore,
                char inizioTitolo, char fineTitolo,
                char inizioAnno, char fineAnno) {
            this.inizioAutore = inizioAutore;
            this.fineAutore = fineAutore;
            this.inizioTitolo = inizioTitolo;
            this.fineTitolo = fineTitolo;
            this.inizioAnno = inizioAnno;
            this.fineAnno = fineAnno;
        }
// Metodi Getter    

        public char getInizioAutore() {
            return inizioAutore;
        }

        public char getFineAutore() {
            return fineAutore;
        }

        public char getInizioTitolo() {
            return inizioTitolo;
        }

        public char getFineTitolo() {
            return fineTitolo;
        }

        public char getInizioAnno() {
            return inizioAnno;
        }

        public char getFineAnno() {
            return fineAnno;
        }

        public String getRegexTrovaTitolo() {
            return regexTrovaTitolo;
        }

        public String getRegexTrovaAnno() {
            return regexTrovaAnno;
        }

        public String getSampleProperty() {
            return sampleProperty;
        }
// Metodi Setter    

        public char setInizioAutore(char inizioAutore) {
            this.inizioAutore = inizioAutore;
            return inizioAutore;
        }

        public char setFineAutore(char fineAutore) {
            this.fineAutore = fineAutore;
            return fineAutore;
        }

        public char setInizioTitolo(char inizioTitolo) {
            this.inizioTitolo = inizioTitolo;
            return inizioTitolo;
        }

        public char setFineTitolo(char fineTitolo) {
            this.fineTitolo = fineTitolo;
            return fineTitolo;
        }

        public char setInizioAnno(char inizioAnno) {
            this.inizioAnno = inizioAnno;
            return inizioAnno;
        }

        public char setFineAnno(char fineAnno) {
            this.fineAnno = fineAnno;
            return fineAnno;
        }

        public String setRegexTrovaTitolo(String regexTrovaTitolo) {
            this.regexTrovaTitolo = regexTrovaTitolo;
            return regexTrovaTitolo;
        }

        public String setRegexTrovaAnno(String regexTrovaAnno) {
            this.regexTrovaAnno = regexTrovaAnno;
            return regexTrovaAnno;
        }

        public void setSampleProperty(String value) {
            String oldValue = sampleProperty;
            sampleProperty = value;
            propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, sampleProperty);
        }
// Metodi Listener    

        public void addPropertyChangeListener(PropertyChangeListener listener) {
            propertySupport.addPropertyChangeListener(listener);
        }

        public void removePropertyChangeListener(PropertyChangeListener listener) {
            propertySupport.removePropertyChangeListener(listener);
        }
    }
