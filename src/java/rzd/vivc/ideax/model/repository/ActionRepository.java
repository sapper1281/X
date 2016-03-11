/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.ideax.model.repository;

import java.util.List;
import org.hibernate.Session;
import rzd.vivc.ideax.model.entity.Action;
import rzd.vivc.ideax.model.entity.Comment;
import rzd.vivc.ideax.model.entity.Idea;
import rzd.vivc.ideax.model.entity.State;

/**
 *
 * @author apopovkin
 */
public class ActionRepository extends BaseRepository<Action>{
    
    /**
     * Найти действие для пользователя по данной идее
     * @param idIdea id Идеи
     * @param idUser id пользователя
     * @return действие для пользователя по данной идее
     */
    public Action findActionForIdeaAndUser(long idIdea, long idUser){
       ///TODO Проверить, чтобы на 1 польователя по 1 идее действительно приходилось 1 действие
       Session session=getSession();
       Action action=(Action)session.createQuery("SELECT a from Action AS a WHERE a.idea.id=:idIdea AND a.user.id=:idUser").setLong("idIdea", idIdea).setLong("idUser", idUser).uniqueResult();
       closeSession(session);
       return action;
   }

      
    /**
     * Сохранить комментарий и обновить относящееся к нему действие
     * @param comment комментарий
     */
    public void saveCommentWithAction(Comment comment){
       Session session=getSession();
       new ActionRepository().save(comment.getAction(), session);
       new CommentRepository().save(comment, session);
       Idea idea=new IdeaRepository().get(comment.getAction().getIdea().getId());
       idea.setState(findStateForIdea(idea.getId(), session));
       new IdeaRepository().save(idea);
       closeSession(session);
   }
   
    /**
     * Найти все действия для этой идеи
     * @param idIdea id Идеи
     * @param session сессия с открытой транзакцией
     * @return все действия для этой идеи
     */
    protected List<Action> findAllActionsForIdea(long idIdea, Session session){
       List<Action> actions=(List<Action>)session.createQuery("SELECT a from Action AS a WHERE a.idea.id=:idIdea").setLong("idIdea", idIdea).list();
       return actions;
   }
   
    /**
     * Вычислят состояние идеи на основании состояний относящихся к ней действий
     * @param idIdea id идеи
     * @param session сессия с открытой транзакией
     * @return состояние для идеи
     */
    protected State findStateForIdea(long idIdea, Session session){
       List<Action> findAllActionsForIdea = findAllActionsForIdea(idIdea, session);
       for (Action action : findAllActionsForIdea) {
           //если хоть 1 пользователь принял идею - она принята к сполнению
           if(action.getState().getName().equalsIgnoreCase("Принятые")){
               return action.getState();
           }
           //если хоть 1 ползователь добавил идею в архив - она в архиве
           if(action.getState().getName().equalsIgnoreCase("Архив")){
               return action.getState();
           }
       }
       //если идею либо отклоняли либо не рассматривали - она отклоненная
       return new StateRepository().getStateByName("Отклоненные");
   }
     
   public static void main(String[] args){
       ActionRepository rep=new ActionRepository();
       Action findActionForIdeaAndUser = rep.findActionForIdeaAndUser(1, 3);
       System.out.println(findActionForIdeaAndUser.getId());
    }
}
