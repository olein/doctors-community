package com.jonak.model;

/**
 * Created by Fahim on 09/11/2014.
 */
public class ExperienceModel extends BaseModel
{
    private String title;
    private String description;
    private int user_id;


    private int id;
    public ExperienceModel()
    {
        super();
        this.tableName = "experience";
    }
    protected void prepareFields()
    {
        // again no need for id

        // database field name              field type                          getter method
        this.fields.add("user_id");     this.types.add("int");        this.values.add(this.getUser_id());
        this.fields.add("title");       this.types.add("String");     this.values.add(this.getTitle());
        this.fields.add("description"); this.types.add("String");     this.values.add(this.getDescription());
    }

    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getTitle() {

        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
