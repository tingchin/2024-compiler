package parser.astNode;

import utils.IoUtils;
import utils.Settings;

public class ExpNode implements Node {
    private AddExpNode addExpNode;

    public ExpNode(AddExpNode addExpNode) {
        this.addExpNode = addExpNode;
    }

    @Override
    public void print() {
        addExpNode.print();
        IoUtils.writeFile(Settings.syntaxOutputPath, "<Exp>\n");
    }
}
