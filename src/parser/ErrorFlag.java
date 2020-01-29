package parser;

public class ErrorFlag {
    static boolean error = false;

    public static boolean getFlag() {
        return error;
    }

    public static void setFlag() {
        ErrorFlag.error = true;
    }

    public static void reset() {
        ErrorFlag.error = false;
    }
}
