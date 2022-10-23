package com.artech.workerslogin.core.manager;

import com.artech.workerslogin.core.model.WorkerModel;

public interface ILoginManager {
    WorkerModel getCurrentAccount();
    void setCurrentAccount(WorkerModel model);

    int getLoginAttemptsCount();
    void setLoginAttemptsCount(int c);
}
