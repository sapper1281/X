/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.ideax.logic.service;

import java.io.File;
import java.util.UUID;
import org.apache.wicket.markup.html.form.upload.FileUpload;

/**
 * Класс для обеспечения загрузки файлов на сервер
 * @author vvolgina
 */
public class Upload {

    /**
     * Сохранение загруженного файла на диск
     * @param uploadedFile загруженный файл
     * @return название файла на диске. Если файла не было, вернет пустую строку
     * @throws IllegalStateException не удалось сохранить файл
     */
    public String doUpload(FileUpload uploadedFile) throws IllegalStateException{
        String fileName="";
        if (uploadedFile != null) {

            fileName=generateName(uploadedFile.getClientFileName());
            // запись на диск
            File newFile = new File(Constants.UPLOAD_FOLDER
                    + fileName);

            if (newFile.exists()) {
                newFile.delete();
            }

            try {
                newFile.createNewFile();
                uploadedFile.writeTo(newFile);

            } catch (Exception e) {
                new SaveErrorInfo().save(e);
                throw new IllegalStateException("Не удалось загрузить файл");             
            }
        }
        return fileName;
    }
    
    //генерация уникального имени для файла
    private String generateName(String userName){
        return "idea" + UUID.randomUUID() + userName;
    }
}
