package ast;

import eval.State;

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
    public int eval(State<Integer> varState,  State<FunDef> stateFunc) {
        return Integer.parseInt(val);
    }


    @Override
    public String gen(int depth) {
        return val;
    }
}
