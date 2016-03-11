/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rzd.vivc.ideax.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Логин-пароль для пользователя
 * @author VVolgina
 */
@Entity
@Table(name = "Login_info")
public class LoginInfo implements Serializable{
      //<editor-fold defaultstate="collapsed" desc="поля">
    @Id
     private String login;
     private String password;
     @JoinColumn(name = "user_id")
     @OneToOne
     private User user;
    //</editor-fold>

   
    //<editor-fold defaultstate="collapsed" desc="поля">

    /**
     *Логин
     * @return Логин
     */
        public String getLogin() {
        return login;
    }

    /**
     * Логин
     * @param login Логин
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Пароль
     * @return Пароль
     */
    public String getPassword() {
        return password;
    }

    /**
     * Пароль
     * @param password Пароль
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Пользователь с данными учетными данными
     * @return Пользователь с данными учетными данными
     */
    public User getUser() {
        return user;
    }

    /**
     * Пользователь с данными учетными данными
     * @param user Пользователь с данными учетными данными
     */
    public void setUser(User user) {
        this.user = user;
    }
     //</editor-fold>
}
