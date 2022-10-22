package com.artech.workerslogin.core.manager;

import com.artech.workerslogin.core.model.WorkerModel;
import com.artech.workerslogin.database.manager.WorkerManager;

public interface IWorkerManager extends IObjectManager<WorkerModel> {
    WorkerModel getWorker(String login, String password);
}
