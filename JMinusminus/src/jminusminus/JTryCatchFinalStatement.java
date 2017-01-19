// Copyright 2011 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package jminusminus;

import static jminusminus.CLConstants.*;
import java.util.ArrayList;

public class JTryCatchFinalStatement extends JStatement {

	protected JTryStatement block;
	
	protected ArrayList<JCatchClause> catchClauses;
	
	protected JFinallyStatement finallyStatement;
	
	public JTryCatchFinalStatement(int line, JTryStatement block, ArrayList<JCatchClause> catchClauses, JFinallyStatement finallyStatement) {
		super(line);
		this.block = block;
		this.catchClauses = catchClauses;
		this.finallyStatement = finallyStatement;
	}
	
	public JTryCatchFinalStatement analyze(Context context) {
		
		return this;
	}
	
	 public void codegen(CLEmitter output) {
		 
	 }
	 
	 /**
	     * @inheritDoc
	     */

	    public void writeToStdOut(PrettyPrinter p) {
	        p.printf("<JTryCatchFinalStatement line=\"%d\">\n", line());
	        p.indentRight();
	        this.block.writeToStdOut(p);
	        if (this.catchClauses != null){ 
	        	for (JCatchClause clause : this.catchClauses) {
	        		clause.writeToStdOut(p);
	        	}
	        }
	        if (this.finallyStatement != null) {
	        	this.finallyStatement.writeToStdOut(p);
	        }
	        p.indentLeft();
	        p.printf("</JTryCatchFinalStatement>\n");
	    }

}
