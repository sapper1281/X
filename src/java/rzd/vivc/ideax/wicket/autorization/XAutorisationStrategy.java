/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.ideax.wicket.autorization;

import org.apache.wicket.Component;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.authorization.Action;
import org.apache.wicket.authorization.IAuthorizationStrategy;
import org.apache.wicket.authorization.IUnauthorizedComponentInstantiationListener;
import org.apache.wicket.request.component.IRequestableComponent;
import rzd.vivc.ideax.wicket.UserSession;
import rzd.vivc.ideax.wicket.startpage.LoginE;
import rzd.vivc.ideax.wicket.basepage.ProtectedPage;

/**
 * Методы для авторизации и вывода ошибок при ее провале
 *
 * @author VVolgina
 */
public class XAutorisationStrategy implements IAuthorizationStrategy, IUnauthorizedComponentInstantiationListener {

    @Override
    public <T extends IRequestableComponent> boolean isInstantiationAuthorized(Class<T> type) {
        //авторизация по странице
        //для унаследованных от класса ProtectedPage 
        //авторизация пройдет только если у пользователя тип Директор
        if (ProtectedPage.class.isAssignableFrom(type)) {
            UserSession sess = UserSession.get();
            return sess.isAuthenticated() && sess.getUser().isDirector();
        }
        return true;
    }

    @Override
    public boolean isActionAuthorized(Component cmpnt, Action action) {
        //для отдельных элементов. пока не делаю
        if (action.equals(Component.RENDER)) {
            Class<? extends Component> c = cmpnt.getClass();
            DirectorOnly directorOnly = c.getAnnotation(DirectorOnly.class);
            if (directorOnly != null) {
                UserSession sess = UserSession.get();
                return sess.isAuthenticated() && sess.getUser().isDirector();
            }
        }
        return true;
    }

    @Override
    public void onUnauthorizedInstantiation(Component cmpnt) {
        //при провале авторизации переход на указанную страницу
        throw new RestartResponseAtInterceptPageException(LoginE.class);
    }
}
