package com.artech.workerslogin.core.storage;

import com.artech.workerslogin.core.manager.ILoginManager;
import com.artech.workerslogin.core.manager.IWorkerManager;

public interface IStorage {
    ILoginManager loginManager();
    IWorkerManager workerManager();
}
