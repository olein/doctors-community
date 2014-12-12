package com.jonak.lib;

import com.jonak.model.Media;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by lenin on 12/3/14.
 */
public class UploadHandler extends ActionSupport {

    /**
     * file upload paramters
     */
    private File uploadFile;
    private String uploadFileType;
    private String uploadFileName;

    private HttpServletRequest servletRequest;

    Vector dataOut = new Vector();

    // @SuppressWarnings("finally")
    public void upload() throws Exception
    {
        // get upload dir

        String  uploadDir = Configuration.get("uploadDir"),

                uploadPath = Tools.request.getSession().getServletContext().getRealPath("/").concat( uploadDir );


                uploadPath = uploadDir;
//                uploadPath = Tools.request.getSession().getServletContext().getRealPath("/").concat( uploadDir );

        File destFile = null;

        System.out.println("upload dir "+ uploadDir);

        // try upload
        try {
            destFile  = new File( uploadPath, this.uploadFileName );
            FileUtils.copyFile( this.uploadFile, destFile );
        } catch ( IOException e ) {
            e.printStackTrace();
            System.out.println("file upload error");
        }

        System.out.println(uploadDir + " : " + uploadPath);

        // upload success
        System.out.println("file uploaded");

        // save it
        String fileLink = Configuration.get("site_url") + "/" + Configuration.get("uploadDir") + "/" + this.uploadFileName;
        Media file = new Media();
        file.setUserId( SessionLib.getUserID() );
        file.setContentId( 0 );
        file.setTitle( "" );
        file.setFilename( this.uploadFileName );
        file.setLink( fileLink );
        file.setFilePath( destFile.toString() );
        file.setMediaType( this.uploadFileType );
        file.setCreatedAt( Tools.getTimeStamp() );
        file.save();

        // return
        Tools.redirect("edit-media?action=edit&mid="+file.getId());
    }

    public File getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(File uploadFile) {
        this.uploadFile = uploadFile;
    }

    public String getUploadFileContentType() {
        return uploadFileType;
    }

    public void setUploadFileContentType(String contentType) {
        this.uploadFileType = contentType;
    }

    public String getUploadFileFileName() {
        return uploadFileName;
    }

    public void setUploadFileFileName(String fileName) {
        this.uploadFileName = fileName;
    }

    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;

    }
}
