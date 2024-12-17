package Project3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Squidgame {

    private static final int LIVES = 3;
    private static final int PANELS = 8;
    private static final int COLS = 2;

    public static void main(String[] args) {
        Player player = new Player(LIVES);
        int[][] ladder = createLadder(PANELS);
        ArrayList<Integer> userSelections = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("|||||| ---- Start");
        printCurrentLadder(ladder, userSelections);

        for (int i = 0; i < PANELS; i++) {
            System.out.print("Choose R/r or L/l: ");
            String choice = scanner.nextLine().trim().toLowerCase();

            while (!choice.equals("r") && !choice.equals("l")) {
                System.out.print("Invalid choice. Choose R/r or L/l: ");
                choice = scanner.nextLine().trim().toLowerCase();
            }

            int selection = choice.equals("r") ? 1 : 0;
            userSelections.add(selection);

            if (ladder[i][selection] == 0) {
                player.death();
                System.out.println("You Lost 1 life");
                System.out.println("Total Lives: " + player.getLives());

                if (player.getLives() == 0) {
                    System.out.println("YOU DIED");
                    break;
                }
            }

            printCurrentLadder(ladder, userSelections);

            if (i == PANELS - 1) {
                System.out.println("Congrats You Won!!");
                printAnswerLadder(ladder);
            }
        }

        scanner.close();
    }

    private static int[][] createLadder(int panels) {
        int[][] ladder = new int[panels][COLS];
        Random random = new Random();

        for (int i = 0; i < panels; i++) {
            for (int j = 0; j < COLS; j++) {
                ladder[i][j] = random.nextInt(2);
            }
        }

        return ladder;
    }

    private static void printAnswerLadder(int[][] ladder) {
        System.out.println("|||||| ---- Start");
        for (int i = 0; i < ladder.length; i++) {
            System.out.print("|");
            for (int j = 0; j < COLS; j++) {
                System.out.print(ladder[i][j] + "||");
            }
            System.out.println("|");
        }
        System.out.println("|||||| ---- Finish");
    }

    private static void printCurrentLadder(int[][] ladder, ArrayList<Integer> userSelections) {
        System.out.println("|||||| ---- Start");
        for (int i = 0; i < ladder.length; i++) {
            System.out.print("|");
            if (i < userSelections.size()) {
                for (int j = 0; j < COLS; j++) {
                    if (j == userSelections.get(i)) {
                        System.out.print(ladder[i][j] + "||");
                    } else {
                        System.out.print(" ||");
                    }
                }
            } else {
                System.out.print("?||?");
            }
            System.out.println("|");
        }
        System.out.println("|||||| ---- Finish");
    }
}

class Player {
    private int lives;

    public Player(int lives) {
        this.lives = lives;
    }

    public int getLives() {
        return lives;
    }

    public void death() {
        lives--;
    }
}