/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acq;

/**
 *
 * @author Zuzu
 */
public enum InquiryFrom {
    INDIVIDUAL("individual"), RELATIVES("relatives"), DOCTOR("doctor"), OTHER("other");
    
    private String inquiryString; 

    InquiryFrom(String inquiryString) { 
        this.inquiryString = inquiryString; 
    }

    /**
     *
     * @return inquiry string
     */
    @Override
    public String toString() {
        return inquiryString;
    }
}