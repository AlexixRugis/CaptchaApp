package com.artech.workerslogin.ui.captcha;

import com.artech.workerslogin.WorkersApplication;
import com.artech.workerslogin.core.storage.IStorage;
import com.artech.workerslogin.ui.controllers.Controller;
import com.artech.workerslogin.ui.views.FXMLView;

import java.net.URL;

public class CaptchaView extends FXMLView {
    private final IStorage storage;
    private final CaptchaController controller;

    public CaptchaView(IStorage storage) {
        this.storage = storage;
        this.controller = new CaptchaController(this.storage);
    }

    public boolean validate() {
        return this.controller.validate();
    }

    @Override
    protected URL getFXMLResourceURL() {
        return WorkersApplication.class.getResource("captcha-view.fxml");
    }

    @Override
    protected Controller getController() {
        return this.controller;
    }

    @Override
    public String getName() {
        return "Докажите, что вы человек";
    }
}
