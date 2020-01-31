package ast;

import eval.State;
import java.util.List;

public class VarDef extends AST {

    private String name;
    private Var var;
    private Exp expression;

    public VarDef(Var var, Exp exp) {
        this.name = "=";
        this.var = var;
        this.expression = exp;
    }

    public void eval(State<Exp> stateVar) {
        if (stateVar.lookup(this.var.toString()) != null) {
            throw new SyntaxError("Syntax Error");
        } else {
            stateVar.bind(this.var.toString(), this.expression);
        }
    }

    @Override
    public String gen(int depth) {
        if (!exist()) {
            return this.type().getType() + " " +
                    this.getVar().gen(0) + " = " +
                    this.getExpression().gen(0) + ";\n";
        } else {
            throw new SemanticError();
        }
    }

    @Override
    public Type type() {
        return this.expression.type();
    }

    @Override
    public String toString() {
        return "VarDef(" + name + ", " + var + ", " + expression + ")";
    }

    public Var getVar() {
        return var;
    }

    public Exp getExpression() {
        return expression;
    }

    public boolean exist() {
        List<VarDef> defs = Body.getDefs();
        int cpt = 0;
        for (VarDef def : defs) {
            if (this.var.s.equals(def.getVar().s)) {
                cpt++;
            }
        }
        return cpt >= 2;
    }
}