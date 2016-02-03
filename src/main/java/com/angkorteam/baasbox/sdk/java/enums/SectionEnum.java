package com.angkorteam.baasbox.sdk.java.enums;

/**
 * Created by socheatkhauv on 1/22/16.
 */
public enum SectionEnum {

    PasswordRecovery("PasswordRecovery"),
    Application("Application"),
    Push("Push"),
    Image("Image");

    private final String literal;

    SectionEnum(String literal) {
        this.literal = literal;
    }

    public final String getLiteral() {
        return literal;
    }
}
