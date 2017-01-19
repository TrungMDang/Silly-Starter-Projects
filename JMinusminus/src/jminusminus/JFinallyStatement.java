// Copyright 2011 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package jminusminus;

import static jminusminus.CLConstants.*;

public class JFinallyStatement extends JStatement {
	
	protected JStatement statement;
	
	public JFinallyStatement(int line, JStatement finallyStatement) {
		super(line);
		this.statement = finallyStatement;
	}
	
	public JFinallyStatement analyze(Context context) {
		
		return this;
	}
	
	 public void codegen(CLEmitter output) {
		 
	 }
	 
	 /**
	     * @inheritDoc
	     */

	    public void writeToStdOut(PrettyPrinter p) {
	        p.printf("<JFinallyStatement line=\"%d\">\n", line());
	        p.indentRight();
	        if (this.statement != null) {
	        	this.statement.writeToStdOut(p);
	        }
	        p.indentLeft();
	        p.printf("</JFinallyStatement>\n");
	    }

}
