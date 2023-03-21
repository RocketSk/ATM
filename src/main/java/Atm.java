import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class Atm {
    private static final BigDecimal ZERO = BigDecimal.ZERO;
    private static final BigDecimal THOUSAND = BigDecimal.valueOf(1000);
    private static final Object LOCK = new Object();

    public void withdrawFromBalance(@NotNull Card card, BigDecimal amount) {
        cardValidation(card);
        synchronized (LOCK) {
            if (card.balance.get().compareTo(ZERO) > 0) {
                BigDecimal oldBalance = card.balance.get();
                BigDecimal newBalance = oldBalance.add(amount);
                card.balance.compareAndSet(oldBalance, newBalance);
                System.out.println(Thread.currentThread().getName() +
                        " withdraw :" + amount + "$, the balance is = " +
                        card.balance.get());
            } else {
                card.isStop.set(true);
                System.out.println("Card balance less then zero, please refill you balance");
            }
        }
    }

    public void balanceRefill(@NotNull Card card, BigDecimal amount) {
        cardValidation(card);
        synchronized (LOCK) {
            if (card.balance.get().compareTo(THOUSAND) < 0) {
                BigDecimal oldBalance = card.balance.get();
                BigDecimal newBalance = oldBalance.subtract(amount);
                card.balance.compareAndSet(oldBalance, newBalance);
                System.out.println(Thread.currentThread().getName() +
                        " replenished by:" + amount + "$, the balance is = " +
                        card.balance.get());
            } else {
                card.isStop.set(true);
                System.out.println("Card balance is full");
            }
        }
    }

    private void cardValidation(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Card is null");
        }
    }
}
