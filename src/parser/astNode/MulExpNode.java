package parser.astNode;

import lexer.Token;
import utils.IoUtils;
import utils.Settings;

public class MulExpNode implements Node {
    // MulExp → UnaryExp | MulExp ('*' | '/' | '%') UnaryExp
    private UnaryExpNode unaryExp;
    private Token operator;
    private MulExpNode mulExp;

    public MulExpNode(UnaryExpNode unaryExp, Token operator, MulExpNode mulExp) {
        this.unaryExp = unaryExp;
        this.operator = operator;
        this.mulExp = mulExp;
    }

    @Override
    public void print() {
        unaryExp.print();
        IoUtils.writeFile(Settings.syntaxOutputPath, "<MulExp>\n");
        if (operator != null) {
            IoUtils.writeFile(Settings.syntaxOutputPath, operator.toString());
            mulExp.print();
        }
    }
}
