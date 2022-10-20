package com.artech.workerslogin.config;

import com.artech.workerslogin.core.ISettings;

public final class Settings implements ISettings {

    private final String databasePath;
    private final String databaseUser;
    private final String databasePassword;

    public Settings(String databasePath, String databaseUser, String databasePassword) {
        this.databasePath = databasePath;
        this.databaseUser = databaseUser;
        this.databasePassword = databasePassword;
    }

    @Override
    public String getDatabasePath() {
        return this.databasePath;
    }

    @Override
    public String getDatabaseUsername() {
        return this.databaseUser;
    }

    @Override
    public String getDatabasePassword() {
        return this.databasePassword;
    }
}
