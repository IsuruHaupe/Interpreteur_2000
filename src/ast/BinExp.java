package ast;


import eval.State;

public class BinExp extends Exp{
    Exp exp1;
    Exp exp2;
    OP operation;

    public BinExp(Exp exp1, Exp exp2, OP operation) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "BinExp(" + operation + ", " + exp1 + ", " + exp2 + ")";
    }

    @Override
    public int eval(State<Integer> varState,  State<FunDef> stFun) {
        int val1 = exp1.eval(varState, stFun);
        int val2 = exp2.eval(varState, stFun);
        switch (operation) {
            case PLUS:
                return val1 + val2;
            case MINUS:
                return val1 - val2;
            case TIMES:
                return val1 * val2;
            case DIVIDE:
                return val1 / val2;
            case EQUAL:
                return  val1 == val2 ? 1 : 0;
            case LESS:
                return val1 < val2 ? 1 : 0;
            default:
                throw new SyntaxError("Invalid operator");
        }
    }

    @Override
    public String gen(int depth) {
        return "(" + exp1.gen(0) + " " + OP.gen(operation) + " "
                + exp2.gen(0) + ")";
    }
}
