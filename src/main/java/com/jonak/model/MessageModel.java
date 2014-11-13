package com.jonak.model;

import java.util.Date;

/**
 * Created by Fahim on 13/11/2014.
 */
public class MessageModel extends BaseModel
{
    private int id;
    private int from_user_id;
    private int to_user_id;
    private String user_name;
    private String msg;
    private int created_at;
    private Date date;
    private String update;
    private String delete;

    public MessageModel()
    {
        super();
        this.tableName = "message";
    }

    protected void prepareFields() {
        // again no need for id

        // database field name              field type                          getter method
        this.fields.add("from_user_id");        this.types.add("int");     this.values.add(this.getFrom_user_id());
        this.fields.add("to_user_id");      this.types.add("int");     this.values.add(this.getTo_user_id());
        this.fields.add("msg");   this.types.add("String");        this.values.add(this.getMsg());
        this.fields.add("created_at");  this.types.add("int");        this.values.add(this.getCreated_at());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFrom_user_id() {
        return from_user_id;
    }

    public void setFrom_user_id(int from_user_id) {
        this.from_user_id = from_user_id;
    }

    public int getTo_user_id() {
        return to_user_id;
    }

    public void setTo_user_id(int to_user_id) {
        this.to_user_id = to_user_id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

}
