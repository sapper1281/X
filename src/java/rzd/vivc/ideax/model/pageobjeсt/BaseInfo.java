/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.ideax.model.pageobjeсt;

import java.io.Serializable;

/**
 * Объекты для извлечения из БД основных кусков информации об объектах
 * @author vvolgina
 */
public class BaseInfo implements Serializable{
    //<editor-fold defaultstate="collapsed" desc="поля">
    //id
    private long id;
    //</editor-fold>
    
     public BaseInfo(long id) {
        this.id = id;
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
    //</editor-fold>

}
