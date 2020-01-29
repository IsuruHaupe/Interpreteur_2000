package ast;

import eval.State;

import java.util.List;

public class Body extends AST {
    List<VarDef> defs;
    Exp expression;

    public Body(List<VarDef> defs, Exp expression) {
        this.defs = defs;
        this.expression = expression;
    }

    public int eval(State<Integer> state, State<FunDef> stFun) {
        for(VarDef var : defs) {
            var.eval(state, stFun);
        }
        return this.expression.eval(state, stFun);
    }

    @Override
    public String toString() {
        return "Body(" + defs + ", " + expression + ")";
    }

    @Override
    public String gen(int depth) {
        throw new NotImplemented();
    }
}