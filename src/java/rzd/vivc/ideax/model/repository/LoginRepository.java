/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.ideax.model.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import rzd.vivc.ideax.model.configuration.SessionFactorySingleton;
import rzd.vivc.ideax.model.entity.LoginInfo;

/**
 * Репозиторий. Для учетных данных пользователя
 *
 * @author VVolgina
 */
public class LoginRepository {

    /**
     * Извлечение из БД пользователя по логину
     *
     * @param login логин
     * @return объект из БД с заданным логином
     */
    public LoginInfo get(String login)  throws HibernateException{
        Session sess = SessionFactorySingleton.getSessionFactoryInstance()
                .openSession();
        Transaction t = sess.beginTransaction();

        LoginInfo bd = get(login, sess);

        t.commit();
        sess.close();

        return bd;
    }

    /**
     * Извлечение из БД пользователя по логину
     *
     * @param login логин
     * @param sess сессия Хибернейт с открытой транзакцией
     * @return объект из БД с заданным логином
     */
    protected LoginInfo get(String login, Session sess)  throws HibernateException{
        return (LoginInfo) sess.get(LoginInfo.class, login);
    }
}
