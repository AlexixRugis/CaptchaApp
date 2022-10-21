package com.artech.workerslogin.ui.controllers;

import com.artech.workerslogin.core.storage.IStorage;

/**
 * Контроллер представления
 */
public abstract class Controller {
    protected final IStorage storage;

    /**
     * Конструктор контроллера
     * @param storage Зранилище данных
     */
    public Controller(IStorage storage) {
        this.storage = storage;
    }
}
