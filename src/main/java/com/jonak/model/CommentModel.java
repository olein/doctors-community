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

    private Date date;
    private String name;

    public CommentModel()
    {
        super();
        this.tableName = "comment";
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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
        this.fields.add("content_id");        this.types.add("int");     this.values.add(this.getContent_id());

    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
        this.fields.add("user_id");      this.types.add("int");     this.values.add(this.getUser_id());

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.fields.add("content");      this.types.add("String");     this.values.add(this.getContent());

    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
        this.fields.add("parent_id");   this.types.add("int");        this.values.add(this.getParent_id());

    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
        this.fields.add("created_at");  this.types.add("int");        this.values.add(this.getCreated_at());
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
