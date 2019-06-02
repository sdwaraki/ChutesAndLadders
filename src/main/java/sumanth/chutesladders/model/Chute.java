package sumanth.chutesladders.model;

/**
 *
 * Class to represent chutes.
 * Has start and end position as its members.
 * If chutes were taken as a part of the input, we need some validation to check
 * start and end position values.
 *
 */
public class Chute extends Cell {

    private Cell startPosition;

    private Cell endPosition;

    public Chute(Cell startPosition, Cell endPosition) {
        super(startPosition.getValue());
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public Cell getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Cell startPosition) {
        this.startPosition = startPosition;
    }

    public Cell getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(Cell endPosition) {
        this.endPosition = endPosition;
    }

    @Override
    public String toString() {
        return String.valueOf(startPosition.getValue());
    }
}
