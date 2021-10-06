public class Vancouver extends TransitCalculator {

    Vancouver() {
        super(19, 20);

    }

    // Method for calculating overall price per ride
    public double unlimited7Price() {
        double overAllPrice = 0;
        overAllPrice = ((Math.ceil(numOfDays / 7) * sevenDayUnlimited) / numOfRides);

        return overAllPrice;
    }

    // Method for getting the ride prices
    public double[] getRidePrices() {
        double perRide = numOfRides * payPerRide;
        double sevenDay = unlimited7Price();
        double thirtyDay = thirtyDayUnlimited / numOfRides;
        double[] s = new double[] { perRide, sevenDay, thirtyDay };

        return s;
    }

    // String method for calculating the best fare
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

}
