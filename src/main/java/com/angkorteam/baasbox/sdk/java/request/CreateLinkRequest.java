package com.angkorteam.baasbox.sdk.java.request;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 1/19/16.
 */
public class CreateLinkRequest implements Serializable {

    private String sourceId;

    private String label;

    private String destinationId;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }
}
