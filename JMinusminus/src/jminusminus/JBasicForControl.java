
package jminusminus;

import static jminusminus.CLConstants.*;

public class JBasicForControl extends JForControl {
	
	protected JVariableDeclaration init;
	protected JExpression expr;
	//protected JExpression update;
	protected JStatement update;

	public JBasicForControl(int line, JVariableDeclaration init, JExpression expr, JStatement update) {
		super(line);
		this.init = init;
		this.expr = expr;
		this.update = update;
	}
	@Override
	public JVariableDeclaration getInit() {
		return this.init;
	}
	@Override
	public void setInit(JVariableDeclaration init) {
		this.init = init;
	}
	@Override
	public JExpression getExpr() {
		return this.expr;
	}
	@Override
	public JStatement getUpdate() {
		return this.update;
	}
	
	@Override
	public JBasicForControl analyze(Context context) {
		init = (JVariableDeclaration) init.analyze(context);
		expr = (JExpression) expr.analyze(context);
		update = (JStatement) update.analyze(context);
        return this;
    }
	
	@Override
	public void codegen(CLEmitter output) {
		init.codegen(output);
		//expr.codegen(output);
		update.codegen(output);
	}
	/**
     * @inheritDoc
     */

    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JBasicForControl line=\"%d\">\n", line());
        p.indentRight();
        init.writeToStdOut(p);       
        expr.writeToStdOut(p);
        update.writeToStdOut(p);
		p.indentLeft();
        p.printf("</JBasicForControl>\n");
    }

}
