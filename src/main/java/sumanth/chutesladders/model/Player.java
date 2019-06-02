package sumanth.chutesladders.model;

public class Player {

    private String name;

    private int currentPosition;

    public Player(String name) {
        this.name = name;
        this.currentPosition = -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
