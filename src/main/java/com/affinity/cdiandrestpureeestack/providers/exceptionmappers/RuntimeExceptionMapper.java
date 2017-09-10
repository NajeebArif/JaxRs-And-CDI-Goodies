/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.affinity.cdiandrestpureeestack.providers.exceptionmappers;

import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Najeeb
 */
@Provider
public class  RuntimeExceptionMapper implements ExceptionMapper<RuntimeException>{

    private static final Logger LOG = Logger.getLogger(RuntimeExceptionMapper.class.getName());
    
    @Override
    public Response toResponse(RuntimeException exception) {
        String message ="a RuntimeException happened: "+exception.getClass().getSimpleName()+" at " +exception.getStackTrace()[0].toString();
        LOG.severe(message);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(message).build();
    }
    
}
