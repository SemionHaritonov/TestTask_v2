public class Main {
    public static void main(String[] args) throws Exception {
        CreditData credit = new CreditData();
        CreditDataWrite.writeData(credit, CreditInput.inputData());
        System.out.println(CreditCalculator.calculateCredit(credit));
    }
}