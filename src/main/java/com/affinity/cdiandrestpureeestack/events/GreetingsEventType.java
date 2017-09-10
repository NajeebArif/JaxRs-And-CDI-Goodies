/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.affinity.cdiandrestpureeestack.events;

import com.affinity.cdiandrestpureeestack.qualifiers.enums.Greeter;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Najeeb
 */
public class GreetingsEventType {
    
    private String greetingMessage;
    private Greeter greeter;
    private LocalDateTime greetingsTime;

    public GreetingsEventType() {
    }

    public String getGreetingMessage() {
        return greetingMessage;
    }

    public void setGreetingMessage(String greetingMessage) {
        this.greetingMessage = greetingMessage;
    }

    public Greeter getGreeter() {
        return greeter;
    }

    public void setGreeter(Greeter greeter) {
        this.greeter = greeter;
    }

    public LocalDateTime getGreetingsTime() {
        return greetingsTime;
    }

    public void setGreetingsTime(LocalDateTime greetingsTime) {
        this.greetingsTime = greetingsTime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.greetingMessage);
        hash = 31 * hash + Objects.hashCode(this.greeter);
        hash = 31 * hash + Objects.hashCode(this.greetingsTime);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GreetingsEventType other = (GreetingsEventType) obj;
        if (!Objects.equals(this.greetingMessage, other.greetingMessage)) {
            return false;
        }
        if (this.greeter != other.greeter) {
            return false;
        }
        if (!Objects.equals(this.greetingsTime, other.greetingsTime)) {
            return false;
        }
        return true;
    }
    
    
}
