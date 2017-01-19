// Copyright 2011 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package jminusminus;

import static jminusminus.CLConstants.*;
import java.util.ArrayList;

public class JTryStatement extends JStatement {

	protected JStatement block;
	
	public JTryStatement(int line, JStatement block) {
		super(line);
		this.block = block;
	
	}
	
	public JTryStatement analyze(Context context) {
		
		return this;
	}
	
	 public void codegen(CLEmitter output) {
		 
	 }
	 
	 /**
	     * @inheritDoc
	     */

	    public void writeToStdOut(PrettyPrinter p) {
	        p.printf("<JTryStatement line=\"%d\">\n", line());
	        p.indentRight();
	        this.block.writeToStdOut(p);
	        p.indentLeft();
	        p.printf("</JTryStatement>\n");
	    }

}
