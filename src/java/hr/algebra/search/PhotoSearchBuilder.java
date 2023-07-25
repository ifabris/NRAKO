/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.search;

import hr.algebra.dal.sql.DataSourceSingleton;
import hr.algebra.imagesFilter.Photo;
import hr.algebra.model.Post;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Ivan
 */
public class PhotoSearchBuilder {

    private String hashtag;
    private String authorFirstName;
    private String authorLastName;

    public PhotoSearchBuilder setHashtag(String hashtag) {
        this.hashtag = hashtag;
        return this;
    }


    public PhotoSearchBuilder setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
        return this;
    }

    public PhotoSearchBuilder setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
        return this;
    }

    public List<Post> search() throws SQLException {
        DataSource ds = DataSourceSingleton.getInstance();
     Connection con = ds.getConnection();
     Statement statement = con.createStatement();
     List<Post> posts = new ArrayList<Post>();     
     String query = "exec SearchPostsByUserAndHashtag '"+ authorFirstName +"','"+ authorLastName +"','"+ hashtag +"'; ";
     ResultSet rs = statement.executeQuery(query);    
     while (rs.next()) {
             posts.add(new Post(rs.getInt("PostId"),rs.getString("First_name"),
             rs.getString("Last_name"),rs.getString("Picture"),rs.getString("Info"),rs.getInt("IDUser") ));      
     }
        
        return posts;
    }
}

