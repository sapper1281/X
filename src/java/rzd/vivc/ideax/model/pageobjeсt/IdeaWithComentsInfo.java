/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.ideax.model.pageobjeсt;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import rzd.vivc.ideax.model.entity.Comment;

/**
 * Для страницы с рецензией. Информация об идее и коментарии к ней
 *
 * @author vvolgina
 */
public class IdeaWithComentsInfo extends BaseInfo implements Serializable{
    //<editor-fold defaultstate="collapsed" desc="поля">

    //тема идеи
    private String theme;
    //текст идеи
    private String text;
    //имя файла
    private String fileName;
    //дата до которой надо обработать идею
    private Date dt_end;
    //список коментариев по идее
    private List<Comment> comments;

    //</editor-fold>
    public IdeaWithComentsInfo(String theme, String text, String fileName, Date dt_end, long id) {
        super(id);
        this.theme = theme;
        this.text = text;
        this.fileName = fileName;
        this.dt_end = dt_end;
    }

    //<editor-fold defaultstate="collapsed" desc="get-set">
    /**
     * Тема
     *
     * @return Тема
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Тема
     *
     * @param theme Тема
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * Содержание идеи
     *
     * @return Содержание идеи
     */
    public String getText() {
        return text;
    }

    /**
     * Содержание идеи
     *
     * @param text Содержание идеи
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Приложенный файл
     *
     * @return Приложенный файл
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Приложенный файл
     *
     * @param fileName Приложенный файл
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
        /**
     * Дата до которой надо обработать идею
     *
     * @return Дата до которой надо обработать идею
     */
    public Date getDt_end() {
        return dt_end;
    }

    /**
     * Дата до которой надо обработать идею
     *
     * @param dt_end Дата до которой надо обработать идею
     */
    public void setDt_end(Date dt_end) {
        this.dt_end = dt_end;
    }
    
    /**
     * Комментариии по идее
     * @return Комментариии по идее
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * Комментариии по идее
     * @param comments Комментариии по идее
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    } 

    //</editor-fold>
    @Override
    public String toString() {
        return "IdeaWithComentsInfo{" + "theme=" + theme + ", text=" + text + ", fileName=" + fileName + ", dt_end=" + dt_end +  '}';
    }
    
    
}
