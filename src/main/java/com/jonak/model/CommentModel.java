package com.jonak.model;

import java.util.Date;

/**
 * Created by Fahim on 15/11/2014.
 */
public class CommentModel  extends BaseModel
{
    private int content_id;
    private int user_id;
    private String content;
    private int parent_id;
    private int created_at;
    private String update;
    private String delete;
    private Date date;
    private String name;
    private String addcomment;

    public CommentModel()
    {
        super();
        this.tableName = "comment";
    }

    protected void prepareFields() {
        // again no need for id

        // database field name              field type                          getter method
        this.fields.add("content_id");        this.types.add("int");     this.values.add(this.getContent_id());
        this.fields.add("user_id");      this.types.add("int");     this.values.add(this.getUser_id());
        this.fields.add("content");      this.types.add("String");     this.values.add(this.getContent());
        this.fields.add("parent_id");   this.types.add("int");        this.values.add(this.getParent_id());
        this.fields.add("created_at");  this.types.add("int");        this.values.add(this.getCreated_at());
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddcomment() {
        return addcomment;
    }

    public void setAddcomment(String addcomment) {
        this.addcomment = addcomment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
