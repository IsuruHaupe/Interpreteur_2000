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
    public AST visitBoolLit(CalcParser.BoolLitContext ctx) {
        boolean bool;
        if (ctx.getText().equals("true")) {
            bool = true;
        } else {
            bool = false;
        }
        return new BoolLit(bool);
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
    public AST visitUnExp(CalcParser.UnExpContext ctx) {
        OP operation;
        if (ctx.MINUS() != null) {
            operation = OP.parse(String.valueOf(ctx.MINUS()));
        } else {
            operation = OP.parse(String.valueOf(ctx.NOT()));
        }
        Exp exp1 = (Exp) visit(ctx.expression());
        return new UnExp(operation, exp1);
    }



    @Override public AST visitBody(CalcParser.BodyContext ctx) {
        List<CalcParser.VarDefContext> varDefListCtx = ctx.varDef();
        List<VarDef> varDefList = new ArrayList<VarDef>();
        for (CalcParser.VarDefContext varDef : varDefListCtx) {
            varDefList.add((VarDef) visit(varDef));
        }
        Exp exp = (Exp) visit(ctx.expression());
        return new Body(varDefList, exp);
    }

    @Override
    public AST visitVarDef(CalcParser.VarDefContext ctx) {
        Var variableId = (Var) visit(ctx.variableId());
        Exp exp = (Exp) visit(ctx.expression());
        return new VarDef(variableId, exp);
    }

    @Override
    public AST visitParExp(CalcParser.ParExpContext ctx) {
        Exp expression = (Exp) visit(ctx.expression());
        return new ParExp(expression);
    }


    @Override
    public AST visitBinExpTimes(CalcParser.BinExpTimesContext ctx) {
        List<CalcParser.ExpressionContext> expCtxs = ctx.expression();
        OP operation = OP.parse(String.valueOf(ctx.MULTIPLICATIVE()));
        Exp exp1 = (Exp) visit(expCtxs.get(0));
        Exp exp2 = (Exp) visit(expCtxs.get(1));
        if(exp2.eval() == 0) {
            throw new SyntaxError("You can't divide by zero");
        }
        return new BinExp(exp1, exp2, operation);
    }

    @Override
    public AST visitBinExpPlus(CalcParser.BinExpPlusContext ctx) {
        List<CalcParser.ExpressionContext> expCtxs = ctx.expression();
        OP operation;
        if (ctx.PLUS() != null) {
            operation = OP.parse(String.valueOf(ctx.PLUS()));
        } else {
            operation = OP.parse(String.valueOf(ctx.MINUS()));
        }
        Exp exp1 = (Exp) visit(expCtxs.get(0));
        Exp exp2 = (Exp) visit(expCtxs.get(1));
        return new BinExp(exp1, exp2, operation);
    }

    @Override public AST visitRelationalExp(CalcParser.RelationalExpContext ctx) {
        List<CalcParser.ExpressionContext> expCtxs = ctx.expression();
        OP operator = OP.parse(String.valueOf(ctx.RELATIONAL()));
        Exp exp1 = (Exp) visit(expCtxs.get(0));
        Exp exp2 = (Exp) visit(expCtxs.get(1));
        return new RelationalExp(operator, exp1, exp2);
    }


    @Override
    public AST visitAndExp(CalcParser.AndExpContext ctx) {
        List<CalcParser.ExpressionContext> expCtxs = ctx.expression();
        Exp exp1 = (Exp) visit(expCtxs.get(0));
        Exp exp2 = (Exp) visit(expCtxs.get(1));
        return new LogicalExp(OP.AND, exp1, exp2);
    }

    @Override
    public AST visitOrExp(CalcParser.OrExpContext ctx) {
        List<CalcParser.ExpressionContext> expCtxs = ctx.expression();
        Exp exp1 = (Exp) visit(expCtxs.get(0));
        Exp exp2 = (Exp) visit(expCtxs.get(1));
        return new LogicalExp(OP.OR, exp1, exp2);
    }

    @Override
    public AST visitEqualExp(CalcParser.EqualExpContext ctx) {
        List<CalcParser.ExpressionContext> expCtxs = ctx.expression();
        OP operator = OP.parse(String.valueOf(ctx.EQUALITY()));
        Exp exp1 = (Exp) visit(expCtxs.get(0));
        Exp exp2 = (Exp) visit(expCtxs.get(1));
        return new EqualExp(operator, exp1, exp2);
    }
}