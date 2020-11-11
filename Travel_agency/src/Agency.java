import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Agency {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    TouristVoucher voucher;

    public void generateVoucher() {
        VacationType type = getTypeOfVacation();
        Transport transport = getTypeOfTransport();
        FoodTypes foodTypes = getTypeOfFood();
        int numberOfDays = getQuantityDaysOfVoucher();
        voucher = new TouristVoucher(type, transport, foodTypes, numberOfDays);
    }

    public TouristVoucher getVoucher() {
        return voucher;
    }

    private VacationType getTypeOfVacation() {
        boolean stop = false;
        int option = 0;
        do{
            System.out.println("Please enter number of desired type of vacation:");
            System.out.println("1. Rest.");
            System.out.println("2. Excursions.");
            System.out.println("3. Treatment.");
            System.out.println("4. Shopping.");
            System.out.println("5. Cruise.");
            try {
                option = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                System.out.println("Invalid data.");
            }
            if(option >= 1 && option <= 5) stop = true;
            else System.out.println("Please try again");
        } while (!stop);
        switch (option) {
            case 1 -> {
                return VacationType.REST;
            }
            case 2 -> {
                return VacationType.EXCURSIONS;
            }
            case 3 -> {
                return VacationType.TREATMENT;
            }
            case 4 -> {
                return VacationType.SHOPPING;
            }
            case 5 -> {
                return VacationType.CRUISE;
            }
        }
        return VacationType.REST;
    }
    private Transport getTypeOfTransport() {
        boolean stop = false;
        int option = 0;
        do{
            System.out.println("Please enter number of desired type of transport:");
            System.out.println("1. Air.");
            System.out.println("2. Railway.");
            System.out.println("3. Liner.");
            System.out.println("4. Bus.");
            try {
                option = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                System.out.println("Invalid data.");
            }
            if(option >= 1 && option <= 4) stop = true;
            else System.out.println("Please try again");
        } while (!stop);
        switch (option) {
            case 1 -> {
                return Transport.AIR;
            }
            case 2 -> {
                return Transport.RAILWAY;
            }
            case 3 -> {
                return Transport.LINER;
            }
            case 4 -> {
                return Transport.BUS;
            }
        }
        return Transport.AIR;
    }
    private FoodTypes getTypeOfFood() {
        boolean stop = false;
        int option = 0;
        do{
            System.out.println("Please enter number of desired type of food:");
            System.out.println("1. RO (room only).");
            System.out.println("2. BB (bed breakfast).");
            System.out.println("3. HB (half board).");
            System.out.println("4. FB (full board).");
            System.out.println("5. AI (all inclusive).");
            System.out.println("6. UAI (ultra all inclusive).");
            try {
                option = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                System.out.println("Invalid data.");
            }
            if(option >= 1 && option <= 6) stop = true;
            else System.out.println("Please try again");
        } while (!stop);
        switch (option) {
            case 1 -> {
                return FoodTypes.RO;
            }
            case 2 -> {
                return FoodTypes.BB;
            }
            case 3 -> {
                return FoodTypes.HB;
            }
            case 4 -> {
                return FoodTypes.FB;
            }
            case 5 -> {
                return FoodTypes.AI;
            }
            case 6 -> {
                return FoodTypes.UAI;
            }
        }
        return FoodTypes.AI;
    }
    private int getQuantityDaysOfVoucher() {
        int numberOfDays = 0;
        System.out.println("Please enter the number of days of the trip:");
        try {
            numberOfDays = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            System.out.println("Invalid data.");
        }
        return numberOfDays;
    }
}
