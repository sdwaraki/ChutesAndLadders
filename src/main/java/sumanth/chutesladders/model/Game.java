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
                int currentPosition = currentPlayer.getCurrentPosition().getValue() + spinVal;

                if (currentPosition == 100) {
                    hasWinnerBeenFound = true;
                    System.out.println(currentPlayer.getName() + ":" + currentPlayer.getCurrentPosition() + " ----> " + currentPosition);
                    System.out.println("Winner found ---> " + currentPlayer.getName());
                    break;
                }

                if (currentPosition > 100) {
                    System.out.println(currentPlayer.getName() + " is at position " + currentPlayer.getCurrentPosition() + " and spun a " + spinVal + "...needs to wait for another turn as count was over 100");
                    continue;
                }

                Cell c = board.getCells().stream().filter(cell -> cell.getValue() == currentPosition).findFirst().get();

                if (c instanceof Chute) {
                    System.out.println(currentPlayer.getName() + ":" + currentPlayer.getCurrentPosition() + " -----> " + currentPosition + " ---Chute----> " + ((Chute) c).getEndPosition());
                    currentPlayer.setCurrentPosition(((Chute) c).getEndPosition());
                    continue;
                }

                if (c instanceof Ladder) {
                    System.out.println(currentPlayer.getName() + ":" + currentPlayer.getCurrentPosition() + " -----> " + currentPosition + " ---Ladder ----> " + ((Ladder) c).getEndPosition());
                    currentPlayer.setCurrentPosition(((Ladder) c).getEndPosition());
                    continue;
                }

                System.out.println(currentPlayer.getName() + ":" + currentPlayer.getCurrentPosition() + " ----> " + currentPosition);
                currentPlayer.setCurrentPosition(c);

            }

        }

    }

    private Board makeBoard() {

        List<Cell> cells = new ArrayList<>();

       //Add the chutes
        List<Chute> chutes = new ArrayList<>();
        chutes.add(new Chute(new Cell(19), new Cell(9)));
        chutes.add(new Chute(new Cell(24), new Cell(11)));
        chutes.add(new Chute(new Cell(44), new Cell(20)));
        chutes.add(new Chute(new Cell(61), new Cell(48)));
        chutes.add(new Chute(new Cell(77), new Cell(68)));
        chutes.add(new Chute(new Cell(96), new Cell(81)));

        //Add the ladders
        List<Ladder> ladders = new ArrayList<>();
        ladders.add(new Ladder(new Cell(7), new Cell(21)));
        ladders.add(new Ladder(new Cell(27), new Cell(46)));
        ladders.add(new Ladder(new Cell(34), new Cell(52)));
        ladders.add(new Ladder(new Cell(46), new Cell(66)));
        ladders.add(new Ladder(new Cell(71), new Cell(86)));
        ladders.add(new Ladder(new Cell(79), new Cell(94)));


        for (int i = 1; i <= 100; i++) {
            
            for(Chute ch : chutes) {
                if(ch.getStartPosition().getValue() == i) {
                    cells.add(ch);
                    cells.add(ch.getEndPosition());
                    break;
                }
            }
            
            for(Ladder ld: ladders) {
                if(ld.getStartPosition().getValue() == i) {
                    cells.add(ld);
                    cells.add(ld.getEndPosition());
                    break;
                }
            }

            cells.add(new Cell(i));
        }

        Board board = new Board(cells);

        return board;
    }

    public static void main(String args[]) {

        //Create players
        Player player1 = new Player("Eric");
        Player player2 = new Player("Hanna");
        Player player3 = new Player("Jim");
        Player player4 = new Player("Amy");


        List<Player> players = new ArrayList<>();
        players.add((player1));
        players.add(player2);
        players.add(player3);
        players.add(player4);

        Game game = new Game(players);

        //Start the game
        game.startGame();
    }

}
