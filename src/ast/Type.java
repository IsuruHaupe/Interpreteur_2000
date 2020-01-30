package ast;

public enum Type {
    INT, BOOL;

    public String getType() {
        switch (this) {
            case BOOL :
                return "bool";
            case INT :
                return "int";
            default:
                throw new SyntaxError("Unknown type");
        }
    }
}
