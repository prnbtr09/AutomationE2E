package petstore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tags {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public Tags setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Tags setName(String name) {
        this.name = name;
        return this;
    }
}
