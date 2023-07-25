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
public class Hashtag {
    private int HashtagId;
    private String Name;
    private int PictureId;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getPictureId() {
        return PictureId;
    }

    public void setPictureId(int PictureId) {
        this.PictureId = PictureId;
    }

    public int getHashtagId() {
        return HashtagId;
    }

    public void setHashtagId(int HashtagId) {
        this.HashtagId = HashtagId;
    }

    public Hashtag(int HashtagId, String Name, int PictureId) {
        this.HashtagId = HashtagId;
        this.Name = Name;
        this.PictureId = PictureId;
    }

    public Hashtag() {
    }
    
}
