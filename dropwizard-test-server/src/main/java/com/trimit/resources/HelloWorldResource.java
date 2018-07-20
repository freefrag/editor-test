/*
 * (c) Copyright 2018 Trimit All rights reserved.
 */

package com.trimit.resources;

import com.trimit.api.HelloWorldService;
import javax.inject.Inject;

public class HelloWorldResource implements HelloWorldService {

    @Inject
    public HelloWorldResource() {

    }

    @Override
    public final String helloWorld() {
        return "HelloWorld";
    }
}
