package com.jonak.model;

import java.util.Date;

/**
 * Created by Fahim on 14/11/2014.
 */
public class ContentModel extends BaseModel
{
    private int id;
    private int user_id;
    private String title;
    private String description;
    private int type;
    private int privacy;
    private int allow_comment;
    private int comment_counter;
    private int parent_id;
    private int created_at;
    private Date date;
    private String update;
    private String delete;
    private String category_name;
    public ContentModel()
    {
        super();
        this.tableName = "content";
    }

    protected void prepareFields() {
        // again no need for id

        // database field name              field type                          getter method
        this.fields.add("user_id");        this.types.add("int");     this.values.add(this.getUser_id());
        this.fields.add("title");      this.types.add("String");     this.values.add(this.getTitle());
        this.fields.add("description");   this.types.add("String");        this.values.add(this.getDescription());
        this.fields.add("type");  this.types.add("int");        this.values.add(this.getType());
        this.fields.add("privacy");  this.types.add("int");        this.values.add(this.getPrivacy());
        this.fields.add("allow_comment");  this.types.add("int");        this.values.add(this.getAllow_comment());
        this.fields.add("comment_counter");  this.types.add("int");        this.values.add(this.getComment_counter());
        this.fields.add("parent_id");  this.types.add("int");        this.values.add(this.getParent_id());
        this.fields.add("created_at");  this.types.add("int");        this.values.add(this.getCreated_at());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPrivacy() {
        return privacy;
    }

    public void setPrivacy(int privacy) {
        this.privacy = privacy;
    }

    public int getAllow_comment() {
        return allow_comment;
    }

    public void setAllow_comment(int allow_comment) {
        this.allow_comment = allow_comment;
    }

    public int getComment_counter() {
        return comment_counter;
    }

    public void setComment_counter(int comment_counter) {
        this.comment_counter = comment_counter;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }


}
