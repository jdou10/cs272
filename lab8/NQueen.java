// Lab 8 - Jingru - Dou - Stacks.zip

import java.util.Scanner;
class Position{
    private int row;
    private int col;
    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
public class NQueen {
    public static boolean checkConflict(Position QPos,LinkStack<Position> stack) {
        LinkStack<Position> pos = new LinkStack<>();
        boolean flag = false;
        while (!stack.isEmpty() && (!flag)) {
            Position top = stack.pop();
            if (top.getRow() == QPos.getRow()) {
                flag = true;
            } else if (top.getCol() == QPos.getCol()) {
                flag = true;
            } else if (Math.abs(top.getRow() - QPos.getRow()) == Math.abs(top.getCol() - QPos.getCol())) {
                flag = true;
            }
            pos.push(top);

        }
        while (!pos.isEmpty()) {
            stack.push(pos.pop());
        }
        return flag;
    }

    public static void printStack(LinkStack<Position> s) {
        int size = s.size();
        String ans = "";
        while (!s.isEmpty()) {
            Position position = s.pop();
            String line = "";
            for (int i = 1; i <= size; ++i) {
                if (position.getCol() == i) {
                    line += 'Q';
                } else {
                    line += '-';
                }
                line += "  ";
            }
            line += "\n";
            ans = line + ans;
        }
        System.out.println(ans);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("please NQueue  N:");
        int N = scanner.nextInt();
        LinkStack<Position> S = new LinkStack<>();
        Position QPos = new Position(1, 1);
        while(S.size() < N) {
            while (QPos.getRow() <= N) {
                if (!checkConflict(QPos, S)) {
                    S.push(QPos);
                    QPos = new Position(QPos.getRow() + 1, 1);
                } else {
                    QPos.setCol(QPos.getCol() + 1);
                }
            }
            while (!S.isEmpty() && (S.top().getCol() > N)) {
                S.pop();
            }
            if (QPos.getCol() > N) {
                break;
            }
        }
        printStack(S);
    }
}
