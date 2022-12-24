public class OverpaymentCalculatorForHuman {
    static double calculateOverpayment(CreditData credit) {
        double overpayment = 0 - credit.credit;
        int counterMonth = 0;
        double creditCurrentHuman = RoundDouble.round(credit.credit * (1 + credit.percent / 100));
        while (creditCurrentHuman >= credit.pay) {
            counterMonth++;
            creditCurrentHuman -= credit.pay;
            overpayment += credit.pay;
            if (counterMonth == 12) {
                counterMonth = 0;
                creditCurrentHuman = RoundDouble.round(creditCurrentHuman * (1 + credit.percent / 100));
            }
        }
        overpayment += creditCurrentHuman;
        return RoundDouble.round(overpayment);
    }
}

