package ast;

import eval.State;

import java.util.List;

public class Body extends AST {
    static List<VarDef> defs;
    Exp expression;

    public Body(List<VarDef> defs, Exp expression) {
        Body.defs = defs;
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "Body(" + defs + ", " + expression + ")";
    }

    @Override
    public String gen(int depth) {
        StringBuilder code = new StringBuilder();
        for (VarDef def: defs) {
            code.append(def.gen(0));
        }
        return  (String) (code + expression.gen(0));
    }

    @Override
    public Type type() {
        return this.expression.type();
    }

    public int eval(State<Exp> state) {
        for(VarDef var : defs) {
            var.eval(state);
        }
        return this.expression.eval();
    }


    public static List<VarDef> getDefs() {
        return defs;
    }
}