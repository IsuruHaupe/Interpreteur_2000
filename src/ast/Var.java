package ast;

import eval.State;

public class Var extends Exp{
    String s;

    public Var(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "Var(" + s + ")";
    }

    @Override
    public int eval(State<Integer> varState,  State<FunDef> stFun) {
        if (varState.lookup(this.s) != null) {
            Integer value = varState.lookup(this.s);
            return value;
        } else {
            throw new SyntaxError("Unknown variable name " + this.s);
        }
    }

    @Override
    public String gen(int depth) {
        return s;
    }
}
