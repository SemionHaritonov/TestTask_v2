import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditCalculator {
    public static double calculateCredit(CreditData credit) {
        double overpayment = 0 - credit.credit;
        int counterMonth = 0;
        switch (credit.type) {
            case "human":
                double creditCurrentHuman = round(credit.credit * (1 + credit.percent / 100));
                while (creditCurrentHuman >= credit.pay) {
                    counterMonth++;
                    creditCurrentHuman -= credit.pay;
                    overpayment += credit.pay;
                    if (counterMonth == 12) {
                        counterMonth = 0;
                        creditCurrentHuman = round(creditCurrentHuman * (1 + credit.percent / 100));
                    }
                }
                overpayment += creditCurrentHuman;
                break;
            case "business":
                double creditCurrentBusiness = round(credit.credit * 1);
                while (creditCurrentBusiness >= credit.pay) {
                    counterMonth++;
                    creditCurrentBusiness -= credit.pay;
                    overpayment += credit.pay;
                    if (counterMonth == 12) {
                        counterMonth = 0;
                        creditCurrentBusiness = round(creditCurrentBusiness * (1 + credit.percent / 100));
                    }
                }
                overpayment += creditCurrentBusiness;
                break;
        }
        credit.overpayment = overpayment;
        return overpayment;
    }

    private static double round(double value) {
        int places = 2;     //Копейка - сотая рубля
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
