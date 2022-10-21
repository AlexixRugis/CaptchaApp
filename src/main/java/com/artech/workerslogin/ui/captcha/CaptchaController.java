package com.artech.workerslogin.ui.captcha;

import com.artech.workerslogin.core.storage.IStorage;
import com.artech.workerslogin.ui.controllers.Controller;

public class CaptchaController extends Controller {
    /**
     * Конструктор контроллера
     *
     * @param storage Зранилище данных
     */
    public CaptchaController(IStorage storage) {
        super(storage);
    }
}
