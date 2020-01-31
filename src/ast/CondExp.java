package ast;

import eval.State;

public class CondExp extends Exp {
    Exp exp1;
    Exp exp2;
    Exp exp3;

    public CondExp(Exp exp1, Exp exp2, Exp exp3) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.exp3 = exp3;
    }

    @Override
    public String toString() {
        return "CondExp(" + exp1 + ", " + exp2 + ", " + exp3 + ")";
    }

    @Override
    public int eval() {
        return exp1.eval() != 0 ? exp2.eval() : exp3.eval();
    }

    @Override
    public Type type() {
        if (this.exp1.type() == Type.BOOL) {
            if (this.exp2.type() == this.exp3.type()) {
                return this.exp2.type();
            } else {
                throw new SemanticError();
            }
        } else {
            throw new SemanticError();
        }
    }

    @Override
    public String gen(int depth) {
        this.type();
        return this.exp1.gen(0) + '?' + this.exp2.gen(0) + ':' + this.exp3.gen(0);
    }
}
