
package com.cxf.server.service;

import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public interface HelloService {

    @GET
    @Path("/{a}")
    String sayHello(@PathParam("a") String a);

}
