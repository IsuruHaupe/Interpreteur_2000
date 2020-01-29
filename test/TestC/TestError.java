package TestC;

import java.util.OptionalInt;

public class TestError extends test.src.test.Test {

    public static void main(String[] args) {
        TestC.Test.main(args);
        // various errors
        boolean verbose = true;
        TestC.Test.test(verbose, "test/error.calc", "no file", OptionalInt.empty());
        TestC.Test.test(verbose, "test/errorEmpty.calc", "", OptionalInt.empty());
        TestC.Test.test(verbose, "test/errorGarbage.calc", "FOO!", OptionalInt.empty());
        TestC.Test.test(verbose, "test/errorGarbage2.calc", "01", OptionalInt.empty());
        TestC.Test.test(verbose, "test/errorUnaryExp.calc", "(+ 2)", OptionalInt.empty());
        TestC.Test.test(verbose, "test/errorParens.calc", "(2)", OptionalInt.empty());
        TestC.Test.test(verbose, "test/errorRPar.calc", "(+ 1 2", OptionalInt.empty());
        TestC.Test.test(verbose, "test/errorIf.calc", "(if1 1 0)", OptionalInt.empty());
        TestC.Test.test(verbose, "test/errorIf2.calc", "(if 1 1)", OptionalInt.empty());
        TestC.Test.test(verbose, "test/errorDivide.calc", "(/ 1 0)", OptionalInt.empty());
        TestC.Test.report();
    }
}

