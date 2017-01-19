
package jminusminus;

import static jminusminus.CLConstants.*;
import java.util.*;

public class JSwitchStatement extends JStatement{
	
	/** Test expression. */
    private JExpression condition;

    /** The body. */
    private ArrayList<JSwitchStatementGroup> body;

    
	public JSwitchStatement(int line, JExpression condition, ArrayList<JSwitchStatementGroup> body) {
		 super(line);
	     this.condition = condition;
	     this.body = body;
	}
	 public JSwitchStatement analyze(Context context) {
//	        condition = condition.analyze(context);
//	        condition.type().mustMatchExpected(line(), Type.BOOLEAN);
//	        body = (JStatement) body.analyze(context);
	        return this;
	 }
	 
	 public void codegen(CLEmitter output) {

	 }

	    /**
	     * @inheritDoc
	     */

	    public void writeToStdOut(PrettyPrinter p) {
	        p.printf("<JSwitchStatement line=\"%d\">\n", line());
	        p.indentRight();
	        p.printf("<TestExpression>\n");
	        p.indentRight();
	        condition.writeToStdOut(p);
	        p.indentLeft();
	        p.printf("</TestExpression>\n");
	        if (body != null) {
	        	p.printf("<Body>\n");
		        p.indentRight();
		        for (JSwitchStatementGroup statement : body) {
		        	
			        	statement.writeToStdOut(p);
		        	
		        }
		        p.indentLeft();
		        p.printf("</Body>\n");
	        }
	        p.indentLeft();
	        p.printf("</JSwitchStatement>\n");
	    }
}


