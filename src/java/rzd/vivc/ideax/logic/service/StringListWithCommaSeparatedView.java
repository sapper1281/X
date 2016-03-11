/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.ideax.logic.service;

import java.util.List;
import rzd.vivc.ideax.model.pageobjeсt.UserInfoForList;

/**
 * Список строг. Есть дополнительный метод лдля вывода всего списка через
 * запятую
 *
 * @author vvolgina
 */
public class StringListWithCommaSeparatedView {

    private List<String> list;

    /**
     * Создает список строк с возможность ю их последующего вывода через запятую
     *
     * @param list
     */
    public StringListWithCommaSeparatedView(List<String> list) {
        this.list = list;
    }

    /**
     * СПисок значений из списка через запятую
     *
     * @return СПисок значений из списка через запятую
     */
    public String getCommaSeparatedValues() {
        StringBuilder builder = new StringBuilder();
        for (String string : list) {
            builder.append(string).append(", ");
        }
        String res = builder.toString();
        return res.length() > 2 ? res.substring(0, res.length() - 2) : "";
    }

    /**
     * Добавление ФИО ползователей из списка, при усорвии, что таких ФИО ранее не было добавлено
     * @param listAdd список пользователей
     */
    public void addList(List<UserInfoForList> listAdd) {
        if (listAdd != null && !listAdd.isEmpty()) {
            for (UserInfoForList userInfoForList : listAdd) {
                if (!checkExists(userInfoForList)) {
                    list.add(userInfoForList.getFIO());
                }
            }
        }
    }

    //проверка, есть ли в списке такое ФИО
    private boolean checkExists(UserInfoForList add) {
        for (String string : list) {
            if (string.equalsIgnoreCase(add.getFIO())) {
                return true;
            }
        }
        return false;
    }
}
