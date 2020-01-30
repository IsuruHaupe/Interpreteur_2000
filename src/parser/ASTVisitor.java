package parser;

import ast.*;

import java.util.ArrayList;
import java.util.List;

public class ASTVisitor extends CalcBaseVisitor<AST>{
    @Override
    public AST visitIntLit(CalcParser.IntLitContext ctx) {
        return new IntLit(ctx.getText());
    }

    @Override
    public AST visitVar(CalcParser.VarContext ctx) {
        return new Var(ctx.getText());
    }

    @Override
    public AST visitCondExp(CalcParser.CondExpContext ctx) {
        List<CalcParser.ExpressionContext> expCtxs = ctx.expression();
        Exp exp1 = (Exp) visit(expCtxs.get(0));
        Exp exp2 = (Exp) visit(expCtxs.get(1));
        Exp exp3 = (Exp) visit(expCtxs.get(2));
        return new CondExp(exp1, exp2, exp3);
    }

    @Override
    public AST visitMinusExp(CalcParser.MinusExpContext ctx) {
        CalcParser.ExpressionContext expCtxs = ctx.expression();
        if (ctx.getChild(3).getText().length() == 1) {
            return new UnExp((Exp) visit(expCtxs));
        } else {
            return new BinExp((Exp) visit(expCtxs), (Exp) visit(ctx.getChild(3).getChild(0)), OP.MINUS);
        }
    }


    @Override
    public AST visitBinExp(CalcParser.BinExpContext ctx) {
        List<CalcParser.ExpressionContext> expCtxs = ctx.expression();
        Exp exp1 = (Exp) visit(expCtxs.get(0));
        Exp exp2 = (Exp) visit(expCtxs.get(1));
        return new BinExp(exp1, exp2, OP.parse(ctx.getChild(1).getText()));
    }

    @Override public AST visitProgram(CalcParser.ProgramContext ctx) {
        CalcParser.BodyContext bCtx = ctx.body();
        Body body = (Body) visit(bCtx);
        return new Program(new ArrayList<>(), body);
    }

    @Override public AST visitBody(CalcParser.BodyContext ctx) {
        CalcParser.ExpressionContext eCtx = ctx.expression();
        Exp exp = (Exp) visit(eCtx);
        return new Body(new ArrayList<>(), exp);
    }

    @Override
    public AST visitVarDef(CalcParser.VarDefContext ctx) {
        return new VarDef(ctx.variableId().getText(), (Exp) visit(ctx.expression()));
    }
}

