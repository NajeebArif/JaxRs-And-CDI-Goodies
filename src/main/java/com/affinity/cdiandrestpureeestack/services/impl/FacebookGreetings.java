/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.affinity.cdiandrestpureeestack.services.impl;

import com.affinity.cdiandrestpureeestack.qualifiers.GreetingsFrom;
import com.affinity.cdiandrestpureeestack.qualifiers.RandomGreeter;
import com.affinity.cdiandrestpureeestack.qualifiers.enums.Greeter;
import com.affinity.cdiandrestpureeestack.services.Greetings;

/**
 *
 * @author Najeeb
 */
@GreetingsFrom(greeter = Greeter.FACEBOOK)
public class FacebookGreetings implements Greetings{

    @Override
    public String greetTheUser(String userName) {
        return "Hey "+userName+"!!! Facebook's Team welcomes you!! Do have a nice stay..";
    }
    
}
