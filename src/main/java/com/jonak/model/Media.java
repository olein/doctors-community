package com.jonak.model;

import com.jonak.lib.MySQLDatabase;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by lenin on 12/6/14.
 */
public class Media extends MediaModel
{
    // get media by id
    public static Media findById( int id ) throws Exception
    {
        Media file = new Media();
        MySQLDatabase db = new MySQLDatabase();

        String  _tableName = "media",
                _fieldName = "*",
                _filter = " limit 1 ";
        ArrayList _fields = new ArrayList(),
                _types  = new ArrayList(),
                _values = new ArrayList();

        _fields.add("id");            _types.add("int");            _values.add( id ); //find current user

        ResultSet rs = db.executeSelectQuery( _tableName, _fieldName, _fields, _types, _values, _filter);

        if( rs.next() ) {
            file = Media.setData( rs );
        } else {
            file = null;
        }

        return file;
    }

    // sets message data
    private static Media setData( ResultSet rs ) throws Exception
    {
        Media file = new Media();
        file.setId( rs.getInt("id") );
        file.setUserId(rs.getInt("user_id"));
        file.setContentId(rs.getInt("content_id"));
        file.setTitle(rs.getString("title"));
        file.setFilename(rs.getString("filename"));
        file.setLink(rs.getString("link"));
        file.setFilePath(rs.getString("file_path"));
        file.setMediaType(rs.getString("media_type"));
        file.setCreatedAt(rs.getInt("created_at"));
        file.clear();

        return file;
    }

    // get all media
    public static Vector find( String where, ArrayList values, String filter ) throws Exception
    {
        Vector medias = new Vector();
        MySQLDatabase db = new MySQLDatabase();

        String sql = " select * from  media ";

        if( ! where.isEmpty() ) {
            sql += where;
        }

        if( ! filter.isEmpty() ) {
            sql += filter;
        }

        ResultSet rs = db.executeSelectQuery( sql, values );

        if( rs.next() ) {
            do {
                Media file = new Media();
                file.setId( rs.getInt("id") );
                file.setUserId( rs.getInt("user_id") );
                file.setContentId( rs.getInt("content_id") );
                file.setTitle( rs.getString("title") );
                file.setFilename( rs.getString("filename") );
                file.setLink( rs.getString("link") );
                file.setFilePath( rs.getString("file_path") );
                file.setMediaType( rs.getString("media_type") );
                file.setCreatedAt( rs.getInt("created_at") );
                file.clear();

                medias.add( file );
            } while( rs.next() );
        } else {
            medias = null;
        }

        return medias;
    }
}
