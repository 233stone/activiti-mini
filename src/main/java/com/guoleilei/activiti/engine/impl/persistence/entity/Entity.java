package com.guoleilei.activiti.engine.impl.persistence.entity;

public interface Entity {

    String getId();

    void setId(String id);

    boolean isInserted();

    void setInserted(boolean inserted);

    boolean isUpdated();

    void setUpdated(boolean updated);

    boolean isDeleted();

    void setDeleted(boolean deleted);

    /**
     * Returns a representation of the object, as would be stored in the database.
     * Used when deciding if updates have occurred to the object or not since it was last loaded.
     */
    Object getPersistentState();
}

