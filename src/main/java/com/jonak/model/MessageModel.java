package com.jonak.model;

import java.util.Date;

/**
 * Created by Fahim on 13/11/2014.
 */
public class MessageModel extends BaseModel
{
    private int fromUserId;
    private int toUserId;
    private String msg;
    private int created_at;

    public MessageModel()
    {
        super();
        this.tableName = "message";
    }

    public int getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(int fromUserId) {
        this.fromUserId = fromUserId;
        this.fields.add("from_user_id");        this.types.add("int");     this.values.add(this.getFromUserId());
    }

    public int getToUserId() {
        return toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
        this.fields.add("to_user_id");      this.types.add("int");     this.values.add(this.getToUserId());
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
        this.fields.add("msg");   this.types.add("String");        this.values.add(this.getMsg());
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
        this.fields.add("created_at");  this.types.add("int");        this.values.add(this.getCreated_at());
    }
}
