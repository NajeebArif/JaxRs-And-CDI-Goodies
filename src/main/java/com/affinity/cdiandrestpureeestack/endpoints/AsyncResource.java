/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.affinity.cdiandrestpureeestack.endpoints;

import com.affinity.cdiandrestpureeestack.events.GreetingsEventType;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

/**
 *
 * @author Najeeb
 */
@Path("async")
@RequestScoped
public class AsyncResource {
    
    @Resource
    private ManagedExecutorService executorService;

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
        
        asyncResponse.setTimeoutHandler(ar->{
            
            ar.resume(Response.status(Response.Status.GATEWAY_TIMEOUT).build());
        });
        
        asyncResponse.setTimeout(10, TimeUnit.SECONDS);
        
        executorService.submit(()->{
            while(getEvt()==null){
                sleep(1000);
            }
            if(evt!=null){
                String msg = evt.getGreetingMessage()+" CREATION TIME: "+evt.getGreetingsTime().toString();
                asyncResponse.resume(msg);
            }
        });
        
    }

    private void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException ex) {
            Logger.getLogger(AsyncResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
