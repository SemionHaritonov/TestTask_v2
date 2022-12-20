public class CreditDataWrite {
    static void writeData(CreditData credit, String[] inputData) throws Exception {
        try {
            credit.credit = Double.parseDouble(inputData[0]);
            credit.pay = Double.parseDouble(inputData[1]);
            credit.percent = Double.parseDouble(inputData[2]);
            credit.type = inputData[3].trim();
            if (credit.credit <= 0 || credit.pay <= 0 || credit.percent < 0) {
                throw new Exception("incorrect input numerical data");
            }
            if (!(credit.type.equals("business") || credit.type.equals("human"))) {
                throw new Exception("incorrect credit type");
            }
            if (credit.type.equals("human") && credit.credit * (1 + credit.percent / 100) - 12 * credit.pay > 0 &&
                    ((credit.credit * (1 + credit.percent / 100) - 12 * credit.pay) * (1 + credit.percent / 100)) >= credit.credit) {
                throw new Exception("impossible to pay");
            }
            if (credit.type.equals("business") && credit.credit - 12 * credit.pay > 0 &&
                    ((credit.credit - 12 * credit.pay) * (1 + credit.percent)) >= credit.credit) {
                throw new Exception("impossible to pay");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
