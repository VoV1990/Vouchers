public class Main {
    public static void main(String[] args) {
        Agency travelAgency = new Agency();
        travelAgency.generateVoucher();
        System.out.println(travelAgency.getVoucher());
    }
}
