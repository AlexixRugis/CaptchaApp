package com.artech.workerslogin.core;

import com.artech.workerslogin.core.storage.IStorage;
import javafx.stage.Stage;

/**
 * Приложение
 */
public interface IApplication {
    /**
     * Получает настройки приложения
     * @return Настройки приложения
     */
    ISettings getSettings();

    /**
     * Получает хранилище данных приложения
     * @return Хранилище данных приложения
     */
    IStorage getStorage();

    /**
     * Получает контейнер интерфейса приложения
     * @return Контейнер интерфейса приложения
     * @see Stage
     */
    Stage getPrimaryStage();
}
