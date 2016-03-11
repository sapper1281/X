/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.ideax.wicket.panels;

import java.util.Date;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.convert.IConverter;
import rzd.vivc.ideax.wicket.converter.CustomDateConverter;

/**
 * Тот же лейбл, но форматирует выводимую дату по формату MM/dd/yyyy
 * В конструктор может передаваться только объект типа Date
 *
 * @author vvolgina
 */
public class DateLabel extends Label {

    public DateLabel(String id, Date model) {
        super(id, model);
    }

    public DateLabel(String id, IModel<Date> model) {
        super(id, model);
    }

    
    
    @Override
    public IConverter getConverter(Class type) {
        return new CustomDateConverter();
    }
}
