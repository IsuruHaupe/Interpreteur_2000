package ast;

public class RelationalExp extends Exp{

    private OP operation;
    private Exp exp1;
    private Exp exp2;

    public RelationalExp(OP operation, Exp exp1, Exp exp2) {
        this.operation = operation;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public String gen(int depth) {
        this.type();
        return this.exp1.gen(0) + operation.gen() + this.exp2.gen(0);
    }

    @Override
    public String toString() {
        return "RelationalExp("+ operation + ", " + exp1 + ", " + exp2 + ")";
    }

    @Override
    public int eval() {
        if (operation.equals(OP.LESS)) {
            return this.exp1.eval() < this.exp2.eval() ? 1 : 0;
        } else if (operation.equals(OP.MORE)) {
            return this.exp1.eval() > this.exp2.eval() ? 1 : 0;
        }else if (operation.equals(OP.LESS_EQUAL)) {
            return this.exp1.eval() <= this.exp2.eval() ? 1 : 0;
        }else if (operation.equals(OP.MORE_EQUAL)) {
            return this.exp1.eval() >= this.exp2.eval() ? 1 : 0;
        } else {
            throw new SyntaxError("Invalid operation");
        }
    }

    @Override
    public Type type() {
        if (this.exp1.type() == Type.INT && this.exp2.type() == Type.INT) {
            return Type.BOOL;
        } else {
            throw new SemanticError();
        }
    }
}
