
//All the following grammars were taken from Oracle website.
//https://docs.oracle.com/javase/specs/jls/se7/html/jls-18.html

package jminusminus;

import static jminusminus.CLConstants.*;

import java.util.ArrayList;
/** 
 * 
 * @author trung
 */
public class JForControl extends JStatement {
	
//	protected ArrayList<String> modifiers;
//	
//	protected JVariableDeclaration varDec;
//	
//	protected JExpression expr;
//	
//	protected JStatement statement;
	
	public JForControl(int line) {
		super(line);
	}
		
	public JForControl analyze(Context context) {
        return this;
    }
	
	public void codegen(CLEmitter output) {

    }
	
	public JVariableDeclaration getInit() {
		return null;
	}
	public void setInit(JVariableDeclaration init) {
		
	}
	public JExpression getExpr() {
		return null;
	}
	public JStatement getUpdate() {
		return null;
	}
	 /**
     * @inheritDoc
     */

    public void writeToStdOut(PrettyPrinter p) {
//        p.printf("<JForControl line=\"%d\">\n", line());
//        p.indentRight();
//        statement.writeToStdOut(p);
//        p.indentLeft();
//        p.printf("</JForControl>\n");
//      if (modifiers != null) {
//      p.println("<Modifiers>");
//      p.indentRight();
//      for (String mod : modifiers) {
//          p.printf("<Modifier name=\"%s\"/>\n", mod);
//      }
//      p.indentLeft();
//      p.println("</Modifiers>");
  }
}

