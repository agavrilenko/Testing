package org.my.boot.client.service;

import javax.ws.rs.*;

/**
 * Created by trash on 27-Dec-16.
 */
//@Component

@Path("/users/")
public interface RestService {

    @GET
    @Path("/get/{id}")
    public void getSomething(@PathParam("id") String id) ;

    @POST
    @Path("/get/{id}")
    public String getSomething(@PathParam("id") String id, @FormParam("json") String json) ;

    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Path("/do")
    public void doSomething(@FormParam("data") String json) ;
}
