package ast;

public class LogicalExp extends Exp{

    private OP operation;
    private Exp exp1;
    private Exp exp2;

    public LogicalExp(OP operation, Exp exp1, Exp exp2) {
        this.operation = operation;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public String gen(int depth) {
        this.type();
        return this.exp1.gen(0) + this.operation.gen() + this.exp2.gen(0);
    }

    @Override
    public String toString() {
        return "LogicalExp("+ operation + ", " + exp1 + ", " + exp2 + ")";
    }

    @Override
    public int eval() {
        boolean bool1 = (this.exp1.eval() == 1);
        boolean bool2 = (this.exp2.eval() == 1);
        if (operation.equals(OP.AND)) {
            return (bool1 && bool2) ? 1 : 0;
        } else if (operation.equals(OP.OR)) {
            return (bool1 || bool2) ? 1 : 0;
        } else {
            throw new SyntaxError("Invalid operator");
        }
    }

    @Override
    public Type type() {
        if ((this.exp1.type() == Type.BOOL) && (this.exp2.type() == Type.BOOL)) {
            return Type.BOOL;
        } else {
            throw new SemanticError();
        }
    }
}
