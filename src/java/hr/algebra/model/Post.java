/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

/**
 *
 * @author Ivan
 */
public class Post {


   
    private int PostId;
    private String FirstName;
    private String LastName;
    private String Picture;

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String Picture) {
        this.Picture = Picture;
    }
    private String info;
    private int UserId;

    public Post(int PostId, String FirstName, String LastName, String Picture, String info, int UserId) {
        this.PostId = PostId;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Picture = Picture;
        this.info = info;
        this.UserId = UserId;
    }



    public int getPostId() {
        return PostId;
    }

    public void setPostId(int PostId) {
        this.PostId = PostId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public Post() {
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }
}
