import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadStarting {
    private final int countOfProducerATM;
    private final int countOfConsumerATM;
    private final ExecutorService executorService;
    private final Card card;

    ThreadStarting(Card card, int countOfProducerATM, int countOfConsumerATM) {
        this.card = card;
        this.countOfProducerATM = countOfProducerATM;
        this.countOfConsumerATM = countOfConsumerATM;
        executorService = Executors.newFixedThreadPool(countOfProducerATM + countOfConsumerATM);
    }

    public void startThreads() {
        for (int i = 0; i < countOfProducerATM; i++) {
            executorService.execute(new MoneyProducer(card));
        }
        for (int i = 0; i < countOfConsumerATM; i++) {
            executorService.execute(new MoneyConsumer(card));
        }
        executorService.shutdown();
    }
}