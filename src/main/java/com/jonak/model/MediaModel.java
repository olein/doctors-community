package com.jonak.model;

import com.jonak.lib.Tools;

import java.util.Date;

/**
 * Created by lenin on 12/6/14.
 */
public class MediaModel extends BaseModel {

    public MediaModel ()
    {
        super();
        this.tableName = "media";
    }

    private int userId;
    private int contentId;
    private String title;
    private String filename;
    private String link;
    private String filePath;
    private String mediaType;
    private int createdAt;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
        this.fields.add("user_id");        this.types.add("int");     this.values.add(this.getUserId());
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
        this.fields.add("content_id");        this.types.add("int");     this.values.add(this.getContentId());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        this.fields.add("title");        this.types.add("String");     this.values.add(this.getTitle());
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
        this.fields.add("filename");        this.types.add("String");     this.values.add(this.getFilename());
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
        this.fields.add("link");        this.types.add("String");     this.values.add(this.getLink());
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
        this.fields.add("file_path");        this.types.add("String");     this.values.add(this.getFilePath());
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
        this.fields.add("media_type");        this.types.add("String");     this.values.add(this.getMediaType());
    }

    public Date getCreatedAt() throws Exception
    {
        return Tools.getDate( this.createdAt );
    }

    public int getCreatedAt(boolean b) {

        return createdAt;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
        this.fields.add("created_at");        this.types.add("int");     this.values.add(this.getCreatedAt(true));
    }
}
