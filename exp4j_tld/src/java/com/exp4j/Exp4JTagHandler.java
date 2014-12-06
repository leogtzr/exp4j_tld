package com.exp4j;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;

/**
 * @author Leo Gutierrez R. <leogutierrezramirez@gmail.com>
 */
public class Exp4JTagHandler extends SimpleTagSupport 
implements DynamicAttributes {
    
    private String expr;
    private Map<String, Object> tagsAttrs = new HashMap<String, Object>();

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
            
            ExpressionBuilder e = new ExpressionBuilder(expr);
            for(String varName : tagsAttrs.keySet()) {
                e.variable(varName);
            }
            
            Expression expresionParser = e.build();
            
            for(String varName : tagsAttrs.keySet()) {
                expresionParser.setVariable(varName, (Double)tagsAttrs.get(varName));
            }
            out.println(expresionParser.evaluate());
        } catch (java.io.IOException ex) {
            throw new JspException("Error in MathParseTagHandler tag", ex);
        }
        
    }

    public void setExpr(String expr) {
        this.expr = expr;
    }
    
    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        try {
            tagsAttrs.put(localName, Double.parseDouble(value.toString()));
        } catch(NumberFormatException ex) {
            throw new JspException(value.toString() + " -> incorrect numeric value.");
        }
    }
    
}
