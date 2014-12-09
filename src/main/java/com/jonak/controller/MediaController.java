package com.jonak.controller;

import com.jonak.controller.BaseController;
import com.jonak.lib.Tools;
import com.jonak.model.Media;

import java.util.ArrayList;

/**
 * Created by lenin on 12/3/14.
 */
public class MediaController extends BaseController
{
    /**
     * retrieves all media files
     *
     * @return string
     * @throws Exception
     */
    public String viewMediaFiles() throws Exception
    {
        // offset, limit
        String where = "", filter=" order by created_at desc limit ?, ? ";
        ArrayList values = new ArrayList();
        values.add( 0 );
        values.add( 5 );

        this.dataOut = Media.find(where, values, filter);

        return this.SUCCESS;
    }

    /**
     * edit media action
     *
     * @return string
     * @throws Exception
     */
    public String editMediaFile() throws Exception
    {
        // get params
        String  action = Tools.get("action"),
                strMid = Tools.get("mid");
        int mid = Tools.toInt( strMid );

        // find the media file
        Media file = null;
        if( mid > 0 ) {
            file = Media.findById( mid );

        }

        // set to data
        this.dataOut.add( file );

        // return
        return this.SUCCESS;
    }


    /**
     * save media action
     *
     * @throws Exception
     */
    public void saveMediaFile() throws Exception
    {
        // get params
        String  action = Tools.get("action"),
                strMid = Tools.get("id"),
                title = Tools.get("title");
        int mid = Tools.toInt( strMid );

        // save & return
        if( mid > 0 ) {
            Media file = Media.findById( mid );
            if( ! file.getTitle().equals(title) ) {
                file.setTitle(title);
                file.save();
            }
            Tools.redirect("edit-media?action=view&update=true&mid="+mid);
        } else {
            Tools.redirect("media-library?action=view&error=true");
        }
    }

    /**
     * delete a media file action
     *
     * @throws Exception
     */
    public void deleteMediaFile() throws Exception
    {
        // get params
        String  strMid = Tools.get("id");

        int mid = Tools.toInt( strMid );

        if( mid > 0 ) {
            Media file = Media.findById( mid );
            file.delete();

            Tools.redirect("media-library?action=view&delete=true");
        } else {
            Tools.redirect("media-library?action=view&error=true");
        }
    }
}
