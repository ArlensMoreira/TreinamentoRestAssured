package jsonobjects;


import java.util.Locale;

public class PetInexistente {

    int id;
    CategoryObject category;
    String name;
    String [] photoUrls;
    TagObject [] tags;
    String status;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CategoryObject getCategory() {
        return category;
    }

    public void setCategory(CategoryObject category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(String[] photoUrls) {
        this.photoUrls = photoUrls;
    }

    public TagObject[] getTags() {
        return tags;
    }

    public void setTags(TagObject[] tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
