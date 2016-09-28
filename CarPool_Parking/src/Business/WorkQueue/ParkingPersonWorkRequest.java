/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Vivek
 */
public class ParkingPersonWorkRequest extends WorkRequest{
    
    private Double parkingamount;
    private ArrayList<Date> Parkingdate;
    
    public ParkingPersonWorkRequest()
    {
     Parkingdate = new ArrayList<>();
    }
    
    public Double getParkingamount() {
        return parkingamount;
    }

    public void setParkingamount(Double parkingamount) {
        this.parkingamount = parkingamount;
    }

    public ArrayList<Date> getParkingdate() {
        return Parkingdate;
    }

    public void setParkingdate(Date Parkingdatei) {
        Parkingdate.add(Parkingdatei);
    }

    
    
    @Override
    public String toString() {
        return String.valueOf(parkingamount) ;
    }
    
    
}
