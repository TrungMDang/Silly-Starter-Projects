// Copyright 2011 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package jminusminus;

import static jminusminus.CLConstants.*;

import java.util.ArrayList;

public class JThrowStatement extends JStatement {
		
	protected JExpression expr;
		
	public JThrowStatement(int line, JExpression expr) {
		super(line);
		this.expr = expr;
	}
	
	public JThrowStatement analyze(Context context) { 
		this.expr = expr.analyze(context);
		return this;
	}
	
	 public void codegen(CLEmitter output) {
		 expr.codegen(output);
		 output.addNoArgInstruction(ATHROW);
	 }
	 
	 /**
	     * @inheritDoc
	     */

	    public void writeToStdOut(PrettyPrinter p) {
	        p.printf("<JThrowStatement line=\"%d\">\n", line());
	        p.indentRight();
	        this.expr.writeToStdOut(p);
	        p.indentLeft();
	        p.printf("</JThrowStatement>\n");
	    }

}
