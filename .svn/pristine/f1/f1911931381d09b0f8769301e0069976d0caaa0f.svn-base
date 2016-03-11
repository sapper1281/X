/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.ideax.logic.autorisation;

import rzd.vivc.ideax.model.entity.LoginInfo;
import rzd.vivc.ideax.model.repository.LoginRepository;
import rzd.vivc.ideax.wicket.UserSession;

/**
 *
 * @author vvolgina
 */
public class Autentification {
//<editor-fold defaultstate="collapsed" desc="Поля">

    private String login = null;
    private String password = null;
//</editor-fold>

    public Autentification() {
    }

    public Autentification(String login, String password) {
        this.login = login;
        this.password = password;
    }

    //<editor-fold defaultstate="collapsed" desc="Get-set">
    /**
     * Логин
     *
     * @return Логин
     */
    public String getLogin() {
        return login;
    }

    /**
     * Логин
     *
     * @param login Логин
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Пароль
     *
     * @return Пароль
     */
    public String getPassword() {
        return password;
    }

    /**
     * Пароль
     *
     * @param password Пароль
     */
    public void setPassword(String password) {
        this.password = password;
    }
//</editor-fold>

    /**
     * Проверяет, имеет ли пользователь с указанными учетными данными право
     * входа в систему
     *
     * @param userSession сессия пользователя для сохранения учетных данных при
     * успешном вхое в систему
     * @return Сообщение об ошибке, либо "access" при успешном входе. При
     * успешном входе сохраняет данные пользователя в сессии, в противном
     * случае, присваивает им значение Null
     */
    public String signIn(UserSession userSession) {
        //Идут проверки, что все данные были введены правильно и из БД удалось извлечь соответствующую
        //информацию о пользователе
        if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
            userSession.setUser(null);
            return "Необходимо ввести логин и пароль";
        }
        LoginInfo loginInfo;
        try {
            loginInfo = (new LoginRepository()).get(login);
        } catch (Exception e) {
            userSession.setUser(null);
            return "Ошибка связи с базой данных" + e.getMessage();
        }
        if (loginInfo == null) {
            userSession.setUser(null);
            return "Введен неверный логин";
        }
        if (!loginInfo.getPassword().equals(password)) {
            userSession.setUser(null);
            return "Введен неверный пароль";
        }
        //Если все прошло успешно, сохраняем инфо пользователя в сессию и выдаем сообщение с разрешением на вход
        userSession.setUser(loginInfo.getUser());
        return "access";
    }
}
