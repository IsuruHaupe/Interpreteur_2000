package ast;

public enum OP {
    PLUS, MINUS, TIMES, DIVIDE, EQUAL, LESS;

    public static OP parse(String operation) {
        switch(operation) {
            case "+":
                return OP.PLUS;
            case "-":
                return  OP.MINUS;
            case "*":
                return OP.TIMES;
            case "/":
                return OP.DIVIDE;
            case "==":
                return OP.EQUAL;
            case "<":
                return OP.LESS;
            default:
                throw new SyntaxError("Invalid operator");
        }
    }

    public static String gen(OP operation) {
        switch(operation) {
            case PLUS:
                return "+";
            case MINUS:
                return "-";
            case TIMES:
                return "*";
            case DIVIDE:
                return "/";
            case EQUAL:
                return "==";
            case LESS:
                return "<";
            default:
                throw new SyntaxError("Invalid operator");
        }
    }

}