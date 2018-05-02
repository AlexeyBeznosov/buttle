package io.mydevelopment;

import io.mydevelopment.observer.MyObserver;

public interface Subject {
    void add(MyObserver observer);
    void remove(MyObserver observer);
}
