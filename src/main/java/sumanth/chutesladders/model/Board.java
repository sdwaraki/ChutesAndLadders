package sumanth.chutesladders.model;

import java.util.List;


/**
 *
 * Board comprises of chutes and ladders. A player's current position is associated with the player.
 * Another implementation would be to make sure that the board also provides different locations/squares and
 * associate a square as the current position to the player. Same must be done for chutes and ladders too where
 * they might end up having starting sqaure and ending square.
 */
public class Board {

    private List<Chute> chutes;

    private List<Ladder> ladders;

    public List<Chute> getChutes() {
        return chutes;
    }

    public void setChutes(List<Chute> chutes) {
        this.chutes = chutes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

}
