package ast;

public class ParExp extends Exp{
    Exp exp;

    public ParExp(Exp exp) {
        this.exp = exp;
    }

    @Override
    public String gen(int depth) {
        this.type();
        return '(' + this.exp.gen(0) + ')';
    }

    @Override
    public String toString() {
        return "ParExp(" + exp + ")";
    }

    @Override
    public int eval() {
        return this.exp.eval();
    }

    @Override
    public Type type() {
        return this.exp.type();
    }
}
