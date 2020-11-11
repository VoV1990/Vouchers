import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TouristVoucher {
    private VacationType type;
    private Transport transport;
    private FoodTypes foodTypes;
    private int numberOfDays;
    private static String[]offers;

    public TouristVoucher(VacationType type, Transport transport, FoodTypes foodTypes, int numberOfDays) {
        this.type = type;
        this.transport = transport;
        this.foodTypes = foodTypes;
        this.numberOfDays = numberOfDays;
        getCountries();
    }

    private void getCountries() {
        if(numberOfDays >= 5 && numberOfDays <= 30) {
            String[] vacationTypes = type.getVacationType();
            String[] typeOfTransport = transport.getTransport();
            String[] typeOfFood = foodTypes.getFoodTypes();
            List<String> list = new ArrayList<>();
            for (String vacation : vacationTypes) {
                for (String transport : typeOfTransport) {
                    for (String food : typeOfFood) {
                        if (vacation.equals(transport) && transport.equals(food))
                            list.add(vacation);
                    }
                }
            }
            offers = list.toArray(new String[0]);
        }
        else offers = null;
        generateDates();
    }

    private void generateDates() {
        Random random = new Random();
        Calendar calendar;
        DateFormat df = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        String date;
        int month;
        int day;
        for(int i = 0; i < offers.length; i++) {
            calendar = Calendar.getInstance();
            month = random.nextInt(10);
            day = random.nextInt(28);
            calendar.add(Calendar.MONTH, + month);
            calendar.add(Calendar.DAY_OF_MONTH, +day);
            date = df.format(calendar.getTime());
            offers[i] = offers[i] + ": " + date;
        }
    }

    public VacationType getType() {
        return type;
    }

    public Transport getTransport() {
        return transport;
    }

    public FoodTypes getFoodTypes() {
        return foodTypes;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public String[] getOffers() {
        return offers;
    }

    @Override
    public String toString() {
        String offer;
        if(offers != null && offers.length > 0) offer = Arrays.toString(offers);
        else offer = "Sorry, but there are no offers for your request.";
        return "Tourist voucher:\n" +
                "type: " + type +
                ", transport: " + transport +
                ", foodTypes: " + foodTypes +
                ", numberOfDays: " + numberOfDays +
                "\noffers(country and the nearest date of departure):\n" + offer;
    }
}
enum VacationType {
    REST("Turkey", "Spain", "Italy", "Egypt", "Bulgaria", "Greece",
            "Thailand", "Montenegro"),
    EXCURSIONS("Czech", "France", "Austria", "Great Britain", "Germany", "Israel",
            "India", "Netherlands", "China", "Poland"),
    TREATMENT("Czech", "USA", "Austria", "Turkey", "Germany", "Israel",
            "Spain", "South Korea", "China", "Canada"),
    SHOPPING("Italy", "France", "USA", "Spain", "Germany", "United arab emirates",
            "Turkey", "Sweden", "China", "Poland"),
    CRUISE("Mediterranean sea", "Northern Europe", "Caribbean",
            "Persian Gulf", "Southeast Asia");
    String[]vacationType;

    VacationType(String...vacationType) {
        this.vacationType = vacationType;
    }

    public String[] getVacationType() {
        return vacationType;
    }
}
enum Transport {
    AIR("Turkey", "Spain", "Italy", "Egypt", "Bulgaria", "Greece",
            "Thailand", "Montenegro", "Czech", "France", "Austria", "Great Britain", "Germany",
            "Israel", "India", "Netherlands", "China", "Poland", "USA", "South Korea", "Canada",
            "United arab emirates", "Sweden"),
    RAILWAY("Turkey", "Spain", "Italy", "Bulgaria", "Montenegro", "Czech", "France", "Austria",
            "Great Britain", "Germany", "Israel", "Netherlands", "Poland", "Sweden"),
    LINER("Turkey", "Spain", "Italy", "Egypt", "Bulgaria", "Greece",
            "Montenegro", "France", "Great Britain", "Israel", "India", "China",
            "USA", "South Korea", "Canada", "United arab emirates",
            "Mediterranean sea", "Northern Europe", "Caribbean",
            "Persian Gulf", "Southeast Asia"),
    BUS("Spain", "Italy", "Bulgaria", "Greece", "Montenegro", "Czech", "France", "Austria",
            "Great Britain", "Germany", "Israel", "Netherlands", "Poland", "Sweden", "Poland");
    String[]transport;

    Transport(String...transport) {
        this.transport = transport;
    }

    public String[] getTransport() {
        return transport;
    }
}
enum FoodTypes {
    RO("Turkey", "Spain", "Italy", "Egypt", "Bulgaria", "Greece",
            "Thailand", "Montenegro", "Czech", "France", "Austria", "Great Britain", "Germany",
            "Israel", "India", "Netherlands", "China", "Poland", "USA", "South Korea", "Canada",
            "United arab emirates", "Sweden"),
    BB("Turkey", "Spain", "Italy", "Egypt", "Bulgaria", "Greece",
            "Thailand", "Montenegro", "Czech", "France", "Austria", "Great Britain", "Germany",
            "Israel", "India", "Netherlands", "China", "Poland", "USA", "South Korea", "Canada",
            "United arab emirates", "Sweden", "Mediterranean sea", "Northern Europe", "Caribbean",
            "Persian Gulf", "Southeast Asia"),
    HB("Turkey", "Spain", "Italy", "Egypt", "Bulgaria", "Greece",
            "Thailand", "Montenegro", "Czech", "France", "Austria", "Great Britain", "Germany",
            "Israel", "India", "Netherlands", "China", "Poland", "USA", "South Korea", "Canada",
            "United arab emirates", "Sweden", "Mediterranean sea", "Northern Europe", "Caribbean",
            "Persian Gulf", "Southeast Asia"),
    FB("Turkey", "Spain", "Italy", "Egypt", "Bulgaria", "Greece",
            "Thailand", "Montenegro", "Czech", "France", "Austria", "Great Britain", "Germany",
            "Israel", "India", "Netherlands", "China", "Poland", "USA", "South Korea", "Canada",
            "United arab emirates", "Sweden", "Mediterranean sea", "Northern Europe", "Caribbean",
            "Persian Gulf", "Southeast Asia"),
    AI("Turkey", "Spain", "Italy", "Egypt", "Bulgaria", "Greece",
            "Thailand", "Montenegro", "Czech", "France", "Austria", "Great Britain", "Germany",
            "Israel", "India", "Netherlands", "China", "Poland", "USA", "South Korea", "Canada",
            "United arab emirates", "Sweden", "Mediterranean sea", "Northern Europe", "Caribbean",
            "Persian Gulf", "Southeast Asia"),
    UAI("Turkey", "Spain", "Italy", "Egypt", "Bulgaria", "Greece",
            "Thailand", "Montenegro", "Czech", "France", "Austria", "Great Britain", "Germany",
            "Israel", "India", "Netherlands", "China", "Poland", "USA", "South Korea", "Canada",
            "United arab emirates", "Sweden", "Mediterranean sea", "Northern Europe", "Caribbean",
            "Persian Gulf", "Southeast Asia");
    String[]foodTypes;

    FoodTypes(String... foodTypes) {
        this.foodTypes = foodTypes;
    }

    public String[] getFoodTypes() {
        return foodTypes;
    }
}
