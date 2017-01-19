// Copyright 2011 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package jminusminus;

import static jminusminus.CLConstants.*;

import java.util.ArrayList;

/**
 * The AST node for a catch clause statement.
 */

class JCatchClause extends JStatement {

	protected String mod; 
	
	protected ArrayList<TypeName> catchType; 
	
	protected JStatement block;
    /**
     * Construct an AST node for a catch clause statement given its
     * line number, and the expression that is returned.
     * 
     * @param line
     *                line in which the return-statement appears
     *                in the source file.
     * @param expr
     *                the returned expression.
     */

    public JCatchClause(int line, String mod, ArrayList<TypeName> catchType, JStatement block ) {
        super(line);
        this.mod = mod; 
        this.catchType = catchType; 
        this.block = block;
    }

    public JCatchClause analyze(Context context) {
        
        return this;
    }
    public void codegen(CLEmitter output) {
       
    }

    /**
     * @inheritDoc
     */

    public void writeToStdOut(PrettyPrinter p) {
    	p.printf("<JCatchClause line=\"%d\">\n", line());
            p.indentRight();
            if (this.mod != null) {
            	p.printf("<Modifiers>\n");
                p.indentRight();
                p.printf("<Modifier name=\"%s\"/>", this.mod);
                p.indentLeft();
            	p.printf("</Modifiers>\n");
            }
            if (this.catchType != null) {
            	for (TypeName type : this.catchType) {
            		p.printf("<CatchType>\n");
                    p.indentRight();
                    p.printf("<CatchType name=\"%s\"/>\n", type);
                    p.indentLeft();
                	p.printf("</CatchType>\n");
            	}
            }
            block.writeToStdOut(p);
            p.indentLeft();
            p.printf("</JCatchClause>\n");
    }
    
}
