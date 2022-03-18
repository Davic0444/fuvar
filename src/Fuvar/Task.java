package Fuvar;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.*;

public class Task {

    List<Entity> ride = new ArrayList<Entity>();
    FileManager fmObj = new FileManager();

    public void fileRead(String fileName) {
        ride = fmObj.fileRead(fileName);
    }

    public Integer howManyRide() {
        return ride.size();
    }

    public void id6185IncomeAndRides() {
        int amount = 0;
        double income = 0;
        for (Entity entity : ride) {
            if (entity.getId() == 6185) {
                amount++;
                income += entity.getTravelFee() + entity.getTip();
            }
        }
        System.out.println(amount + " fuvar alatt: " + income + "$");
    }

    public void paymentMethodUsage() {
        Set<String> payment = new HashSet<>();
        for (Entity entity : ride) {
            if (!payment.contains(entity.getPaymentMethod())) {
                payment.add(entity.getPaymentMethod());
            }
        }
        for (String s : payment) {
            int paymentUsage = 0;
            for (Entity entity : ride) {
                if (entity.getPaymentMethod().equals(s)) {
                    paymentUsage++;
                }
            }
            System.out.println(s + ": " + paymentUsage + " fuvar");
        }
    }

    public void ridesTraveledDistance(){
        DecimalFormat df = new DecimalFormat("0.00");
        double sumdis = ride.stream().mapToDouble(x -> x.getDistance()).sum();
        System.out.println(df.format(sumdis*1.6)+ " km");
    }

    public void longestDistanceRide(){
        int longest = Integer.MIN_VALUE;
        int longestIndex = 0;
        for (int i = 0; i < ride.size(); i++) {
            if (ride.get(i).getTime()>longest){
                longest = ride.get(i).getTime();
                longestIndex = i;
            }
        }
        System.out.println("Fuvar hossza: "+ride.get(longestIndex).getTime()+ " másodperc");
        System.out.println(("Taxi azonosító: "+ride.get(longestIndex).getId()));
        System.out.println("Megtett távolság: "+ride.get(longestIndex).getDistance()+" km");
        System.out.println("Viteli díj: "+ride.get(longestIndex).getTravelFee()+"$");
    }

    public void wrongDataFileCreate(){
        try {
            PrintWriter pr = new PrintWriter(new FileWriter("hibak.txt"));
            pr.print(fmObj.header+"\n");
            ride.sort(Comparator.comparing(x-> {
                return x.getStart();
            }));
            for (Entity entity : ride) {
                if (entity.getTime()>0 && entity.getTravelFee() >0 && entity.getDistance()==0){
                    pr.println(entity.getId()+";"+entity.getStart()+";"+entity.getTime()+";"+entity.getDistance()+";"+entity.getTravelFee()+";"+entity.getTip()+";"+entity.getPaymentMethod());
                }
            }
            pr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("hibak.txt létrehozva");
    }

}
