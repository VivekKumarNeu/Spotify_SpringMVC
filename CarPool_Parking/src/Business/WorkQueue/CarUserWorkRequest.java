/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author Vivek
 */
public class CarUserWorkRequest extends WorkRequest{
    
    private String receiverResult;
    private String commentsoutput;
    private Double rideamount;
    private int maxrides;
    private ArrayList<UserAccount> userlist;

    public CarUserWorkRequest() {
        maxrides = 0;
        userlist = new ArrayList<>();
    }

    public String getreceiverResult() {
        return receiverResult;
    }

    public void setreceiverResult(String receiverResult) {
        this.receiverResult = receiverResult;
    }

    public Double getRideamount() {
        return rideamount;
    }

    public void setRideamount(Double rideamount) {
        this.rideamount = rideamount;
    }

    public String getCommentsoutput() {
        return commentsoutput;
    }

    public void setCommentsoutput(String commentsoutput) {
        this.commentsoutput = commentsoutput;
    }

    public int getMaxrides() {
        return maxrides;
    }

    public void setMaxrides(boolean maxri) {
        int history = getMaxrides();
        if(maxri){
            history++;
            maxrides = history;
        }
        else
        {
            history--;
            maxrides = history;
        }
    }

    public ArrayList<UserAccount> getUserlist() {
        return userlist;
    }

    public void setUserlist(UserAccount userlist1) {
        userlist.add(userlist1);
    }

    public void removeUserlist(UserAccount userlist1)
    {   userlist.remove(userlist1);
    }
}
