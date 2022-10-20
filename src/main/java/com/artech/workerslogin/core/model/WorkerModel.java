package com.artech.workerslogin.core.model;

import java.util.Date;

public record WorkerModel(Integer id, String dbId, String speciality, String name, String login, String password, Date lastAuth, String authStatus) implements IModel {
}
