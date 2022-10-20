package com.artech.workerslogin.database.storage;

import com.artech.workerslogin.core.manager.IWorkerManager;
import com.artech.workerslogin.core.query.DatabaseHandle;
import com.artech.workerslogin.core.storage.IStorage;
import com.artech.workerslogin.database.manager.WorkerManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbStorage implements IStorage {

    private final WorkerManager workerManager;

    /**
     * Конструктор хранилиза на основе БД
     * @param handle Дескриптор БД
     */
    public DbStorage(DatabaseHandle handle) throws SQLException {

        this.workerManager = new WorkerManager(handle);
    }

    @Override
    public IWorkerManager workerManager() {
        return this.workerManager;
    }
}
