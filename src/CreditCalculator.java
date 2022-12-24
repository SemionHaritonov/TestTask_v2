public class CreditCalculator {
    public static double calculateCredit(CreditData credit) {
        credit.overpayment = -1;
        double creditCurrent = 0;
        switch (credit.type) {
            case "human":
                creditCurrent = RoundDouble.round(credit.credit * (1 + credit.percent / 100));
                break;
            case "business":
                creditCurrent = RoundDouble.round(credit.credit * 1);
                break;
        }
        credit.overpayment = OverpaymentCalculator.calculateOverpayment(credit, creditCurrent);
        return credit.overpayment;
    }
}
