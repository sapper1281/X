/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rzd.vivc.ideax.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.NaturalId;
import rzd.vivc.ideax.model.entity.Base.BaseEntity;
import static rzd.vivc.ideax.wicket.UserSession.DIRECTOR_NAME;

/**
 * Пользователи
 * @author VVolgina
 */
@Entity
@Table(name = "User")
public class User extends BaseEntity implements Serializable{
    //<editor-fold defaultstate="collapsed" desc="поля">
    private String FIO;
    private String phone;
    @NaturalId
    //так сделано, чтобы нельзя было создать 2 пользователей с 1 и тем же мылом. это важно при восстановлении пароля по мылу.
    private String email;
    @JoinColumn(name = "user_type_id")
    @ManyToOne
    private UserType userType;
    @JoinColumn(name = "department_id")
    @ManyToOne
    private Department department;
    
     //</editor-fold>

    public User(long id) {
       super(id);
    }

    public User() {
        super();
    }

    
    
    //<editor-fold defaultstate="collapsed" desc="get-set">

    /**
     * ФИО
     * @return ФИО
     */
        public String getFIO() {
        return FIO;
    }

    /**
     *ФИО
     * @param FIO ФИО
     */
    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    /**
     * Телефонный номер
     * @return Телефонный номер
     */
    public String getPhone() {
        return phone;
    }

    /**
     *Телефонный номер
     * @param phone Телефонный номер
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Мыло
     * @return Мыло
     */
    public String getEmail() {
        return email;
    }

    /**
     *Мыло
     * @param email Мыло
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Тип пользователя
     * @return Тип пользователя
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * Тип пользователя
     * @param userType Тип пользователя
     */
    public void setUserType(UserType userType) {
        this.userType = userType;
    }
    
     /**
     * id типа пользователя
     * @param id id типа пользователя
     */
    public void setUserTypeID(long id) {
        this.userType = new UserType(id);
    }

    /**
     * Подразделение
     * @return Подразделение
     */
    public Department getDepartment() {
        return department;
    }

    /**
     *Подразделение
     * @param department Подразделение
     */
    public void setDepartment(Department department) {
        this.department = department;
    }
    
     /**
     *id подразделения
     * @param id id подразделения
     */
    public void setDepartmentID(long id) {
        this.department = new Department(id);
    }
     //</editor-fold>
    
     /**
     * Есть ли у данного пользователя права на создание собственных заметок
     * @return Есть ли у данного пользователя права на создание собственных заметок
     */
    public boolean isDirector(){
        return userType.getName().equals(DIRECTOR_NAME);
    }
}
