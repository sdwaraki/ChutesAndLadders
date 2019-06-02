package sumanth.chutesladders.model;

public class Player {

    private String name;

    private Cell currentPosition;

    public Player(String name) {
        this.name = name;
        this.currentPosition = new Cell(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cell getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Cell currentPosition) {
        this.currentPosition = currentPosition;
    }

}
