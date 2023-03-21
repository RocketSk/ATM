import java.math.BigDecimal;
import java.util.Random;

public class MoneyConsumer implements Runnable {
    private final Card card;
    private final Atm atm = new Atm();

    MoneyConsumer(Card card) {
        this.card = card;
    }

    @Override
    public void run() {
        while (!card.isStop.get()) {
            if (Thread.currentThread().isInterrupted() || card.isStop.get()) {
                return;
            }
            atm.withdrawFromBalance(card, countTheAmount());
            try {
                Thread.sleep(countTheTime());
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    private BigDecimal countTheAmount() {
        int min = 25;
        int max = 50;
        int diff = max - min;
        Random random = new Random();
        return new BigDecimal(random.nextInt(diff + 1) + min);
    }

    private int countTheTime() {
        int min = 500;
        int max = 1500;
        int diff = max - min;
        Random random = new Random();
        return random.nextInt(diff + 1) + min;
    }
}
