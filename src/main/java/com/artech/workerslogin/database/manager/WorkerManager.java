package com.artech.workerslogin.database.manager;

import com.artech.workerslogin.core.manager.IWorkerManager;
import com.artech.workerslogin.core.model.WorkerModel;
import com.artech.workerslogin.core.query.DatabaseHandle;

import java.io.InvalidObjectException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkerManager extends DbObjectManager<WorkerModel> implements IWorkerManager {
    /**
     * Конструктор менеджера
     *
     * @param handle    Дескриптор БД
     */
    public WorkerManager(DatabaseHandle handle) throws SQLException {
        super(handle, "workers");
    }

    @Override
    public boolean tryCreate(WorkerModel prototype) {
        return false;
    }

    @Override
    public boolean tryUpdate(WorkerModel model) {
        try {
            PreparedStatement statement = handle.buildStatement("UPDATE workers SET ID = ?, Speciality = ?, Name = ?, Login = ?, Password = ?, LastAuth = ?, AuthStatus = ? WHERE PK = ?");
            statement.setString(1, model.dbId());
            statement.setString(2, model.speciality());
            statement.setString(3, model.name());
            statement.setString(4, model.login());
            statement.setString(5, model.password());
            statement.setDate(6, new Date(model.lastAuth().getTime()));
            statement.setString(7, model.authStatus());
            statement.setInt(8, model.id());
            statement.executeUpdate();
            statement.close();

            handleUpdate();
            return true;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        return false;
    }

    @Override
    protected void tryCreateTable() {
    }

    @Override
    protected WorkerModel build(ResultSet result) {
        try {
            return new WorkerModel(
                    result.getInt("PK"),
                    result.getString("ID"),
                    result.getString("Speciality"),
                    result.getString("Name"),
                    result.getString("Login"),
                    result.getString("Password"),
                    result.getDate("LastAuth"),
                    result.getString("AuthStatus")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WorkerModel getWorker(String login, String password) {
        try {
            PreparedStatement statement = handle.buildStatement("SELECT * FROM workers WHERE Login = ? AND Password = ? LIMIT 1");
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            WorkerModel model = null;
            if (result.next())
                 model = build(result);

            statement.close();

            return model;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
