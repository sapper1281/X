/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.ideax.model.pageobjeсt.converters;

import java.util.ArrayList;
import java.util.List;
import rzd.vivc.ideax.model.entity.User;
import rzd.vivc.ideax.model.pageobjeсt.UserInfoForList;

/**
 * Преобразует краткую информацию в объекты БД
 * @author vvolgina
 */
public class UserConverter {
    /**
     * Создает на основе списка информации список пользователей с соответствующими Id
     * @param infos список информации
     * @return список полдьзователей
     */
    public List<User> convert(List<UserInfoForList> infos){
        ///TODO Унаследовать от базового класса и убрать лишние строки
        List<User> res=new ArrayList<>();
        for (UserInfoForList userInfo : infos) {
            res.add(new User(userInfo.getId()));
        }
        return res;
    }
}
