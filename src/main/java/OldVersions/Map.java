package OldVersions;

public class Map {

    int fieldHeight = 10;
    int fieldWidth = 15;
    int x1 = 0, y1 = 0;
    int x2 = 14, y2 = 9;


    public void drawField() {
        System.out.println();
        for (int i = 0; i < fieldHeight; i++) {
            for (int j = 0; j < fieldWidth; j++) {
                if (i == y1 && j == x1) {
                    System.out.print("[O]");
                } else if (i == y2 && j == x2) {
                    System.out.print("[X]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }

    public void updateGame(Player player1, Player player2, Robot robot1, Robot robot2) {
            PlayerMover playerMover = new PlayerMover();
            playerMover.movePlayer(player1, robot1);
            drawField();
        }
    }
