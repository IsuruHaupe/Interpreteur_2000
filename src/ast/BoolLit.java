package ast;

import eval.State;

public class BoolLit extends Exp {
    final String val;

    public BoolLit(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "BoolLit(" + val + ")";
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
