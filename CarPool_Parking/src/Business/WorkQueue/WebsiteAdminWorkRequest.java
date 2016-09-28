/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author Vivek
 */
public class WebsiteAdminWorkRequest extends WorkRequest{
    
    private String Username;
    private String rating;
    private boolean markit;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public boolean isMarkit() {
        return markit;
    }

    public void setMarkit(boolean markit) {
        this.markit = markit;
    }

    
    @Override
    public String toString() {
        return rating;
    }
    
}
