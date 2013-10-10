package com.jeff;


/**
 * @since 10/9/13 5:25 PM
 */
public class DefaultHelloManager implements HelloManager {

    private String greeting;

    @Override
    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
