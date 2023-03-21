import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class Card {
    public AtomicReference<BigDecimal> balance =
            new AtomicReference();
    AtomicBoolean isStop = new AtomicBoolean();

    Card(BigDecimal balance) {
        this.balance.set(balance);
    }
}
