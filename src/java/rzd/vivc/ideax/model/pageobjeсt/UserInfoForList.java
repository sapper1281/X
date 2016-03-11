/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.ideax.model.pageobjeсt;

import java.io.Serializable;

/**
 * Информация о опльзователе для вывода в список
 * @author vvolgina
 */
public class UserInfoForList extends BaseInfo implements Serializable{
    //<editor-fold defaultstate="collapsed" desc="поля">
    //ФИО
    private String FIO;
    //Название отдела
    private String deartmentName;
    //</editor-fold>

    public UserInfoForList(String FIO, String deartmentName, long id) {
        super(id);
        this.FIO = FIO;
        this.deartmentName = deartmentName;
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
     * ФИО
     * @param FIO ФИО
     */
    public void setFIO(String FIO) {
        this.FIO = FIO;
    }
    
    /**
     *Название отдела
     * @return Название отдела
     */
    public String getDeartmentName() {
        return deartmentName;
    }
    
    /**
     * Название отдела
     * @param deartmentName Название отдела
     */
    public void setDeartmentName(String deartmentName) {
        this.deartmentName = deartmentName;
    }
    //</editor-fold>
    
}
