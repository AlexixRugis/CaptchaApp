package com.artech.workerslogin.core.manager;

/**
 * Слушатель события обновления коллекции моделей
 * @see IObjectManager
 */
public interface IManagerUpdateListener {
    /**
     * Вызывается при обновлении коллекции моделей
     */
    void onUpdate();
}

