package com.btcag.bootcamp.Services;

public enum MoveDirection {
    NORD(0, -1),
    NORDOST(1, -1),
    OST(1, 0),
    SUEDOST(1, 1),
    SUED(0, 1),
    SUEDWEST(-1, 1),
    WEST(-1, 0),
    NORDWEST(-1, -1);

    private final int x;
    private final int y;

    MoveDirection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static MoveDirection fromUserInput(char userChoice) {
        return switch (userChoice) {
            case 'n' -> NORD;
            case 's' -> SUED;
            case 'o' -> OST;
            case 'w' -> WEST;
            default -> null;
        };
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}


