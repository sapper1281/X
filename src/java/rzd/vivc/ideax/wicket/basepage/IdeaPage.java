/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.ideax.wicket.basepage;

import org.apache.wicket.markup.html.WebPage;
import rzd.vivc.ideax.wicket.UserSession;

/**
 * Базовая страница для системы. 
 * @author VVolgina
 */
public class IdeaPage extends WebPage {

    /**
     * Получить хранящиеся в сессии данные о пользователе
     * @return хранящиеся в сессии данные о пользователе
     */
    public UserSession getUserSession() {
        return (UserSession) getSession();
    }
}
