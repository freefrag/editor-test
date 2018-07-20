/*
 * (c) Copyright 2018 Trimit All rights reserved.
 */

package com.trimit.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")

public interface HelloWorldService {
    @GET
    @Path("world")
    @Produces(MediaType.APPLICATION_JSON)
    String helloWorld();
}
