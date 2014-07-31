package com.cloud.agent.api;

public class MigrateVmwareWithStorageAnswer extends Answer {
    protected MigrateVmwareWithStorageAnswer() {
    }

    public MigrateVmwareWithStorageAnswer(MigrateVmwareWithStorageCommand cmd, boolean result, String detail) {
        super(cmd, result, detail);
    }

}
