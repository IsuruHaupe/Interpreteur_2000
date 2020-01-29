package TestC;

import java.util.OptionalInt;

public class TestGreen extends test.src.test.Test {

    public static void main(String[] args) {
        TestC.Test.main(args);
        // Calc Green
        boolean verbose = true;
        TestC.Test.test(verbose, "test/greenOne.calc", "1", OptionalInt.of(1));
        TestC.Test.test(verbose, "test/greenZeroUnix.calc", "0", OptionalInt.of(0));
        TestC.Test.test(verbose, "test/greenZeroDos.calc", "0", OptionalInt.of(0));
        TestC.Test.test(verbose, "test/greenZeroTab.calc", "0", OptionalInt.of(0));
        TestC.Test.test(verbose, "test/greenLit.calc", "100", OptionalInt.of(100));
        TestC.Test.test(verbose, "test/greenUnExpMinus.calc", "-1", OptionalInt.of(-1));
        TestC.Test.test(verbose, "test/greenUnExpMinus2.calc", "(- (- 1 0))", OptionalInt.of(-1));
        TestC.Test.test(verbose, "test/greenBinExpPlus.calc", "(+ 1 1)", OptionalInt.of(2));
        TestC.Test.test(verbose, "test/greenBinExpPlus01.calc", "(+ 01)", OptionalInt.of(1));
        TestC.Test.test(verbose, "test/greenBinExpMinus.calc", "(- 1 1)", OptionalInt.of(0));
        TestC.Test.test(verbose, "test/greenBinExpDivide.calc", "(/ 5 2)", OptionalInt.of(2));
        TestC.Test.test(verbose, "test/greenBinExpEqual.calc", "(== 1 2)", OptionalInt.of(0));
        TestC.Test.test(verbose, "test/greenBinExpEqual2.calc", "(== 3 3)", OptionalInt.of(1));
        TestC.Test.test(verbose, "test/greenNestedExp.calc", "(+ (- 2 3) (+ 0 1))", OptionalInt.of(0));
        TestC.Test.test(verbose, "test/greenIf0.calc", "(if 0 1 0)", OptionalInt.of(0));
        TestC.Test.test(verbose, "test/greenIf0Indent.calc", "(if 0 1 0)", OptionalInt.of(0));
        TestC.Test.test(verbose, "test/greenIf1.calc", "(if 1 11 0)", OptionalInt.of(11));
        TestC.Test.test(verbose, "test/greenIf2.calc", "(if 2 22 0)", OptionalInt.of(22));
        TestC.Test.test(verbose, "test/greenIf3.calc", "(if (-2) 33 0)", OptionalInt.of(33));
        TestC.Test.test(verbose, "test/greenNestedIfInTest.calc", "(if (if 1 1 0) 2 3)", OptionalInt.of(2));
        TestC.Test.test(verbose, "test/greenNestedIfInBranch.calc", "(if 1 (if 1 2 0) 3)", OptionalInt.of(2));
        TestC.Test.test(verbose, "test/greenNestedIfInExp.calc", "(+ (if 1 1 0) 1)", OptionalInt.of(2));
        TestC.Test.test(verbose, "test/greenNestedExpAsTest.calc", "(if (- 1 1) 1 44)", OptionalInt.of(44));
        TestC.Test.test(verbose, "test/greenLazyIf.calc", "(if 0 (/ 1 (- 2 2)) 122)", OptionalInt.of(122));
        TestC.Test.report();
    }
}
