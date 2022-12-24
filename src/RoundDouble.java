import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundDouble {
    static double round(double value) {
        int places = 2;     //Копейка - сотая рубля
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
