/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.Date;

/**
 *
 * @author Vivek
 */
public class TechnicalpersonworkRequest extends WorkRequest{
    
    private String receiverResult;
    private String component;
    private String issue;
    private Date submitdate;
    private String resolution;

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
    
    public Date getSubmitdate() {
        return submitdate;
    }

    public void setSubmitdate(Date submitdate) {
        this.submitdate = submitdate;
    }

      
    public String getReceiverResult() {
        return receiverResult;
    }

    public void setReceiverResult(String receiverResult) {
        this.receiverResult = receiverResult;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }
    
     @Override
    public String toString() {
        return this.issue;
    }
    
    
}
