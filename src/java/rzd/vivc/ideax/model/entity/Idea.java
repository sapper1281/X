/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rzd.vivc.ideax.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import rzd.vivc.ideax.model.entity.Base.BaseEntity;

/**
 *Идея
 * @author VVolgina
 */
@Entity
@Table(name = "idea")
public class Idea extends BaseEntity implements Serializable{
     //<editor-fold defaultstate="collapsed" desc="поля">

    private String theme;
    @Column(length = 6000)
    private String text;
    private String fileName;
    private boolean archive=false;
    private byte access;
    @JoinColumn(name = "user_creator_id")
    @ManyToOne
    private User userCreator;
    @JoinColumn(name = "state_id")
    @ManyToOne
    private State state=new State(1);

 //</editor-fold>

    public Idea(long id) {
        super(id);
    }

    public Idea() {
       super();
    }

   
    //<editor-fold defaultstate="collapsed" desc="get-set">

    /**
     * Тема
     * @return Тема
     */
        public String getTheme() {
        return theme;
    }

    /**
     * Тема
     * @param theme Тема
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * Содержание идеи
     * @return Содержание идеи
     */
    public String getText() {
        return text;
    }

    /**
     * Содержание идеи
     * @param text Содержание идеи
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Приложенный файл
     * @return Приложенный файл
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Приложенный файл
     * @param fileName Приложенный файл
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Флаг, что идея отправлена в архив
     * @return Флаг, что идея отправлена в архив
     */
    public boolean isArchive() {
        return archive;
    }

    /**
     * Флаг, что идея отправлена в архив
     * @param archive Флаг, что идея отправлена в архив
     */
    public void setArchive(boolean archive) {
        this.archive = archive;
    }

    /**
     * Модификатор общего доступа
     * @return Модификатор общего доступа
     */
    public byte getAccess() {
        return access;
    }

    /**
     * Модификатор общего доступа
     * @param access Модификатор общего доступа
     */
    public void setAccess(byte access) {
        this.access = access;
    }

    /**
     * Пользователь, создавший идею
     * @return Пользователь, создавший идею
     */
    public User getUserCreator() {
        return userCreator;
    }

    /**
     * Пользователь, создавший идею
     * @param userCreator Пользователь, создавший идею
     */
    public void setUserCreator(User userCreator) {
        this.userCreator = userCreator;
    }
     /**
     * id пользователя, создавшего идею
     * @param id пользователя, создавшего идею
     */
    public void setUserCreatorID(long id) {
        this.userCreator = new User(id);
    }

    /**
     * Результирующее состояние идеи
     * @return Результирующее состояние идеи
     */
    public State getState() {
        return state;
    }

    /**
     * Результирующее состояние идеи
     * @param state Результирующее состояние идеи
     */
    public void setState(State state) {
        this.state = state;
    }
    
      /**
     * id результирующего состояния идеи
     * @param id результирующего состояния идеи
     */
       public void setStateID(long id) {
        this.state = new State(id);
    }
     //</editor-fold>
}
