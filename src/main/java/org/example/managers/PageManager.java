package org.example.managers;

import org.example.pages.AuthPage;
import org.example.pages.BusinessTripCreationPage;
import org.example.pages.BusinessTripListPage;
import org.example.pages.MenuBlock;

/**
 * Класс для управления страничками
 */
public class PageManager {

    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;

    /**
     * Страница авторизации
     */
    private AuthPage authPage;

    /**
     * Панель быстрого запуска
     */
    private MenuBlock menuBlock;

    /**
     * Страница Все Командировки
     */
    private BusinessTripListPage businessTripListPage;

    /**
     * Страница Создать командировку
     */
    private BusinessTripCreationPage businessTripCreationPage;

    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     *
     * @see PageManager#getPageManager()
     */
    private PageManager() {
    }

    /**
     * Ленивая инициализация PageManager
     *
     * @return PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * Ленивая инициализация {@link AuthPage}
     *
     * @return AuthPage
     */
    public AuthPage getAuthPage() {
        if (authPage == null) {
            authPage = new AuthPage();
        }
        return authPage;
    }

    /**
     * Ленивая инициализация {@link MenuBlock}
     *
     * @return MenuBlock
     */
    public MenuBlock getMenuBlock() {
        if (menuBlock == null) {
            menuBlock = new MenuBlock();
        }
        return menuBlock;
    }

    /**
     * Ленивая инициализация {@link BusinessTripListPage}
     *
     * @return BusinessTripListPage
     */
    public BusinessTripListPage getBusinessTripListPage() {
        if (businessTripListPage == null) {
            businessTripListPage = new BusinessTripListPage();
        }
        return businessTripListPage;
    }

    /**
     * Ленивая инициализация {@link BusinessTripCreationPage}
     *
     * @return BusinessTripCreationPage
     */
    public BusinessTripCreationPage getBusinessTripCreationPage() {
        if (businessTripCreationPage == null) {
            businessTripCreationPage = new BusinessTripCreationPage();
        }
        return businessTripCreationPage;
    }
}
