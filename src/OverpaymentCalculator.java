public class OverpaymentCalculator {
    static double calculateOverpayment(CreditData credit, double creditCurrent) {
        double overpayment = 0 - credit.credit;
        int counterMonth = 0;
        while (creditCurrent >= credit.pay) {
            counterMonth++;
            creditCurrent -= credit.pay;
            overpayment += credit.pay;
            if (counterMonth == 12) {
                counterMonth = 0;
                creditCurrent = RoundDouble.round(creditCurrent * (1 + credit.percent / 100));
            }
        }
        overpayment += creditCurrent;
        return RoundDouble.round(overpayment);
    }
}
