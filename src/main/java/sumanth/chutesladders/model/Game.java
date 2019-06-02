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

    private List<Player> playerNames;

    private Board board;

    public Game(List<Player> playerNames) {
        this.playerNames = playerNames;
        this.board = makeBoard();
    }

    private void startGame() {
        Spinner spinner = new Spinner();
        boolean hasWinnerBeenFound = false;

        //Keep playing until the winner has been found.
        while(!hasWinnerBeenFound) {

            for(int i = 0; i< playerNames.size(); i++) {
                Player currentPlayer = playerNames.get(i);
                int currentPosition = currentPlayer.getCurrentPosition() + spinner.spin();

                if(currentPosition == 100) {
                    hasWinnerBeenFound = true;
                    System.out.println(currentPlayer.getName() + ":" + currentPlayer.getCurrentPosition() + " ----> " + currentPosition);
                    System.out.println("Winner found ---> " + currentPlayer.getName());
                    break;
                }

                if(currentPosition > 100) {
                    continue;
                }

                Optional<Chute> ch = board.getChutes().stream().filter(chute -> chute.getStartPosition() == currentPosition).findAny();
                if(ch.isPresent()) {
                    System.out.println(currentPlayer.getName() + ":" + currentPlayer.getCurrentPosition()+" -----> "+currentPosition + " ---Chute----> " + ch.get().getEndPosition());
                    currentPlayer.setCurrentPosition(ch.get().getEndPosition());
                    continue;
                }

                Optional<Ladder> lr = board.getLadders().stream().filter(ladder -> ladder.getStartPosition() == currentPosition).findAny();
                if(lr.isPresent()) {
                    System.out.println(currentPlayer.getName() + ":" + currentPlayer.getCurrentPosition() +" -----> "+currentPosition +  " ---Ladder ----> " + lr.get().getEndPosition());
                    currentPlayer.setCurrentPosition(lr.get().getEndPosition());
                    continue;
                }
                System.out.println(currentPlayer.getName() + ":" + currentPlayer.getCurrentPosition() + " ----> " + currentPosition);
                currentPlayer.setCurrentPosition(currentPosition);

            }

        }

    }

    private Board makeBoard() {

        Board board = new Board();

        //Add the chutes
        List<Chute> chutes = new ArrayList<>();
        chutes.add(new Chute(20, 10));
        chutes.add(new Chute(25, 12));
        chutes.add(new Chute(45, 20));
        chutes.add(new Chute(62, 49));
        chutes.add(new Chute(80, 69));
        chutes.add(new Chute(97, 82));

        //Add the ladders
        List<Ladder> ladders = new ArrayList<>();
        ladders.add(new Ladder(8, 22));
        ladders.add(new Ladder(28, 47));
        ladders.add(new Ladder(35, 53));
        ladders.add(new Ladder(47, 67));
        ladders.add(new Ladder(72, 87));
        ladders.add(new Ladder(80,95));

        board.setChutes(chutes);
        board.setLadders(ladders);

        return board;
    }

    public static void main(String args[]) {

        //Create players
        Player player1 = new Player("Eric");
        Player player2 = new Player("Hanna");
        Player player3 = new Player("Jim");
        Player player4 = new Player("Amy");


        List<Player> playerNames = new ArrayList<>();
        playerNames.add((player1));
        playerNames.add(player2);
        playerNames.add(player3);
        playerNames.add(player4);

        Game game = new Game(playerNames);

        //Start the game
        game.startGame();
    }

}
