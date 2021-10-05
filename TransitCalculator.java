import java.util.Arrays;

public class TransitCalculator {

  //Instance Fields
    private double numOfDays = 0;
    private double numOfRides = 0;
    final double payPerRide = 2.75;
    final double sevenDayUnlimited = 33.00;
    final double thirtyDayUnlimited = 127.00;

  //Constructor for TransitCalculator class
    TransitCalculator(int numOfDays, int numOfRides) {
        this.numOfDays = numOfDays;
        this.numOfRides = numOfRides;
    }

  //Method for calculating overall price per ride
    public double unlimited7Price() {
        double overAllPrice = 0;
        overAllPrice = ((Math.ceil(numOfDays / 7) * sevenDayUnlimited) / numOfRides);

        return overAllPrice;
    }

  //Method for getting the ride prices
    public double[] getRidePrices() {
        double perRide = numOfRides * payPerRide;
        double sevenDay = unlimited7Price();
        double thirtyDay = thirtyDayUnlimited / numOfRides;
        double[] s = new double[]{perRide, sevenDay, thirtyDay};

        return s;
    }

  //String method for calculating the best fare
    public String getBestFare(double s[]) {
        double holder = s[0];
        for (int i = 0; i < s.length; i++) {
        if (holder > s[i]) {
            holder = s[i];
        }
        }
        if (holder == s[0]) {
            System.out.println("You should get the Pay-Per-Ride option at ");
        }
        if (holder == s[1]) {
            System.out.println("You should get the 7-Day Unlimited option at ");
        }
        if (holder == s[2]) {
            System.out.println("You should get the 30-Day Unlimited option at ");
        } 

        String bestFare = "$" + String.valueOf(holder) + " per ride";

    return bestFare;
    }

  //Driver Code
    public static void main(String[] args) {
        TransitCalculator myTrip = new TransitCalculator(19, 20);
        System.out.println(Arrays.toString(myTrip.getRidePrices()));
        double[] arr = myTrip.getRidePrices();
        System.out.println(myTrip.getBestFare(arr));
    }
}
