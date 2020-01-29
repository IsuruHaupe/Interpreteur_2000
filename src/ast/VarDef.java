package ast;

import eval.State;

public class VarDef extends AST {

    public String name;
    public Exp expression;

    public VarDef(String name, Exp exp) {
        this.name = name;
        this.expression = exp;
    }

    @Override
    public String toString() {
        return "VarDef("+ name + "," + expression + ")";
    }

    @Override
    public String gen(int depth) {
        return null;
    }

    public void eval(State<Integer> varState, State<FunDef> stFun){
        varState.bind(this.name, this.expression.eval(varState, stFun));
    }
}