public class Main {
    public static void main(String[] args) {
        CreditData credit = new CreditData();
        try {
            CreditDataWrite.writeData(credit, CreditInput.inputData());
            System.out.println(CreditCalculator.calculateCredit(credit));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}