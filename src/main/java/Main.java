import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Card card = new Card(new BigDecimal(500));
        ThreadStarting threadStarting = new ThreadStarting(card,5,5);
        threadStarting.startThreads();
    }
}