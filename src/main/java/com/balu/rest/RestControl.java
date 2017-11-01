package com.balu.rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.balu.amq.Sender;
import com.balu.data.Greeting;

@RestController
public class RestControl {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    //@Autowired 
    //private Sender outQ;
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    		//outQ.sendToQ(name);
    		System.out.println("Inside greeting of rest method");
    		return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}