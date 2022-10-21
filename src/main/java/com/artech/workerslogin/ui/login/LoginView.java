package com.artech.workerslogin.ui.login;

import com.artech.workerslogin.WorkersApplication;
import com.artech.workerslogin.core.storage.IStorage;
import com.artech.workerslogin.ui.controllers.Controller;
import com.artech.workerslogin.ui.views.FXMLView;

import java.net.URL;

public class LoginView extends FXMLView {

    private final IStorage storage;

    public LoginView(IStorage storage) {
        this.storage = storage;
    }

    @Override
    protected URL getFXMLResourceURL() {
        return WorkersApplication.class.getResource("login-view.fxml");
    }

    @Override
    protected Controller getController() {
        return new LoginController(this.storage);
    }

    @Override
    public String getName() {
        return "Вход";
    }
}
