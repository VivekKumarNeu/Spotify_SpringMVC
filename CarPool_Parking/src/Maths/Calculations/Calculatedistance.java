/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maths.Calculations;

import java.util.HashMap;
import org.javatuples.Pair;

/**
 *
 * @author Vivek
 */
public class Calculatedistance {
    public double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
      double theta = lon1 - lon2;
      double distance = Math.sin(degreetoradian(lat1)) * Math.sin(degreetoradian(lat2)) + Math.cos(degreetoradian(lat1)) * Math.cos(degreetoradian(lat2)) * Math.cos(degreetoradian(theta));
      distance = Math.acos(distance);
      distance = radiantodegree(distance);
      distance = distance * 60 * 1.1515;
      if (unit == 'K') {
        distance = distance * 1.609344;
      } else if (unit == 'N') {
        distance = distance * 0.8684;
        }
      return (distance);
    }

    private double degreetoradian(double deg) {
      return (deg * Math.PI / 180.0);
    }

    private double radiantodegree(double rad) {
      return (rad * 180.0 / Math.PI);
    }
}
