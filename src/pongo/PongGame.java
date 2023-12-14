package pongo;

import java.io.IOException;
import java.util.Scanner;

public class PongGame {

    public static void main(String[] args) {
        PongGame pongGame = new PongGame();
        pongGame.startGame();
    }

    private void startGame() {
        PongBoard board = new PongBoard();
        board.initializeBoard();

        int playerScore = 0;
        int opponentScore = 0;

        Scanner scanner = new Scanner(System.in);

        while (playerScore < 10 && opponentScore < 10) {
            board.moveBall();
            board.moveOpponentPaddle(); // Controlado por una IA simple
            board.printBoard();

            System.out.println("Score: Player " + playerScore + " - " + opponentScore + " Opponent");

            System.out.print("Enter your move (W/S to move up/down, Q to quit): ");
            char move = scanner.hasNext() ? scanner.next().charAt(0) : ' '; // Leemos el próximo carácter o asignamos espacio si no hay entrada

            // Controlar las paletas con las teclas correspondientes
            switch (move) {
                case 'W':
                case 'w':
                    board.movePaddleUp();
                    break;
                case 'S':
                case 's':
                    board.movePaddleDown();
                    break;
                case 'Q':
                case 'q':
                    System.out.println("Game over. Thanks for playing!");
                    System.exit(0);
                    break;
            }

            // Comprobar si se anota un gol
            if (board.checkGoal()) {
                if (board.getLastScorer() == 'P') {
                    playerScore++;
                } else if (board.getLastScorer() == 'O') {
                    opponentScore++;
                }

                // Reiniciar la posición de la pelota
                board.initializeBall();
            }

            clearScreen();
        }

        // Imprimir el resultado final
        System.out.println("Final Score: Player " + playerScore + " - " + opponentScore + " Opponent");
        System.out.println("Game over. Thanks for playing!");
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
