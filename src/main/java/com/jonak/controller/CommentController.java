package com.jonak.controller;

import com.jonak.lib.SessionLib;
import com.jonak.lib.Tools;
import com.jonak.model.Comment;
import com.jonak.model.Content;
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
    public Vector<Comment> comments = new Vector<Comment>();
    public String add_comment;

    public CommentController()
    {
        super();
    }

    public void saveComment() throws Exception
    {
        Comment comment = new Comment();
        comment.setContent_id(Integer.parseInt(Tools.get("id")));
        comment.setUser_id(SessionLib.getUserID());
        comment.setContent(Tools.get("content"));
        comment.setParent_id(0);
        comment.setCreated_at(Tools.getTimeStamp());
        comment.save(); //add content

        Content content = Content.findContentByID(Integer.parseInt(Tools.get("id")));
        content.setComment_counter(content.getComment_counter()+1);
        content.save();

        if(Integer.parseInt(Tools.get("type"))==1)
        {
            String red = "board-detail?type=1&id="+comment.getContent_id();
            Tools.redirect( red );
        }
        if(Integer.parseInt(Tools.get("type"))==2)
        {
            String red = "patient-case-detail?type=2&id="+comment.getContent_id();
            Tools.redirect( red );
        }
        if(Integer.parseInt(Tools.get("type"))==3)
        {
            String red = "discussion-detail?type=3&id="+comment.getContent_id();
            Tools.redirect( red );
        }
        if(Integer.parseInt(Tools.get("type"))==4)
        {
            String red = "patient-question-detail?type=4&id="+comment.getContent_id();
            Tools.redirect( red );
        }
        if(Integer.parseInt(Tools.get("type"))==5)
        {
            String red = "article-detail?type=5&id="+comment.getContent_id();
            Tools.redirect( red );
        }
    }

    public String viewComment() throws Exception
    {
        // this is how we will be using
        // get the user with id 1
        comments = Comment.find(); //get result using user id
        return this.SUCCESS;
    }

    public void deleteComment() throws Exception
    {
        Comment comment = Comment.find(Integer.parseInt(Tools.get("id")));
        if((comment.getUser_id())==SessionLib.getUserID()) {
            int contentId = comment.getContent_id();
            comment.delete(); //delete

            Content content = Content.findContentByID(contentId);
            content.setComment_counter(content.getComment_counter()-1);
            content.save();
        }
        if(Integer.parseInt(Tools.get("type"))==1)
        {
            String red = "board-detail?type=1&id="+comment.getContent_id();
            Tools.redirect( red );
        }
        if(Integer.parseInt(Tools.get("type"))==2)
        {
            String red = "patient-case-detail?type=2&id="+comment.getContent_id();
            Tools.redirect( red );
        }
        if(Integer.parseInt(Tools.get("type"))==3)
        {
            String red = "discussion-detail?type=3&id="+comment.getContent_id();
            Tools.redirect( red );
        }
        if(Integer.parseInt(Tools.get("type"))==4)
        {
            String red = "patient-question-detail?type=4&id="+comment.getContent_id();
            Tools.redirect( red );
        }
        if(Integer.parseInt(Tools.get("type"))==5)
        {
            String red = "article-detail?type=5&id="+comment.getContent_id();
            Tools.redirect( red );
        }
    }

    public Vector<Comment> getComments() {
        return comments;
    }

    public void setComments(Vector<Comment> comments) {
        this.comments = comments;
    }

    public String getadd_Comment() {
        return add_comment;
    }

    public void setadd_Comment(String add_comment) {
        this.add_comment = add_comment;
    }

}
