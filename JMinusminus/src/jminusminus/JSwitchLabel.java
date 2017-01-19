
package jminusminus;

import static jminusminus.CLConstants.*;

import java.util.*;

public class JSwitchLabel extends JStatement {
	
	protected TokenInfo label;
	
	protected JExpression expr;
	
	public JSwitchLabel(int line, TokenInfo label, JExpression expr) {
		super(line);
		this.label = label;
		this.expr = expr;
	}
	

	public JSwitchLabel analyze(Context context) {

		return this;
	}
	
	 public void codegen(CLEmitter output) {

	 }
	 /**
     * @inheritDoc
     */

    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JSwitchLabel line=\"%d\" name=\"%s\">\n", line(), label.image());
        p.indentRight();
        if (expr != null)
        	expr.writeToStdOut(p);
        p.indentRight();

    }
}
