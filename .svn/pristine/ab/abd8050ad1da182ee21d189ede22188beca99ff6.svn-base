/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.ideax.wicket.pages.forall;

import java.util.Date;
import java.util.List;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;
import rzd.vivc.ideax.logic.service.SaveErrorInfo;
import rzd.vivc.ideax.logic.service.Upload;
import rzd.vivc.ideax.model.entity.Action;
import rzd.vivc.ideax.model.entity.Comment;
import rzd.vivc.ideax.model.pageobjeсt.IdeaWithComentsInfo;
import rzd.vivc.ideax.model.repository.ActionRepository;
import rzd.vivc.ideax.model.repository.IdeaRepository;
import rzd.vivc.ideax.model.repository.StateRepository;
import rzd.vivc.ideax.wicket.basepage.IdeaPage;
import rzd.vivc.ideax.wicket.panels.DateLabel;
import rzd.vivc.ideax.wicket.panels.DownloadIdeaLink;

/**
 * Странмца для ввода коменткриев на идею
 *
 * @author vvolgina
 */
public final class Recenzia extends IdeaPage {

    //модель для загрузки данных по идее
    private class LoadableIdeaWithComentsModel extends LoadableDetachableModel<IdeaWithComentsInfo> {

        private long id;
        private transient IdeaWithComentsInfo idea;

        public long getId() {
            return id;
        }

        public LoadableIdeaWithComentsModel(IdeaWithComentsInfo idea) {
            super(idea);
            this.id = idea.getId();
        }

        public LoadableIdeaWithComentsModel(long id) {
            this.id = id;
        }

        @Override
        protected IdeaWithComentsInfo load() {
            if (id == 0) {
                return new IdeaWithComentsInfo("", "", "", new Date(), id);
            }
            return new IdeaRepository().getIdeaWithComents(id);
        }
    }
    //тдея с комментариями
    private LoadableIdeaWithComentsModel idea;
    //новый создаваемый комментарий
    private Comment newComment = new Comment();
    //прикрепляемый к новому коментарию файл
    private FileUploadField fileUpload;
    //имя файла, прикрепленного к идее
    private String fileName = "";

    public Recenzia(PageParameters params) {
        //загружаем все из БД
        long toLong = params.get("id").toLong(0);
        idea = new LoadableIdeaWithComentsModel(toLong);
        fileName = new IdeaRepository().get(toLong).getFileName();
        //тема идеи
        add(new Label("theme", new PropertyModel(idea, "theme")));
        //текст идеи
        add(new MultiLineLabel("text", new PropertyModel(idea, "text")));
        //загрузка прикрепленного фала с сервера
        add(new DownloadIdeaLink("download", fileName));
        //дата, до которой надо обработать идею
        add(new DateLabel("data", new PropertyModel<Date>(idea, "dt_end")));
        //список комментариев, оставленных на идею
        ListView<Comment> comments = new ListView<Comment>("comment", new PropertyModel<List<Comment>>(idea, "comments")) {
            @Override
            protected void populateItem(ListItem<Comment> li) {
                final Comment comment = li.getModelObject();
                //кто оставил, и какой поставил статус
                li.add(new Label("fio", comment.getAction().getUser().getFIO() + ": " + comment.getAction().getState().getName()));
                //текст идеи
                li.add(new MultiLineLabel("commentText", comment.getText()));
                //дата, когда оставлен коментарий
                li.add(new DateLabel("commentDate", comment.getDt_create()));
                //загрузка с сервера фала, прикрепленного к идее
                li.add(new DownloadIdeaLink("downloadCommentLink", comment.getFileName()));
            }
        };
        add(comments);
        //форма добаления гнового комментария
        Form form = new Form("newComment");
        add(form);
        //текст
        form.add(new TextArea("newText", new PropertyModel(newComment, "text")));
        //Загрузка файла на сервер
        form.setMultiPart(true);
        form.add(fileUpload = new FileUploadField("fileUpload"));
        //сохранение и придание статуса
        //принято
        SubmitLink yes = new SubmitLink("yes") {
            @Override
            public void onSubmit() {
                super.onSubmit();
                onSubmitForAll("Принятые");
            }
        };
        //отклонено
        SubmitLink no = new SubmitLink("no") {
            @Override
            public void onSubmit() {
                super.onSubmit();
                onSubmitForAll("Отклоненные");
            }
        };
        //в архив
        SubmitLink arch = new SubmitLink("arch") {
            @Override
            public void onSubmit() {
                super.onSubmit();
                onSubmitForAll("Архив");
            }
        };
        form.add(yes);
        form.add(no);
        form.add(arch);
    }

    //общая часть сохранения комментария при нажатии кнопки состатусом
    private void onSubmitForAll(String state) {
        //загрузка файла на сервер
        final FileUpload uploadedFile = fileUpload.getFileUpload();
        try {
            String fileNameDown = new Upload().doUpload(uploadedFile);
            if (!fileNameDown.isEmpty()) {
                newComment.setFileName(fileNameDown);
            }
        } catch (IllegalStateException e) {
            new SaveErrorInfo().save(e);
            error(e.getMessage());
        }
        //сохранение заметки в БД
        Action findActionForIdeaAndUser = new ActionRepository().findActionForIdeaAndUser(idea.getId(), getUserSession().getUser().getId());
        if (findActionForIdeaAndUser == null) {
            findActionForIdeaAndUser = new Action();
            findActionForIdeaAndUser.setIdeaID(idea.getId());
            findActionForIdeaAndUser.setRequired(false);
            findActionForIdeaAndUser.setUserID(getUserSession().getUser().getId());
        }
        findActionForIdeaAndUser.setState(new StateRepository().getStateByName(state));
        newComment.setAction(findActionForIdeaAndUser);
        new ActionRepository().saveCommentWithAction(newComment);
        //возврат на страницу со списком идей
        setResponsePage(Messenger.class);
    }
}
