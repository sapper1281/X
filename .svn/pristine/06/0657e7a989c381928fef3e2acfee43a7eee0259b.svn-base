/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.ideax.logic.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Просто запихивает инфо об ошибке в файл
 * @author vvolgina
 */
public class SaveErrorInfo {

    /**
     * росто запихивает инфо об ошибке в файл
     * @param e ошибка
     */
    public void save(Exception e) {
        try {
            e.printStackTrace(new PrintStream(new File(Constants.UPLOAD_FOLDER)));
        } catch (FileNotFoundException ex) {
        }
    }
}
