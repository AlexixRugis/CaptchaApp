package com.artech.workerslogin.database.storage;

import com.artech.workerslogin.core.manager.ILoginManager;
import com.artech.workerslogin.core.manager.IWorkerManager;
import com.artech.workerslogin.core.query.DatabaseHandle;
import com.artech.workerslogin.core.storage.IStorage;
import com.artech.workerslogin.database.manager.LoginManager;
import com.artech.workerslogin.database.manager.WorkerManager;

import java.sql.SQLException;

public class ApplicationStorage implements IStorage {

    private final LoginManager loginManager;
    private final WorkerManager workerManager;

    /**
     * Конструктор хранилиза на основе БД
     * @param handle Дескриптор БД
     */
    public ApplicationStorage(DatabaseHandle handle) throws SQLException {
        this.loginManager = new LoginManager();
        this.workerManager = new WorkerManager(handle);
    }

    @Override
    public ILoginManager loginManager() {
        return this.loginManager;
    }

    @Override
    public IWorkerManager workerManager() {
        return this.workerManager;
    }
}
