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
public class CarOwnerWorkRequest extends WorkRequest{
    
    private String testResult;
    private String commentsoutput;
    private int maxrides;
    private Double rideamount;
    
    public CarOwnerWorkRequest() {
         maxrides=0;
    }
        
    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
    
     public String getCommentsoutput() {
        return commentsoutput;
    }

    public void setCommentsoutput(String commentsoutput) {
        this.commentsoutput = commentsoutput;
    }

    public Double getRideamount() {
        return rideamount;
    }

    public void setRideamount(Double rideamount) {
        this.rideamount = rideamount;
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
}
