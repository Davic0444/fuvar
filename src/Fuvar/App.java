package Fuvar;

public class App {
    public static void main(String[] args) {
        Task taskObj = new Task();
        taskObj.fileRead("fuvar.csv");

        // 3. feladat
        System.out.println(taskObj.howManyRide());

        // 4. feladat
        taskObj.id6185IncomeAndRides();

        // 5. feladat
        taskObj.paymentMethodUsage();

        // 6. feladat
        taskObj.ridesTraveledDistance();

        // 7. feladat
        taskObj.longestDistanceRide();

        // 8. feladat
        taskObj.wrongDataFileCreate();


    }
}
