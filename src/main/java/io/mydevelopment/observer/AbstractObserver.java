package io.mydevelopment.observer;

import io.mydevelopment.Subject;
import io.mydevelopment.enums.Race;

public abstract class AbstractObserver implements MyObserver {
    protected Subject subject;

    public AbstractObserver() {
    }

    public AbstractObserver(Subject subject) {
        this.subject = subject;
    }
}
