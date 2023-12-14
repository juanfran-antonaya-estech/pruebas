package pongo;

import java.io.IOException;

public class PongBoard {

    private static final int BOARD_WIDTH = 50;
    private static final int BOARD_HEIGHT = 10;

    private int ballX;
    private int ballY;
    private int ballSpeedX;
    private int ballSpeedY;

    private int playerPaddleY;
    private int opponentPaddleY;

    public void initializeBoard() {
        ballX = BOARD_WIDTH / 2;
        ballY = BOARD_HEIGHT / 2;
        ballSpeedX = 1; // Velocidad de la pelota en el eje X
        ballSpeedY = 1; // Velocidad de la pelota en el eje Y

        playerPaddleY = BOARD_HEIGHT / 2;
        opponentPaddleY = BOARD_HEIGHT / 2;
    }

    public void printBoard() {
        char[][] board = new char[BOARD_HEIGHT][BOARD_WIDTH];

        // Inicializar el tablero con espacios en blanco
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                board[i][j] = ' ';
            }
        }

        // Decorar los bordes
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            board[i][0] = '|';           // Borde izquierdo
            board[i][BOARD_WIDTH - 1] = '|';  // Borde derecho
        }
        for (int j = 0; j < BOARD_WIDTH; j++) {
            board[0][j] = '-';           // Borde superior
            board[BOARD_HEIGHT - 1][j] = '-';  // Borde inferior
        }

        // Colocar la pelota en el tablero
        board[ballY][ballX] = 'o';

        // Colocar las paletas en el tablero
        for (int i = 0; i < 3; i++) {
            board[playerPaddleY + i][1] = '#';
            board[opponentPaddleY + i][BOARD_WIDTH - 2] = '#';
        }

        // Imprimir el tablero en la terminal
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void moveBall() {
        ballX += ballSpeedX;
        ballY += ballSpeedY;

        // Lógica para rebotar en las paredes
        if (ballX <= 0 || ballX >= BOARD_WIDTH - 1) {
            ballSpeedX = -ballSpeedX;
        }

        // Lógica para rebotar en las paletas
        if (ballY >= playerPaddleY && ballY < playerPaddleY + 3 && ballX == 1) {
            ballSpeedX = -ballSpeedX;
        } else if (ballY >= opponentPaddleY && ballY < opponentPaddleY + 3 && ballX == BOARD_WIDTH - 2) {
            ballSpeedX = -ballSpeedX;
        }

        // Lógica para rebotar en el techo y el suelo
        if (ballY <= 0 || ballY >= BOARD_HEIGHT - 1) {
            ballSpeedY = -ballSpeedY;
        }
    }

    public void movePaddleUp() {
        if (playerPaddleY > 1) {
            playerPaddleY--;
        }
    }

    public void movePaddleDown() {
        if (playerPaddleY < BOARD_HEIGHT - 4) {
            playerPaddleY++;
        }
    }

    public void moveOpponentPaddle() {
        // Mejorar la lógica de la paleta controlada por la IA
        int directionY = Integer.compare(ballY, opponentPaddleY);
        opponentPaddleY += directionY;

        // Limitar la posición de la paleta para evitar movimientos fuera del tablero
        if (opponentPaddleY < 1) {
            opponentPaddleY = 1;
        } else if (opponentPaddleY > BOARD_HEIGHT - 4) {
            opponentPaddleY = BOARD_HEIGHT - 4;
        }
    }

    private char lastScorer;

    public boolean checkGoal() {
        if (ballX == 0) {
            lastScorer = 'O'; // Gol del oponente
            return true;
        } else if (ballX == BOARD_WIDTH - 1) {
            lastScorer = 'P'; // Gol del jugador
            return true;
        }
        return false;
    }

    public char getLastScorer() {
        return lastScorer;
    }

    public void initializeBall() {
        ballX = BOARD_WIDTH / 2;
        ballY = BOARD_HEIGHT / 2;
        ballSpeedX = -ballSpeedX; // Invertir la dirección de la pelota
    }
}
