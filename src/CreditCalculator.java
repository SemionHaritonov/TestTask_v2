public class CreditCalculator {
    public static double calculateCredit(CreditData credit) {
        credit.overpayment = -1;
        switch (credit.type) {
            case "human":
                credit.overpayment = OverpaymentCalculatorForHuman.calculateOverpayment(credit);
                break;
            case "business":
                credit.overpayment = OverpaymentCalculatorForBusiness.calculateOverpayment(credit);
                break;
        }
        return credit.overpayment;
    }
}
