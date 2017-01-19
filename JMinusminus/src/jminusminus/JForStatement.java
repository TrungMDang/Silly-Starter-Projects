
package jminusminus;

import static jminusminus.CLConstants.*;
import jminusminus.CLEmitter;

public class JForStatement extends JStatement{
	/** Test expression. */
    private JForControl control;

    /** The body. */
    private JStatement body;

    /**
     * Construct an AST node for a while-statement given its line number, the
     * test expression, and the body.
     * 
     * @param line
     *            line in which the while-statement occurs in the source file.
     * @param condition
     *            test expression.
     * @param body
     *            the body.
     */

    public JForStatement(int line, JForControl forControl, JStatement body) {
        super(line);
        this.control = forControl;
        this.body = body;
    }

    /**
     * Analysis involves analyzing the test, checking its type and analyzing the
     * body statement.
     * 
     * @param context
     *            context in which names are resolved.
     * @return the analyzed (and possibly rewritten) AST subtree.
     */

    public JForStatement analyze(Context context) {
//    	JVariableDeclaration initialization = this.control.getInit();
    	//JExpression test = this.control.getExpr();
    	//JExpression update = this.control.getUpdate();
//    	JStatement newBody = this.body.copy();
//    	newBody.addStatement(update);
//        //context.addEntry(line(), name, new LocalVariableDefn(type, line()));               
//    	initialization = (JVariableDeclaration) initialization.analyze(context);
//    	//this.control.setInit(initialization);
//    	JWhileStatement w = new JWhileStatement(line(), test, newBody);
//    	w = w.analyze(context);
    	//JStatement init = (JStatement) this.control.getInit();
    	//init = (JStatement) init.analyze(context);
    	//test.analyze(context);
    	this.control.analyze(context);
    	this.body.analyze(context);
    	//update.analyze(context);
    	//this.control.getUpdate().analyze(context);
        return this;
    }

    /**
     * Generate code for the for loop.
     * 
     * @param output
     *            the code emitter (basically an abstraction for producing the
     *            .class file).
     */

    public void codegen(CLEmitter output) {
    	JVariableDeclaration init = (JVariableDeclaration) this.control.getInit();
    	JExpression test = this.control.getExpr();
    	JStatement update = this.control.getUpdate();

    	JStatement newBody = this.body.copy();    	
    	newBody.addStatement(update);
    	init.codegen(output);
    	JWhileStatement w = new JWhileStatement(line(), test, newBody);
    	w.codegen(output);   	
    }

    /**
     * @inheritDoc
     */

    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JForStatement line=\"%d\">\n", line());
        p.indentRight();
        control.writeToStdOut(p);
        p.indentLeft();
        p.printf("<Body>\n");
        p.indentRight();
        body.writeToStdOut(p);
        p.indentLeft();
        p.printf("</Body>\n");
        p.indentLeft();
        p.printf("</JForStatement>\n");
    }

}
