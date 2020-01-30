package ast;

public enum OP {
    PLUS, MINUS, TIMES, DIVIDE, LESS, LESS_EQUAL, MORE, MORE_EQUAL, EQUAL, UNEQUAL, NOT, AND, OR;

    public static OP parse(String operation) {
        switch(operation) {
            case "+" :
                return PLUS;
            case "-" :
                return MINUS;
            case "*" :
                return TIMES;
            case "/" :
                return DIVIDE;
            case "<" :
                return LESS;
            case "<=" :
                return LESS_EQUAL;
            case ">" :
                return MORE;
            case ">=" :
                return MORE_EQUAL;
            case "==" :
                return EQUAL;
            case "!=" :
                return UNEQUAL;
            case "!" :
                return NOT;
            case "&&" :
                return AND;
            case "||" :
                return OR;
            default:
                throw new SyntaxError("Invalid operator");
        }
    }

    public String  gen() {
        switch(this) {
            case PLUS :
                return "+";
            case MINUS :
                return "-";
            case TIMES :
                return "*";
            case DIVIDE :
                return "/";
            case LESS :
                return "<";
            case LESS_EQUAL :
                return "<=";
            case MORE :
                return ">";
            case MORE_EQUAL :
                return ">=";
            case EQUAL :
                return "==";
            case UNEQUAL :
                return "!=";
            case NOT :
                return "!";
            case AND :
                return "&&";
            case OR :
                return "||";
            default:
                throw new SyntaxError("Invalid operator");
        }
    }

}