package com.jonak.model;

/**
 * Created by Fahim on 09/11/2014.
 */
public class ExperienceModel extends BaseModel
{
    private String title;
    private String description;
    private int userId;

    public ExperienceModel()
    {
        super();
        this.tableName = "experience";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        this.fields.add("description"); this.types.add("String");     this.values.add(this.getDescription());
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
        this.fields.add("user_id");     this.types.add("int");        this.values.add(this.getUserId());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        this.fields.add("title");       this.types.add("String");     this.values.add(this.getTitle());
    }

}
