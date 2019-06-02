package sumanth.chutesladders.utils;

import java.util.Random;

public class Spinner {

    private final Random random;

    public Spinner() {
        random = new Random();
    }

    public Integer spin() {
        Integer spinCount = random.nextInt(6) + 1;
        return spinCount;
    }
}
