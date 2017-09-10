/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.affinity.cdiandrestpureeestack.services.producers;

import com.affinity.cdiandrestpureeestack.qualifiers.RandomGreeter;
import com.affinity.cdiandrestpureeestack.services.Greetings;
import com.affinity.cdiandrestpureeestack.services.impl.DefaultGreetings;
import com.affinity.cdiandrestpureeestack.services.impl.FacebookGreetings;
import com.affinity.cdiandrestpureeestack.services.impl.TwitterGreetings;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Najeeb
 */
@SessionScoped
public class GreetingsProducer implements Serializable{
    
    private int count = 0;
    
    @Produces
    @RandomGreeter
    public Greetings getTheGreetings(@New FacebookGreetings fb, @New TwitterGreetings tw, @New DefaultGreetings df){
        if(count == 0){
            count++;
            return df;
        }else if(count%2==0){
            count++;
            return fb;
        }else{
            count++;
            return tw;
        }
    }
    
}
