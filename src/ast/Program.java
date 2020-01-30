package ast;

public class Program {
    public static String gen(String code) {
        return "#include <stdio.h>\n" +
                "int main() {\n" +
                "   return printf(\"%i\\n\", " + code + ");\n" +
                "}\n";
    }
}
