/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.ideax.wicket.panels;

import java.io.File;
import org.apache.wicket.markup.html.link.DownloadLink;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.util.time.Duration;
import rzd.vivc.ideax.logic.service.Constants;

/**
 * Ссылка для загрузки файлов с сервера
 * @author VVolgina
 */
public class DownloadIdeaLink extends DownloadLink{

    public DownloadIdeaLink(String id, final String fileName) {
        
        super(id, new AbstractReadOnlyModel<File>() {
                    @Override
                    public File getObject() {
                        File down = new File(Constants.UPLOAD_FOLDER
                                + fileName);
                        return down;
                    }
                }, fileName);
        boolean viewComent = viewDownloadLink(fileName);
        setCacheDuration(Duration.NONE);
        setEnabled(viewComent);
    }
    
    
    // проверка, заданнол ли имя файла и соответственно, сожно ли его загрузить
     private boolean viewDownloadLink(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return false;
        }
        return true;
    }
}
