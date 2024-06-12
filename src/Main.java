import java.math.BigDecimal;

public class Main {
    private final BigDecimal defaultSum = new BigDecimal(300);
    public static void main(String[] args) {
        TourneForm form = new TourneForm();
        form.setVisible(true);
    }

    public BigDecimal getDefaultSum() {
        return defaultSum;
    }
}