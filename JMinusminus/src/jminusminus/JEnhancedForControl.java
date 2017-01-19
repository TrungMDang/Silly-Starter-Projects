
package jminusminus;

import static jminusminus.CLConstants.*;

public class JEnhancedForControl extends JForControl{
	
	protected JStatement varDec;
	
	protected JExpression expr;
	
	 
	public JEnhancedForControl(int line, JStatement varDec, JExpression expr) {
		super(line);
		this.varDec = varDec;
		this.expr = expr;
	}
	
	
	/**
     * @inheritDoc
     */

    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JEnhancedForControl line=\"%d\">\n", line());
        p.indentRight();
        varDec.writeToStdOut(p);
        expr.writeToStdOut(p);
        p.indentLeft();
        p.printf("</JEnhancedForControl>\n");
    }
}
