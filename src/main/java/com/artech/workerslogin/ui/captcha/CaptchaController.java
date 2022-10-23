package com.artech.workerslogin.ui.captcha;

import com.artech.workerslogin.core.storage.IStorage;
import com.artech.workerslogin.ui.controllers.Controller;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextField;

import java.util.Objects;

public class CaptchaController extends Controller {

    private static final int captchaLength = 5;

    @FXML
    private Canvas canvas;
    @FXML
    private TextField textInputField;

    private CaptchaGenerator captchaGenerator;
    private String captchaText;

    /**
     * Конструктор контроллера
     *
     * @param storage Зранилище данных
     */
    public CaptchaController(IStorage storage) {
        super(storage);
    }

    /**
     * Проверка капчи
     *
     * @return true - капча пройдена, false - пользователь нажал "Отмена"
     */
    public boolean validate() {
        if (!Objects.equals(this.captchaText, this.textInputField.getText())) {
            regenerateCaptcha();
            this.textInputField.setText("");
            return false;
        }

        return true;
    }

    @FXML
    private void initialize() {
        this.captchaGenerator = new CaptchaGenerator(this.canvas);

        regenerateCaptcha();
    }

    private void regenerateCaptcha() {
        this.captchaText = this.captchaGenerator.generate(captchaLength);
    }
}
