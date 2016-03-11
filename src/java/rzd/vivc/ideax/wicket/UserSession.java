/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.ideax.wicket;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;
import rzd.vivc.ideax.model.entity.User;

/**
 * Расширенная сесиия. В ней так же быдут хранится данные об авторизованном
 * пользователе
 *
 * @author vvolgina
 */
public class UserSession extends WebSession {

    private User user;
    /**
     * Константа обзначает пользователя с правами на создание собственных идей
     */
    ///TODO перенести это а так же методы по определению к-ва прав в класс UserSecurity. В него же всю необходимую инфу из User и использовать в сессии его
    public static final String DIRECTOR_NAME = "Администратор";

    public UserSession(Request request) {
        super(request);
    }

    /**
     * Возвращаться должна именно сессия дданного пользователя
     *
     * @return Возвращаться должна именно сессия дданного пользователя
     */
    public static UserSession get() {
        return (UserSession) Session.get();
    }

    /**
     * Был ли в данной сессии авторизован пользователь
     *
     * @return Был ли в данной сессии авторизован пользователь
     */
    public boolean isAuthenticated() {
        return user != null;
    }

    /**
     * Пользователь, авторизованный в системе
     *
     * @return Пользователь, авторизованный в системе
     */
    public User getUser() {
        return user;
    }

    /**
     * Пользователь, авторизованный в системе
     *
     * @param user Пользователь, авторизованный в системе
     */
    public void setUser(User user) {
        this.user = user;
    }
}