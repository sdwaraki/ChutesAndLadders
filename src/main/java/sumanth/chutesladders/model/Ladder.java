package sumanth.chutesladders.model;

/**
 *
 * Ladders - has start and end position as members
 * If ladders were taken as a part of the input, we need some validation to check
 *  start and end position values.
 */
public class Ladder {

    private int startPosition;

    private int endPosition;

    public Ladder(int startPosition, int endPosition) {
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
