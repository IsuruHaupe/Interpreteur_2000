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
    public int eval(State<Integer> varState,  State<FunDef> stFun) {
        if (exp1.eval(varState, stFun) != 0) {
            return exp2.eval(varState, stFun);
        } else {
            return exp3.eval(varState, stFun);
        }
    }

    @Override
    public String gen(int depth) {
        return "(" + exp1.gen(0) + "? " +
        exp2.gen(0) + ": " + exp3.gen(0) + ")";
    }
}
