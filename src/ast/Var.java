package ast;

import java.util.List;

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
    public int eval() {
        return 0;
    }

    @Override
    public Type type() {
        return Type.INT;
    }

    @Override
    public String gen(int depth) {
        if (exist()) {
            return this.s;
        } else {
            throw new SemanticError();
        }
    }

    public boolean exist() {
        List<VarDef> defs = Body.getDefs();
        for (VarDef def : defs) {
            if (this.s.equals(def.getVariableId().s)) {
                return true;
            }
        }
        return false;
    }
}
