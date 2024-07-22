package com.google.firebase.storage.internal;

public class SleeperImpl implements Sleeper {
    public void sleep(int milliseconds) throws InterruptedException {
        Thread.sleep((long) milliseconds);
    }
}
