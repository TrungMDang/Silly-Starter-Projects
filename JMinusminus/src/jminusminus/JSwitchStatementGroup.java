
package jminusminus;

import static jminusminus.CLConstants.*;

public class JSwitchStatementGroup extends JStatement{
	
	protected JSwitchLabel label;
	
	protected JStatement block;
	
	public JSwitchStatementGroup(int line, JSwitchLabel label, JStatement block) {
		super(line);
		this.label = label;
		this.block = block;
	}
	
	public JSwitchStatementGroup analyze(Context context) {

		return this;
	}
	
	 public void codegen(CLEmitter output) {

	 }
	 /**
     * @inheritDoc
     */

    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JSwitchGroup line=\"%d\">\n", line());
        p.indentRight();
        label.writeToStdOut(p);
        block.writeToStdOut(p);
        p.indentLeft();
        p.printf("</JSwitchGroup>\n");
    }
}
