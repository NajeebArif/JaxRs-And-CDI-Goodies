/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.affinity.cdiandrestpureeestack.endpoints;

import com.affinity.cdiandrestpureeestack.events.GreetingsEventType;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import org.glassfish.jersey.server.ManagedAsync;

/**
 *
 * @author Najeeb
 */
@Path("async")
@Stateless
public class AsyncResource {

    public AsyncResource() {
    }
    
    private GreetingsEventType evt;
    public void getTheEvent(@Observes GreetingsEventType evt){
        this.evt = evt;
    }

    public GreetingsEventType getEvt() {
        return evt;
    }
    
    @GET
    public void getAsyncResponse(@Suspended final AsyncResponse asyncResponse){
        new Thread(()->{
//            while(getEvt()==null){
//                sleep(1000);
//            }
//            if(evt!=null){
//                String msg = evt.getGreetingMessage()+" CREATION TIME: "+evt.getGreetingsTime().toString();
//                asyncResponse.resume(msg);
//            }
            asyncResponse.resume("Hello World");
        }).start();
    }

    private void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException ex) {
            Logger.getLogger(AsyncResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
