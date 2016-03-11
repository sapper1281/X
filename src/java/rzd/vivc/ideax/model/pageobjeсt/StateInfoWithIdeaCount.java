/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.ideax.model.pageobjeсt;

import java.io.Serializable;

/**
 * Для выпадающего списка. Название состояния и к-во соответствующих ему идей
 * @author vvolgina
 */
public class StateInfoWithIdeaCount extends BaseInfo implements Serializable{
    //Название
    private String name;
    //К-во идей для состояния
    private int count;

    public StateInfoWithIdeaCount(long id) {
        super(id);
    }

    public StateInfoWithIdeaCount(String name, int count, long id) {
        super(id);
        this.name = name;
        this.count = count;
    }
   
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
     * К-во идей для состояния
     * @return К-во идей для состояния
     */
    public int getCount() {
        return count;
    }

    /**
     * К-во идей для состояния
     * @param count К-во идей для состояния
     */
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return name + " (" + count + ')';
    }
       
}
