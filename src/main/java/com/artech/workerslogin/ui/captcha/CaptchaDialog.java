package com.artech.workerslogin.ui.captcha;

import com.artech.workerslogin.core.storage.IStorage;
import com.artech.workerslogin.ui.views.ActionDialog;
import com.artech.workerslogin.ui.views.View;

public class CaptchaDialog extends ActionDialog {

    private final CaptchaView view;

    public CaptchaDialog(IStorage storage) {
        this.view = new CaptchaView(storage);
    }

    @Override
    protected View getView() {
        return this.view;
    }

    @Override
    protected Boolean performAction() {
        return false;
    }

    @Override
    protected boolean validate() {
        return true;
    }
}
