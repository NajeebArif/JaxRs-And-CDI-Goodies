/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.affinity.cdiandrestpureeestack.qualifiers.enums;

/**
 *
 * @author Najeeb
 */
public enum Greeter {
    
    FACEBOOK("Facebook"),
    TWITTER("Twitter");
    
    private String greeterName;
    
    Greeter(String greeterName){
        this.greeterName = greeterName;
    }

    public String getGreeterName() {
        return greeterName;
    }
    
}
