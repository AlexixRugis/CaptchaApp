package com.artech.workerslogin.database.manager;

import com.artech.workerslogin.core.manager.ILoginManager;
import com.artech.workerslogin.core.model.WorkerModel;

public class LoginManager implements ILoginManager {
    private WorkerModel model;
    private int loginAttemptsCount;

    @Override
    public WorkerModel getCurrentAccount() {
        return this.model;
    }

    @Override
    public void setCurrentAccount(WorkerModel model) {
        this.model = model;
    }

    @Override
    public int getLoginAttemptsCount() {
        return this.loginAttemptsCount;
    }

    @Override
    public void setLoginAttemptsCount(int c) {
        this.loginAttemptsCount = Math.max(c, 0);
    }
}
