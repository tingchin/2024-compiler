package parser.astNode;

import lexer.Token;
import utils.IoUtils;
import utils.Settings;

public class EqExpNode implements Node {
    // EqExp → RelExp | EqExp ('==' | '!=') RelExp
    private RelExpNode relExpNode;
    private Token operator;
    private EqExpNode eqExpNode;

    public EqExpNode(RelExpNode relExpNode, Token operator, EqExpNode eqExpNode) {
        this.relExpNode = relExpNode;
        this.operator = operator;
        this.eqExpNode = eqExpNode;
    }

    @Override
    public void print() {
        relExpNode.print();
        IoUtils.writeFile(Settings.syntaxOutputPath, "<EqExp>\n");
        if (operator != null) {
            IoUtils.writeFile(Settings.syntaxOutputPath, operator.toString());
            eqExpNode.print();
        }
    }
}
