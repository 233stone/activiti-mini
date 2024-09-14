package com.guoleilei.activiti.engine.impl.persistence.entity;

/**
 * Abstract superclass for the common properties of all {@link Entity} implementations.
 */
public abstract class AbstractEntity implements Entity {

    protected String id;
    protected int revision = 1;

    protected boolean isInserted;
    protected boolean isUpdated;
    protected boolean isDeleted;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public int getRevisionNext() {
        return revision + 1;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public boolean isInserted() {
        return isInserted;
    }

    public void setInserted(boolean isInserted) {
        this.isInserted = isInserted;
    }

    public boolean isUpdated() {
        return isUpdated;
    }

    public void setUpdated(boolean isUpdated) {
        this.isUpdated = isUpdated;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}
