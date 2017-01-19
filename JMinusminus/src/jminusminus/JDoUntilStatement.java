// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package jminusminus;

import static jminusminus.CLConstants.*;

/**
 * The AST node for a while-statement.
 */

class JDoUntilStatement extends JStatement {

    /** Test expression. */
    private JExpression condition;

    /** The body. */
    private JStatement body;

    /**
     * Construct an AST node for a do-Until-statement given its line number, the
     * test expression, and the body.
     * 
     * @param line
     *            line in which the do-until-statement occurs in the source file.
     * @param condition
     *            test expression.
     * @param body
     *            the body.
     */

    public JDoUntilStatement(int line, JStatement body,  JExpression condition) {
        super(line);
        this.body = body;
        this.condition = condition;

    }

    /**
     * Analysis involves analyzing the test, checking its type and analyzing the
     * body statement.
     * 
     * @param context
     *            context in which names are resolved.
     * @return the analyzed (and possibly rewritten) AST subtree.
     */

    public JDoUntilStatement analyze(Context context) {
//        condition = condition.analyze(context);
//        condition.type().mustMatchExpected(line(), Type.BOOLEAN);
//        body = (JStatement) body.analyze(context);
        return this;
    }

    /**
     * Generate code for the do-Until loop.
     * 
     * @param output
     *            the code emitter (basically an abstraction for producing the
     *            .class file).
     */

    public void codegen(CLEmitter output) {
        
    }

    /**
     * @inheritDoc
     */

    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JDoUntilStatement line=\"%d\">\n", line());
        p.indentRight();
        p.printf("<Body>\n");
        p.indentRight();
        body.writeToStdOut(p);
        p.indentLeft();
        p.printf("</Body>\n");
        p.printf("<TestExpression>\n");
        p.indentRight();
        condition.writeToStdOut(p);
        p.indentLeft();
        p.printf("</TestExpression>\n");
        p.indentLeft();
        p.printf("</JDoUntilStatement>\n");
    }

}
