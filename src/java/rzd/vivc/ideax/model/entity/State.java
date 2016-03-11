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
 * Состояние идеи (отклонена, принята и.т.д.)
 *
 * @author VVolgina
 */
@Entity
@Table(name = "State")
public class State extends BaseEntity implements Serializable{

    //<editor-fold defaultstate="collapsed" desc="поля">

    private String name;
    @OneToMany(mappedBy = "state")
    private List<Idea> ideas = new ArrayList<>();
    //</editor-fold>

    public State() {
    }

    public State(long id) {
        super(id);
    }

     //<editor-fold defaultstate="collapsed" desc="get-set">
    /**
     * Название
     *
     * @return Название
     */
    public String getName() {
        return name;
    }

    /**
     * Название
     *
     * @param name Название
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Список идей, находящихся в даном состоянии
     * @return Список идей, находящихся в даном состоянии
     */
    public List<Idea> getIdeas() {
        return Collections.unmodifiableList(ideas);
    }

    /**
     * Список идей, находящихся в даном состоянии
     * @param ideas Список идей, находящихся в даном состоянии
     */
    public void setIdeas(List<Idea> ideas) {
        this.ideas = ideas;
    }
 //</editor-fold>

}
