package com.smahjoub.metic;

public enum State {
    NotReady("NotReady"),
    Ready("Ready"),
    Playing("Playing"),
    Finished("Finished");

    private final String name;

    State(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
