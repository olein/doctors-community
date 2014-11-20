package com.jonak.controller;

import com.jonak.lib.SessionLib;
import com.jonak.model.Comment;
import com.jonak.model.User;
import org.apache.struts2.ServletActionContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

/**
 * Created by Fahim on 15/11/2014.
 */
public class CommentController extends BaseController
{
    public Vector<Comment> messages = new Vector<Comment>();
    public String add_comment;

    public CommentController()
    {
        super();
    }

    public String add() throws Exception
    {
        Comment comment = new Comment();
        comment.setContent_id(Integer.parseInt(ServletActionContext.getRequest().getParameter("content_id")));
        comment.setUser_id(SessionLib.getUserID());
        comment.setContent(ServletActionContext.getRequest().getParameter("content"));
        comment.setParent_id(0);
        int timestamp = (int) (new Date().getTime()/1000);
        comment.setCreated_at(timestamp);
        comment.save(); //add content
        return this.SUCCESS;
    }

    public String viewComment() throws Exception
    {
        // this is how we will be using
        // get the user with id 1

        ResultSet rs = Comment.find(); //get result using user id

        if( rs != null ) {

            while( rs.next() ) {
                Comment comment = new Comment();
                comment.setId(rs.getInt(1));
                comment.setUser_id(rs.getInt(3));
                User user = User.find(rs.getInt(3));
                comment.setName(user.getFirstName()+" "+user.getLastName());
                comment.setContent_id(rs.getInt(2));
                comment.setContent(rs.getString(4));
                comment.setParent_id(rs.getInt(5));
                int d = (rs.getInt(6));
                Date date = new Date(((long)d)*1000L);
                comment.setDate(date);
                comment.setUpdate("update_comment?id=" + rs.getInt(1)); //set update link
                comment.setDelete("delete_comment?id=" + rs.getInt(1)); //set delete link
                //comment.setAddcomment("add_comment?content_id=" + rs.getInt(2));
                setadd_Comment("add_comment?content_id=" + rs.getInt(2));
                messages.add(comment); //add result to vector
            }
        }
        return this.SUCCESS;
    }

    public String setContentID() throws Exception
    {
        SessionLib.set("ContentID", ServletActionContext.getRequest().getParameter("id")); //set content ID
        return this.SUCCESS;
    }

    public String update() throws Exception
    {
        Comment comment = Comment.find(Integer.parseInt(SessionLib.get("ContentID")));
        if((comment.getUser_id())==SessionLib.getUserID()) {
            if (ServletActionContext.getRequest().getParameter("content").length() > 0) {
                comment.setContent(ServletActionContext.getRequest().getParameter("content")); // reset title
            }
            comment.setId(comment.getId());
            comment.setUser_id(comment.getUser_id());
            comment.setContent_id(comment.getContent_id());
            comment.setParent_id(comment.getParent_id());
            comment.setCreated_at(comment.getCreated_at());
            comment.update(comment.getId());
            return this.SUCCESS;
        }
        return this.ERROR;
    }

    public String delete() throws Exception
    {
        Comment comment = Comment.find(Integer.parseInt(ServletActionContext.getRequest().getParameter("id")));
        if((comment.getUser_id())==SessionLib.getUserID()) {
            comment.delete(); //delete
            return this.SUCCESS;
        }
        return this.ERROR;
    }


    public Vector<Comment> getMessages() {
        return messages;
    }

    public void setMessages(Vector<Comment> messages) {
        this.messages = messages;
    }

    public String getadd_Comment() {
        return add_comment;
    }

    public void setadd_Comment(String add_comment) {
        this.add_comment = add_comment;
    }

}
