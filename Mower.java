class Mower {
    private int x;
    private int y;
    private char orientation;

    public Mower(int x, int y, char orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void move(String instructions, Lawn lawn) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'D':
                    rotateRight();
                    break;
                case 'G':
                    rotateLeft();
                    break;
                case 'A':
                    moveForward(lawn);
                    break;
                default:
                    System.out.println("Invalid instruction : " + instruction);
                    System.exit(1);
            }
        }
    }

    private void rotateRight() {
        if (orientation == 'N') {
            orientation = 'E';
        } else if (orientation == 'E') {
            orientation = 'S';
        } else if (orientation == 'S') {
            orientation = 'W';
        } else if (orientation == 'W') {
            orientation = 'N';
        }

    }

    private void rotateLeft() {
        if (orientation == 'N') {
            orientation = 'W';
        } else if (orientation == 'W') {
            orientation = 'S';
        } else if (orientation == 'S') {
            orientation = 'E';
        } else if (orientation == 'E') {
            orientation = 'N';
        }
    }

    private void moveForward(Lawn lawn) {
        if (orientation == 'N' && y < lawn.getHeight()) {
            y++;
        } else if (orientation == 'E' && x < lawn.getWidth()) {
            x++;
        } else if (orientation == 'S' && y > 0) {
            y--;
        } else if (orientation == 'W' && x > 0) {
            x--;
        }
    }

    public String getPosition() {
        return x + " " + y + " " + orientation;
    }
}