package ast;

public class SemanticError extends RuntimeException {
    public SemanticError() {
        super("Semantic Error");
    }
}
