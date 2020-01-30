package ast;

public class UnExp extends Exp {
    OP operation;
    Exp expression;

    public UnExp(OP operation, Exp expression) {
        this.operation = operation;
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "UnExp(" + operation + ", " + expression + ")";
    }

    @Override
    public int eval() {
        if (operation.equals(OP.MINUS)) {
            return -(this.expression.eval());
        } else if (operation.equals(OP.NOT)) {
            int eval = this.expression.eval();
            return eval == 0 ? 1 : 0;
        } else {
            throw new SyntaxError("Syntax Error");
        }
    }

    @Override
    public Type type() {
        if (operation.equals(OP.NOT)) {
            if (this.expression.type() == Type.BOOL) {
                return Type.BOOL;
            } else {
                throw new SemanticError();
            }
        } else if (operation.equals(OP.MINUS)) {
            if (this.expression.type() == Type.INT) {
                return Type.INT;
            } else {
                throw new SemanticError();
            }
        } else {
            throw new SemanticError();
        }
    }


    @Override
    public String gen(int depth) {
        return this.operation.gen() + this.expression.gen(0);
    }
}
