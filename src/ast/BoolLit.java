package ast;

public class BoolLit extends Exp {
    boolean val;

    public BoolLit(boolean val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "BoolLit(" + val + ")";
    }

    @Override
    public int eval() {
        return this.val ? 1 : 0;
    }

    @Override
    public String gen(int depth) {
        return this.val ? "1" : "0";
    }

    @Override
    public Type type() {
        return Type.BOOL;
    }
}
