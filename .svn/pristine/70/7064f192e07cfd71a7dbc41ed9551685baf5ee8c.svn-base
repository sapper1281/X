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
 *Комментарий об идее
 * @author VVolgina
 */
@Entity
@Table(name = "Comment")
public class Comment extends BaseEntity implements Serializable{

    //<editor-fold defaultstate="collapsed" desc="поля">
    @Column(length = 3000)
    private String text;
    private String fileName;
    @JoinColumn(name="action_id")
    @ManyToOne
    private Action action;
    
      //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="поля">

    /**
     * Текст сообщения
     * @return Текст сообщения
     */
        public String getText() {
        return text;
    }

    /**
     *Текст сообщения
     * @param text Текст сообщения
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *Имя прикрепленного файла
     * @return Имя прикрепленного файла
     */
    public String getFileName() {
        return fileName;
    }

    /**
     *Имя прикрепленного файла
     * @param fileName Имя прикрепленного файла
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Действие(Объединяет комментарий с тем кто его оставил и на какую идею)
     * @return Действие(Объединяет комментарий с тем кто его оставил и на какую идею)
     */
    public Action getAction() {
        return action;
    }

    /**
     * Действие(Объединяет комментарий с тем кто его оставил и на какую идею)
     * @param action Действие(Объединяет комментарий с тем кто его оставил и на какую идею)
     */
    public void setAction(Action action) {
        this.action = action;
    }
    
    /**
     * id действия
     * @param action id действия
     */
    public void setActionID(long id) {
        this.action = new Action(id);
    } 

//</editor-fold>
}
