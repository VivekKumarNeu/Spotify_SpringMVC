/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Vivek
 */
public abstract class WorkRequest {
    
    private int workrequestId;
    private String car;
    private String Source;
    private String Destination;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private String comment;
    
    
    public WorkRequest(){
        requestDate = new Date();
    }

    public int getWorkrequestId() {
        return workrequestId;
    }

    public void setWorkrequestId(int workrequestId) {
        this.workrequestId = workrequestId;
    }
    
    public String getcar(){
        return car;
    }
    
    public void setcar(String car){
        this.car = car;
    }

    public int  getseats(){
        return seats;
    }
    
    public void setseats(int seat){
        this.seats = seat;
    }

    private int seats;

    public String getcomment(){
        return comment;
    }
    
    public void setcomment(String comment) {
        this.comment = comment;
    }
    
    public String getSource() {
        return Source;
    }

    public void setSource(String message) {
        this.Source = message;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String message) {
        this.Destination = message;
    }
    
    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver (UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    @Override
    public String toString() {
        return this.car;
    }
    
    
}
