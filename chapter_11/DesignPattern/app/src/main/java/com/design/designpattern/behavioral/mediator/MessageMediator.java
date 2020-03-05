package com.design.designpattern.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体中介者
 */
public class MessageMediator extends Mediator {
    private List<Colleague> colleagues = new ArrayList<Colleague>();

    @Override
    public void register(Colleague colleague) {
        if (!colleagues.contains(colleague)) {
            colleagues.add(colleague);
            colleague.setMediator(this);
        }
    }

    @Override
    public void relay(Colleague cl, String message) {
        for (Colleague ob : colleagues) {
            if (!ob.equals(cl)) {
                ((Colleague) ob).receive(message);
            }
        }
    }
}
