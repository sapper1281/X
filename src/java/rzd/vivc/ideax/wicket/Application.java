/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.ideax.wicket;

import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import rzd.vivc.ideax.wicket.autorization.XAutorisationStrategy;
import rzd.vivc.ideax.wicket.startpage.Login;

/**
 * Входной класс приложения. Указывает, входную страницу, вид сессии и.т.д.
 *
 * @author vvolgina
 */
public class Application extends WebApplication {

    public Application() {

    }

    @Override
    protected void init() {
        super.init();
        //тут прописан класс, в котором рассказано об авторизации
        getSecuritySettings().setAuthorizationStrategy(new XAutorisationStrategy());
        getSecuritySettings().setUnauthorizedComponentInstantiationListener(new XAutorisationStrategy());
    }


    @Override
    public Class getHomePage() {
        //входная страница
        return Login.class;
    }

    @Override
    public Session newSession(Request request, Response response) {
        //вместо обычной сессии будет та, в которой хранятся данные пользователя
        return new UserSession(request);
    }
    
    

}
