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

//<<<<<<< HEAD
/*        if( rs != null ) {

            while( rs.next() ) {
                Comment comment = new Comment();
                comment.setId(rs.getInt(1));
                comment.setUser_id(rs.getInt(3));
                User user = User.findById(rs.getInt(3));
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
            }*/
//=======
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
//>>>>>>> 1c4e3715bf6984c542f54554dc677532e1c85099
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
