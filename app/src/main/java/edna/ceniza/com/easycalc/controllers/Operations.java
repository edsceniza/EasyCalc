package edna.ceniza.com.easycalc.controllers;

/**
 * Created by Edna Ceniza on 19/07/2017.
 */

public class Operations {
    public double add(double fnum, double snum){
        double sum=0;
        sum=fnum+snum;
        return sum;
    }

    public double minus(double fnum, double snum){
        double diff=0;
        diff=fnum-snum;
        return diff;
    }

    public double times(double fnum, double snum){
        double times=0;
        times=fnum*snum;
        return times;
    }

    public double divide(double fnum, double snum){
        double quotient=0;
        quotient=fnum/snum;
        return quotient;
    }

}
