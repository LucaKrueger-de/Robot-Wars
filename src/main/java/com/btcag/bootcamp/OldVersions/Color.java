package com.btcag.bootcamp.OldVersions;

public enum Color {
    RED("\u001b[31;1m1"),
    GREEN("\u001b[32;1m2"),
    YELLOW("\u001b[33;1m3"),
    BLUE("\u001b[34;1m4"),
    MAGENTA("\u001b[35;1m5"),
    STOP("\u001b[0m");

    private final String value;

    Color(String value) {
        this.value = value;
    }
}
