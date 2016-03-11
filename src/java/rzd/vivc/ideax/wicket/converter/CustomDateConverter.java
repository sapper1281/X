/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.ideax.wicket.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.IConverter;

/**
 *
 * @author vvolgina
 */
public class CustomDateConverter implements IConverter<Date> {

    private SimpleDateFormat format;

    public CustomDateConverter() {
        format = new SimpleDateFormat("dd/MM/yyyy");
    }

    @Override
    public Date convertToObject(String string, Locale locale) throws ConversionException {
        if (string == null || string.trim().length() == 0) {
            return null;
        }
        Date res;
        try {
            res= format.parse(string);
        } catch (ParseException ex) {
            throw new ConversionException(ex.getMessage());
        }
        return res;
    }

    @Override
    public String convertToString(Date c, Locale locale) {
        return c == null ? null : format.format(c);
    }
}
