package sumanth.chutesladders.model;

/**
 *
 * Ladders - has start and end position as members
 * If ladders were taken as a part of the input, we need some validation to check
 *  start and end position values.
 */
public class Ladder extends Cell {

    private Cell startPosition;

    private Cell endPosition;

    public Ladder(Cell startPosition, Cell endPosition) {
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
