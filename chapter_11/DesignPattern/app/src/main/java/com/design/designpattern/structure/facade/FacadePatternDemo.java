package com.design.designpattern.structure.facade;

public class FacadePatternDemo {
    public static void main(String[] args) {
        CarFacade carFacade = new CarFacade();
        carFacade.audiRun();
        carFacade.benzRun();
    }
}
