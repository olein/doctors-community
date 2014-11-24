package com.jonak.model;

import java.util.Date;

/**
 * Created by Fahim on 14/11/2014.
 */
public class ContentModel extends BaseModel
{
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

    private String add_participant;
    private String show_participant;
    private String category_name;
    private String comments;
    public ContentModel()
    {
        super();
        this.tableName = "content";
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    public String getShow_participant() {
        return show_participant;
    }

    public void setShow_participant(String show_participant) {
        this.show_participant = show_participant;
    }

    public String getAdd_participant() {
        return add_participant;
    }

    public void setAdd_participant(String add_participant) {
        this.add_participant = add_participant;
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
        this.fields.add("user_id");        this.types.add("int");     this.values.add(this.getUser_id());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        this.fields.add("title");      this.types.add("String");     this.values.add(this.getTitle());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        this.fields.add("description");   this.types.add("String");        this.values.add(this.getDescription());
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
        this.fields.add("type");  this.types.add("int");        this.values.add(this.getType());
    }

    public int getPrivacy() {
        return privacy;
    }

    public void setPrivacy(int privacy) {
        this.privacy = privacy;
        this.fields.add("privacy");  this.types.add("int");        this.values.add(this.getPrivacy());
    }

    public int getAllow_comment() {
        return allow_comment;
    }

    public void setAllow_comment(int allow_comment) {
        this.allow_comment = allow_comment;
        this.fields.add("allow_comment");  this.types.add("int");        this.values.add(this.getAllow_comment());
    }

    public int getComment_counter() {
        return comment_counter;
    }

    public void setComment_counter(int comment_counter) {
        this.comment_counter = comment_counter;
        this.fields.add("comment_counter");  this.types.add("int");        this.values.add(this.getComment_counter());
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
        this.fields.add("parent_id");  this.types.add("int");        this.values.add(this.getParent_id());

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


    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }


}
