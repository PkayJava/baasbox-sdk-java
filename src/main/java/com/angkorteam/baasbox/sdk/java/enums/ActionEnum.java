package com.angkorteam.baasbox.sdk.java.enums;

/**
 * Created by socheatkhauv on 1/22/16.
 */
public enum ActionEnum {
    Read("read"),
    Update("update"),
    Delete("delete"),
    All("all");

    private final String literal;

    ActionEnum(String literal) {
        this.literal = literal;
    }

    public final String getLiteral() {
        return literal;
    }
}
