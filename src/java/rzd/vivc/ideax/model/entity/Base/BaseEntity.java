/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.ideax.model.entity.Base;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

/**
 * Базовый класс для всех БДшных
 *
 * @author VVolgina
 */
@MappedSuperclass
public class BaseEntity {

    //<editor-fold defaultstate="collapsed" desc="поля">
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "dt_end")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dt_end;
    @Column(name = "dt_begin")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dt_begin;
    @Column(name = "dt_create", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dt_create = new Date();
    @Column(name = "del_fl")
    private boolean deleted = false;

    //</editor-fold>
    public BaseEntity(long id) {
        this.id = id;
    }

    public BaseEntity() {
    }

    //<editor-fold defaultstate="collapsed" desc="get-set">
    /**
     * id
     *
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * id
     *
     * @param id id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Дата окончания актуальности
     *
     * @return Дата окончания актуальности
     */
    public Date getDt_end() {
        return dt_end;
    }

    /**
     * Дата окончания актуальности
     *
     * @param dt_end Дата окончания актуальности
     */
    public void setDt_end(Date dt_end) {
        this.dt_end = dt_end;
    }

    /**
     * Дата начала актуальности
     *
     * @return Дата начала актуальности
     */
    public Date getDt_begin() {
        return dt_begin;
    }

    /**
     * Дата начала актуальности
     *
     * @param dt_begin Дата начала актуальности
     */
    public void setDt_begin(Date dt_begin) {
        this.dt_begin = dt_begin;
    }

    /**
     * Дата создания
     *
     * @return Дата создания
     */
    public Date getDt_create() {
        return dt_create;
    }

    /**
     * Дата создания
     *
     * @param dt_create Дата создания
     */
    public void setDt_create(Date dt_create) {
        this.dt_create = dt_create;
    }

    /**
     * Является ли объект удаленным
     *
     * @return Является ли объект удаленным
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * Является ли объект удаленным
     *
     * @param deleted Является ли объект удаленным
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
      //</editor-fold>
}
