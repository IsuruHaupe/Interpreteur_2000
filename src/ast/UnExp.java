package ast;

import eval.State;

public class UnExp extends Exp {
    OP operation;
    Exp expression;

    public UnExp(Exp expression) {
        this.operation = OP.MINUS;
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "UnExp(" + operation + ", " + expression + ")";
    }

    @Override
    public int eval(State<Integer> varState,  State<FunDef> stFun) {
        return -(this.expression.eval(varState, stFun));
    }


    @Override
    public String gen(int depth) {
        return "(- " + expression.gen(0) + ")";
    }
}
