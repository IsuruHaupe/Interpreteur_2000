package ast;

public class EqualExp extends Exp{

    private OP operation;
    private Exp exp1;
    private Exp exp2;

    public EqualExp(OP operation, Exp exp1, Exp exp2) {
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
        return "EqualExp("+operation + ", " + exp1 + ", " + exp2 + ")";
    }

    @Override
    public int eval() {
        if (operation.equals(OP.EQUAL)) {
            return this.exp1.eval() == this.exp2.eval() ? 1 : 0;
        } else if (operation.equals(OP.UNEQUAL)){
            return this.exp1.eval() != this.exp2.eval() ? 1 : 0;
        } else {
            throw new SyntaxError("Invalid operation");
        }
    }

    @Override
    public Type type() {
        if (this.exp1.type() == this.exp2.type()) {
            return Type.BOOL;
        } else {
            throw new SemanticError();
        }
    }
}