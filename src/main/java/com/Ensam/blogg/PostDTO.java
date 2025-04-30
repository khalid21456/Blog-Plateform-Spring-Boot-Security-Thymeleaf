package com.Ensam.blogg;



import org.springframework.stereotype.Component;

@SuppressWarnings("unused")

@Component
public class PostDTO {

    private String title;
    private String image;
    private String category;
    private String tags;
    private String content;
    private String extrait;

    public String getExtrait() {
        return extrait;
    }

    public void setExtrait(String extrait) {
        this.extrait = extrait;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String categorie) {
        this.category = categorie;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
