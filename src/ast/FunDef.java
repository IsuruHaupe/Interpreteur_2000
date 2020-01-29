package ast;

import eval.State;

import java.util.List;

public class FunDef extends AST{
    String name;
    List<String> formals;
    Body body;

    public FunDef(String name, List<String> formals, Body body) {
        this.name = name;
        this.formals = formals;
        this.body = body;
    }

    public int eval(List<Integer> vals, State<FunDef> stFun) {
        State<Integer> newState = new State<>();
        newState.bindAll(formals, vals);
        return body.eval(newState, stFun);
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public String gen(int depth) {
        throw new NotImplemented();
    }
}
