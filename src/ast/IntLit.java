package ast;

public class IntLit extends Exp {
    final String val;

    public IntLit(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "IntLit(" + val + ")";
    }

    @Override
    public int eval() {
        return Integer.parseInt(val);
    }

    @Override
    public Type type() {
        return Type.INT;
    }


    @Override
    public String gen(int depth) {
        return val;
    }
}
