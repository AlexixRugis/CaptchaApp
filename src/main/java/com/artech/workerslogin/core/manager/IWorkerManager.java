package com.artech.workerslogin.core.manager;

import com.artech.workerslogin.core.model.WorkerModel;

public interface IWorkerManager extends ICRUDObjectManager<WorkerModel> {
    WorkerModel getWorker(String login, String password);
}
