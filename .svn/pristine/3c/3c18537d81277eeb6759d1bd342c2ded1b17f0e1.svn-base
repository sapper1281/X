/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.ideax.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import rzd.vivc.ideax.model.entity.Base.BaseEntity;

/**
 * Типы пользователей
 * @author VVolgina
 */
@Entity
@Table(name = "User_type")
public class UserType extends BaseEntity implements Serializable{
    private static final long serialVersionUID = -3241765837700606142L;

    //<editor-fold defaultstate="collapsed" desc="поля">
    private String name;
    @OneToMany(mappedBy = "userType")
    private List<User> users = new ArrayList<>();
    //</editor-fold>

    public UserType(long id) {
        super(id);
    }

    public UserType() {
        super();
    }
        
    //<editor-fold defaultstate="collapsed" desc="get-set">

    /**
     * Название
     * @return Название
     */
        public String getName() {
        return name;
    }

    /**
     * Название
     * @param name Название
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Список пользователей с данным типом
     * @return  Список пользователей с данным типом
     */
    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    /**
     *  Список пользователей с данным типом
     * @param users  Список пользователей с данным типом
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }
 //</editor-fold>
}
