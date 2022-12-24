public class OverpaymentCalculatorForBusiness {
    static double calculateOverpayment(CreditData credit) {
        double overpayment = 0 - credit.credit;
        int counterMonth = 0;
        double creditCurrentBusiness = RoundDouble.round(credit.credit * 1);
        while (creditCurrentBusiness >= credit.pay) {
            counterMonth++;
            creditCurrentBusiness -= credit.pay;
            overpayment += credit.pay;
            if (counterMonth == 12) {
                counterMonth = 0;
                creditCurrentBusiness = RoundDouble.round(creditCurrentBusiness * (1 + credit.percent / 100));
            }
        }
        overpayment += creditCurrentBusiness;
        return RoundDouble.round(overpayment);
    }
}
