package jminusminus;

import static jminusminus.CLConstants.*;
import jminusminus.CLEmitter;

abstract class JTernaryExpression extends JExpression {
	protected int line;
	protected String operator;
	protected JExpression expr, test, rhs;
	

    /**
     * Construct an AST node for a ternary expression.
     * 
     * @param line
     *            line in which the ternary expression occurs in the
     *            source file.
     * @param operator
     *            the boolean binary operator.
     * @param lhs
     *            lhs operand.
     * @param rhs
     *            rhs operand.
     */

    protected JTernaryExpression(int line, String operator, JExpression expr,
            JExpression test, JExpression rhs) {
    	super(line);
    	this.operator = operator;
    	this.expr = expr;
    	this.test= test;
    	this.rhs = rhs;
    	
    }
    
    public void codegen(CLEmitter output) {
    	
    }
    /**
     * @inheritDoc
     */
    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JTernaryExpression line=\"%d\" type=\"%s\" "
                + "operator=\"%s\">\n", line(), ((type == null) ? "" : type
                .toString()), Util.escapeSpecialXMLChars(operator));
        p.indentRight();
        p.printf("<Lhs>\n");
        p.indentRight();
        test.writeToStdOut(p);
        p.indentLeft();
        p.printf("</Lhs>\n");
        p.printf("<Rhs>\n");
        p.indentRight();
        rhs.writeToStdOut(p);
        p.indentLeft();
        p.printf("</Rhs>\n");
        p.printf("</JTernaryExpression>\n");
    }
}
/**
 * The AST node for a ternary ? : expression.
 */

class JTernaryOp extends JTernaryExpression {

    /**
     * Construct an AST node for a ternary expression given its line number,
     * and lhs and rhs operands.
     * 
     * @param line
     *            line in which the logical OR expression occurs in the source
     *            file.
     * @param lhs
     *            lhs operand.
     * @param rhs
     *            rhs operand.
     */

    public JTernaryOp(int line, JExpression expr, JExpression test, JExpression rhs) {
        super(line, "?", expr, test, rhs);
    }
    
    public JExpression analyze(Context context) {
        expr = (JExpression) expr.analyze(context);
        test = test.analyze(context);
        test.type().mustMatchExpected(line(), Type.BOOLEAN);
        rhs = (JExpression) rhs.analyze(context);
        type = expr.type();        
        return this;
    }
    
    public void codegen(CLEmitter output){
    	String elseLabel = output.createLabel();
    	String endLabel = output.createLabel();
    	
    	this.test.codegen(output, elseLabel, false);
    	this.rhs.getRhs().codegen(output);
    	output.addBranchInstruction(GOTO, endLabel);
    	output.addLabel(elseLabel);
    	this.rhs.getRhs1().codegen(output);
    	output.addLabel(endLabel);
    	this.expr.codegen(output);

    }
}


/**
 * The AST node for the right hand side of ternary ? : expression.
 */

class JTernaryRightOp extends JExpression {
	protected int line;
	protected JExpression lhs;
	protected JExpression rhs;
	protected JExpression rhs1;


    /**
     * Construct an AST node for ternary given its line number,
     * and rhs and rhs1 operands.
     * 
     * @param line
     *            line in which the logical OR expression occurs in the source
     *            file.
     * @param lhs
     *            lhs operand.
     * @param rhs
     *            rhs operand.
     */

    public JTernaryRightOp(int line, JExpression lhs, JExpression rhs, JExpression rhs1) {
    	super(line);
    	this.line = line;
        this.lhs = lhs;
        this.rhs = rhs;
        this.rhs1 = rhs1;
    }
    public JExpression getRhs() {
    	return this.rhs;
    }
    public JExpression getRhs1() {
    	return this.rhs1;
    }
    public JExpression analyze(Context context) {
        rhs = (JExpression) rhs.analyze(context);
        rhs.type().mustMatchExpected(this.line, lhs.type());
        rhs1 = (JExpression) rhs1.analyze(context);
        //lhs.type().mustMatchExpected(line(), Type());
        rhs1.type().mustMatchExpected(this.line, lhs.type());
        type = lhs.type();
        return this;
    }
    
    public void codegen(CLEmitter output) {
//        if (onTrue) {
//            String falseLabel = output.createLabel();
//            lhs.codegen(output, falseLabel, false);
//            rhs.codegen(output, targetLabel, true);
//            output.addLabel(falseLabel);
//        } else {
//            lhs.codegen(output, targetLabel, false);
//            rhs.codegen(output, targetLabel, false);
//        }
    }
    
    /**
     * @inheritDoc
     */
    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JTernaryRightExpression line=\"%d\" type=\"%s\" "
                + "operator=\"%s\">\n", this.line, ((type == null) ? "" : type.toString()), Util.escapeSpecialXMLChars(":"));
        p.indentRight();
        rhs.writeToStdOut(p);
        p.indentLeft();
        p.indentRight();
        rhs1.writeToStdOut(p);
        p.indentLeft();
        p.printf("</JTernaryRightExpression>\n");
    }
}

