package com.xebia.training.refactor.legacy;
public class SecurityContext {

    public static User getLoggedInUser(){
        throw new IllegalStateException("Please don't call methods create a dependent class");
    }
}