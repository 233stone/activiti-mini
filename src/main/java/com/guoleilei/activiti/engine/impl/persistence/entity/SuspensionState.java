package com.guoleilei.activiti.engine.impl.persistence.entity;

public interface SuspensionState {

    SuspensionState ACTIVE = new SuspensionStateImpl(1, "active");
    SuspensionState SUSPENDED = new SuspensionStateImpl(2, "suspended");



    int getStateCode();

    // default implementation ///////////////////////////////////////////////////

    static class SuspensionStateImpl implements SuspensionState {

        public final int stateCode;
        protected final String name;

        public SuspensionStateImpl(int suspensionCode, String string) {
            this.stateCode = suspensionCode;
            this.name = string;
        }

        public int getStateCode() {
            return stateCode;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + stateCode;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            SuspensionStateImpl other = (SuspensionStateImpl) obj;
            if (stateCode != other.stateCode)
                return false;
            return true;
        }

        @Override
        public String toString() {
            return name;
        }
    }

}
