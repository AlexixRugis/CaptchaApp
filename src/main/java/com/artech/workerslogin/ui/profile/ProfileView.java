package com.artech.workerslogin.ui.profile;

import com.artech.workerslogin.WorkersApplication;
import com.artech.workerslogin.core.storage.IStorage;
import com.artech.workerslogin.ui.controllers.Controller;
import com.artech.workerslogin.ui.views.FXMLView;

import java.net.URL;

public class ProfileView extends FXMLView {

    private final IStorage storage;

    public ProfileView(IStorage storage) {

        this.storage = storage;
    }

    @Override
    protected URL getFXMLResourceURL() {
        return WorkersApplication.class.getResource("profile-view.fxml");
    }

    @Override
    protected Controller getController() {
        return new ProfileController(this.storage);
    }

    @Override
    public String getName() {
        return "Профиль";
    }
}
