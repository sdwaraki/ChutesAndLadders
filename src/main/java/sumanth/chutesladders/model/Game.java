package sumanth.chutesladders.model;

import sumanth.chutesladders.utils.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * A game needs to create a board before it can be started. It consists of a bunch of playernames and board.
 * It also consists of functions that create the board and handle the logic to play the game itself.
 *
 */
public class Game {

    private List<Player> players;

    private Board board;

    public Game(List<Player> players) {
        this.players = players;
        this.board = makeBoard();
    }

    private void startGame() {
        Spinner spinner = new Spinner();
        boolean hasWinnerBeenFound = false;

        //Keep playing until the winner has been found.
        while (!hasWinnerBeenFound) {

            for (int i = 0; i < players.size(); i++) {
                Player currentPlayer = players.get(i);
                Integer spinVal = spinner.spin();
                int nextPosition = currentPlayer.getCurrentPosition().getValue() + spinVal;

                if (nextPosition > 100) {
                    System.out.println(currentPlayer.getName() + " is at position " + currentPlayer.getCurrentPosition()
                            + " and spun a " + spinVal + "...needs to wait for another turn as count was over 100");
                    continue;
                }

                Cell c = board.getCells().stream().filter(cell -> cell.getValue() == nextPosition).findFirst().get();

                if (c instanceof Chute) {
                    System.out.println(currentPlayer.getName() + ":" + currentPlayer.getCurrentPosition() + " -----> "
                            + nextPosition + " ---Chute----> " + ((Chute) c).getEndPosition());
                    currentPlayer.setCurrentPosition(((Chute) c).getEndPosition());
                    continue;
                }

                if (c instanceof Ladder) {
                    System.out.println(currentPlayer.getName() + ":" + currentPlayer.getCurrentPosition() + " -----> "
                            + nextPosition + " ---Ladder ----> " + ((Ladder) c).getEndPosition());
                    currentPlayer.setCurrentPosition(((Ladder) c).getEndPosition());
                    continue;
                }

                if (nextPosition == 100) {
                    hasWinnerBeenFound = true;
                    System.out.println(currentPlayer.getName() + ":" + currentPlayer.getCurrentPosition()
                            + " ----> " + nextPosition);
                    System.out.println("Winner found ---> " + currentPlayer.getName());
                    break;
                }

                System.out.println(currentPlayer.getName() + ":" + currentPlayer.getCurrentPosition() + " ----> "
                        + nextPosition);
                currentPlayer.setCurrentPosition(c);

            }

        }

    }

    /**
     *
     * Cells have their value and they will be referenced through their value and not through their index in
     * the list cells. Cells can also be chutes or ladders.
     *
     * @return
     */
    private Board makeBoard() {

        List<Cell> cells = new ArrayList<>();

       //Create chutes
        List<Chute> chutes = new ArrayList<>();
        chutes.add(new Chute(new Cell(98), new Cell(78)));
        chutes.add(new Chute(new Cell(95), new Cell(75)));
        chutes.add(new Chute(new Cell(93), new Cell(73)));
        chutes.add(new Chute(new Cell(87), new Cell(24)));
        chutes.add(new Chute(new Cell(64), new Cell(60)));
        chutes.add(new Chute(new Cell(62), new Cell(19)));
        chutes.add(new Chute(new Cell(56), new Cell(53)));
        chutes.add(new Chute(new Cell(47), new Cell(26)));
        chutes.add(new Chute(new Cell(49), new Cell(11)));
        chutes.add(new Chute(new Cell(16), new Cell(6)));

        //Create ladders
        List<Ladder> ladders = new ArrayList<>();
        ladders.add(new Ladder(new Cell(1), new Cell(38)));
        ladders.add(new Ladder(new Cell(4), new Cell(14)));
        ladders.add(new Ladder(new Cell(9), new Cell(31)));
        ladders.add(new Ladder(new Cell(21), new Cell(42)));
        ladders.add(new Ladder(new Cell(36), new Cell(44)));
        ladders.add(new Ladder(new Cell(28), new Cell(84)));
        ladders.add(new Ladder(new Cell(51), new Cell(67)));
        ladders.add(new Ladder(new Cell(71), new Cell(91)));
        ladders.add(new Ladder(new Cell(80), new Cell(100)));


        boolean ladderFound;
        boolean chuteFound;

        for (int i = 1; i <= 100; i++) {
            ladderFound = false;
            chuteFound = false;
            //Adding Chutes to the board
            for(Chute ch : chutes) {
                if(ch.getStartPosition().getValue() == i) {
                    cells.add(ch);
                    cells.add(ch.getEndPosition());
                    chuteFound = true;
                    break;
                }
            }

            //Add ladders to the board
            for(Ladder ld: ladders) {
                if(ld.getStartPosition().getValue() == i) {
                    cells.add(ld);
                    cells.add(ld.getEndPosition());
                    ladderFound = true;
                    break;
                }
            }

            //Just add the normal cells when the cell was not a chute or a ladder.
            if(!ladderFound && !chuteFound)
                cells.add(new Cell(i));
        }

        Board board = new Board(cells);

        return board;
    }

    public static void main(String args[]) {

        //Create players
        List<Player> players = new ArrayList<>();
        players.add(new Player("Eric"));
        players.add(new Player("Hanna"));
        players.add(new Player("Jim"));
        players.add(new Player("Amy"));

        Game game = new Game(players);

        //Start the game
        game.startGame();
    }

}
