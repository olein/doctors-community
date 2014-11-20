package com.jonak.model;

/**
 * Created by Fahim on 15/11/2014.
 */
public class ParticipantModel extends BaseModel
{
    private int content_id;
    private int user_id;
    private int active;
    private String delete;
    private String user_name;
    private String status;

    public ParticipantModel()
    {
        super();
        this.tableName = "participant";
    }

    protected void prepareFields() {
        // again no need for id

        // database field name              field type                          getter method
        this.fields.add("content_id");    this.types.add("int");     this.values.add(this.getContent_id());
        this.fields.add("user_id");       this.types.add("int");     this.values.add(this.getUser_id());
        this.fields.add("active");        this.types.add("int");     this.values.add(this.getActive());
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

}
