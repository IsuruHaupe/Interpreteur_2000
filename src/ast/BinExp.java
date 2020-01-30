package ast;

public class BinExp extends Exp{
    Exp exp1;
    Exp exp2;
    OP operation;

    public BinExp(Exp exp1, Exp exp2, OP operation) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "BinExp(" + operation + ", " + exp1 + ", " + exp2 + ")";
    }

    @Override
    public int eval() {
        if (operation.equals(OP.MINUS)) {
            return this.exp1.eval() - this.exp2.eval();
        } else if (operation.equals(OP.PLUS)) {
            return this.exp1.eval() + this.exp2.eval();
        } else if (operation.equals(OP.DIVIDE)) {
            return (this.exp1.eval() / this.exp2.eval());
        } else if (operation.equals(OP.TIMES)) {
            return this.exp1.eval() * this.exp2.eval();
        } else {
            throw new SyntaxError("Invalid operator");
        }
    }

    @Override
    public Type type() {
        if (this.exp1.type() == Type.INT && this.exp2.type() == Type.INT) {
            return Type.INT;
        } else {
            throw new SemanticError();
        }
    }

    @Override
    public String gen(int depth) {
        this.type();
        return this.exp1.gen(0) + operation.gen() + this.exp2.gen(0);
    }
}
