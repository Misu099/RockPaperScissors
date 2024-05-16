import java.util.Random;
import java.util.Scanner;

public class Game {

    private String userChoice = " ";
    private String computerChoice = " ";
    private String winner;
    private final String[] choices = {"Rock", "Paper", "Scissors"};
    private boolean playAgain = true;
    private int wins;
    private int loses;
    private int draws;
    private float wrRatio;

    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    private void getUserChoice() {
        System.out.print("User choose: ");
        while (!(userChoice.equalsIgnoreCase("rock")) && !(userChoice.equalsIgnoreCase("paper"))
                && !(userChoice.equalsIgnoreCase("scissors"))) {
            userChoice = scanner.nextLine().trim();
        }
    }

    private void getComputerChoice() {
        computerChoice = choices[random.nextInt(3)];
    }

    public void play() {
        while (playAgain) {

            getUserChoice();
            getComputerChoice();

            if ((computerChoice.equalsIgnoreCase("rock") && userChoice.equalsIgnoreCase("scissors"))
                    || (computerChoice.equalsIgnoreCase("paper") && userChoice.equalsIgnoreCase("rock")) ||
                    (computerChoice.equalsIgnoreCase("scissors") && userChoice.equalsIgnoreCase("paper"))) {
                winner = "Computer";
                loses++;
            } else if (computerChoice.equalsIgnoreCase(userChoice)) {
                winner = "Draw";
                draws++;
            } else {
                winner = "User";
                wins++;
            }

            if (wins == 0) {
                wrRatio = 0;
            } else if (loses == 0) {
                wrRatio = wins;
            } else {
                wrRatio = (float) wins / loses;
            }

            showResult();

            System.out.println("Play again? (YES for it, anything else to exit)");
            if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
                playAgain = true;
                userChoice = "";
            } else {
                playAgain = false;
                scanner.close();
            }
        }
    }

    private void showResult() {
        System.out.println("User chosen " + userChoice + " and computer " + computerChoice + ".");
        System.out.println("Winner:" + winner);
        System.out.println("WINS:" + wins + " LOSES:" + loses + " DRAWS:" + draws);
        System.out.println("             W/R RATION:" + wrRatio);
    }

}
