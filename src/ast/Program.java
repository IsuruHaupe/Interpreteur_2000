package ast;

import eval.State;

import java.util.List;

public class Program extends Exp{
    List<FunDef> defs;
    public Body body;

    public Program(List<FunDef> defs, Body body) {
        this.defs = defs;
        this.body = body;
    }

    public int eval(State<Integer> varState, State<FunDef> stState) {
        State<FunDef> stFun = new State<>();
        for(FunDef def : defs) {
            stFun.bind(def.name, def);
        }
        return body.eval(new State<>(), stFun);
    }

    @Override
    public String toString() {
        return "Program(" + defs + ", " + body + ")";
    }

    @Override
    public String gen(int depth) {
        return "#include <stdio.h>\n" +
                "int main() {\n" +
                "   return printf(\"%i\\n\", " + body.expression.gen(0) + ");\n" +
                "}\n";
    }
}
