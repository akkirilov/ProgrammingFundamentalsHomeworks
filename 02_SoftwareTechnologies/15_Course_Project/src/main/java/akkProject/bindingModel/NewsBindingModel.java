package akkProject.bindingModel;

import akkProject.entity.User;


public class NewsBindingModel {
    private String title;
    private String content;
    private User newsUserId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getNewsUserId() {
        return newsUserId;
    }

    public void setNewsUserId(User newsUserId) {
        this.newsUserId = newsUserId;
    }
}
