package sumanth.chutesladders.model;

/**
 *
 * Class to represent chutes.
 * Has start and end position as its members.
 * If chutes were taken as a part of the input, we need some validation to check
 * start and end position values.
 *
 */
public class Chute {

    private int startPosition;

    private int endPosition;

    public Chute(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }
}
