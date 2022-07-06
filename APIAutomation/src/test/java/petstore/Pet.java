package petstore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

//@JsonIgnoreProperties(value = {"photoUrls","tags"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pet {
    private int id;
    private Category category;
    private String name;
    private String photoUrls[];
    private List<Tags> tags;
    private String status;


    public int getId() {
        return id;
    }

    public Pet setId(int id) {
        this.id = id;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Pet setCategory(Category category) {
        this.category = category;
        return this;
    }

    public String getName() {
        return name;
    }

    public Pet setName(String name) {
        this.name = name;
        return this;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public Pet setPhotoUrls(String[] photoUrls) {
        this.photoUrls = photoUrls;
        return this;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public Pet setTags(List<Tags> tags) {
        this.tags = tags;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Pet setStatus(String status) {
        this.status = status;
        return this;
    }
}