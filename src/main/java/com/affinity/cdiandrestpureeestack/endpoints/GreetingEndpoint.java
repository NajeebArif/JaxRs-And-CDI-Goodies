/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.affinity.cdiandrestpureeestack.endpoints;

import com.affinity.cdiandrestpureeestack.events.GreetingsEventType;
import com.affinity.cdiandrestpureeestack.qualifiers.GreetingsFrom;
import com.affinity.cdiandrestpureeestack.qualifiers.RandomGreeter;
import com.affinity.cdiandrestpureeestack.qualifiers.enums.Greeter;
import com.affinity.cdiandrestpureeestack.services.Greetings;
import java.time.LocalDateTime;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Najeeb
 */
@Path("greetings")
@RequestScoped
public class GreetingEndpoint {
    
    @Inject
    @GreetingsFrom(greeter = Greeter.TWITTER)
    private Greetings greetings;
    
    @Inject
    @RandomGreeter
    private Greetings randomGreetings;
    
    @Inject
    Event<GreetingsEventType> greetingsEvent;
    
    @GET
    public String greetTheUser(@QueryParam("username") @DefaultValue("anonymous") String username){
        String msg = greetings.greetTheUser(username);;
        return msg;
    }
    
    @GET
    @Path("random")
    public String getRandomGreetings(@QueryParam("username") @DefaultValue("anonymous") String username){
        String msg = randomGreetings.greetTheUser(username);
        GreetingsEventType evt = new GreetingsEventType();
//        evt.setGreeter(randomGreetings.getClass().getAnnotationsByType(GreetingsFrom.class));
        evt.setGreetingMessage(msg);
        evt.setGreetingsTime(LocalDateTime.now());
        greetingsEvent.fire(evt);
        return msg;
    }
    
}
