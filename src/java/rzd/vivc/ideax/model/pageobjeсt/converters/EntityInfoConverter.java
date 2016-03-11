/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.ideax.model.pageobjeсt.converters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import rzd.vivc.ideax.model.entity.Base.BaseEntity;
import rzd.vivc.ideax.model.pageobjeсt.BaseInfo;

/**
 * Конвертирует производные классы с краткой информацией в объекты сущностей БД с теми же id и наоборот
 * @author vvolgina
 * @param <T1>
 * @param <T2>
 */
public abstract class EntityInfoConverter <T1 extends BaseEntity, T2 extends BaseInfo>{
    private Class cl;

    public EntityInfoConverter() {
        //определяет, какого типа T1
        cl=(Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    
    
     /**
     * Создает на основе списка информации список сущностей с соответствующими Id
     * Для новых классов надо проверять конструктор!!!!
     * @param infos список информации
     * @return список сущностей
     */
    public List<T1> convert(List<T2> infos) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        List<T1> res=new ArrayList<>();
        for (T2 info : infos) {
            //создаем объект типа T1 с id из T2
            res.add((T1)(cl.getConstructor(long.class).newInstance(info.getId())));
        }
        return res;
    }
    
    
}
