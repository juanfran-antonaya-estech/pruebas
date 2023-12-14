package sneik;

import java.util.Scanner;

public class SnakeGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Snake snake = new Snake();
        Fruit fruit = new Fruit(20, 20);

        while (true) {
            printBoard(snake, fruit);
            char direction = scanner.next().charAt(0);
            snake.move(direction);

            if (snake.collidesWith(fruit)) {
                snake.grow();
                fruit.spawn();
            }

            if (snake.hasCollisions()) {
                System.out.println("Game Over!");
                break;
            }
        }
    }

    private static void printBoard(Snake snake, Fruit fruit) {
        for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 22; j++) {
                if (i == 0 || i == 21 || j == 0 || j == 21) {
                    System.out.print("#");
                } else if (i == fruit.getY() && j == fruit.getX()) {
                    System.out.print("F");
                } else if (snake.contains(j, i)) {
                    System.out.print("O");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

class Snake {
    // Implementar lógica para la serpiente
}

class Fruit {
    // Implementar lógica para la fruta
}
