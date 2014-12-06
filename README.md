exp4j_tld

exp4j JEE JSP Tags

Using JSTL and expression language:
```jsp

<c:set var="expr_str" value="sin(x)" />
<c:set var="x" value="4" />

<expr4j:expr expr="${expr_str}" x="${x}">
    x = ${x}, ${expr_str} = 
</expr4j:expr>
```