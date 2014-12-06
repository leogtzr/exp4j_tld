# exp4j_tld

## exp4j JEE JSP Tags

## Using JSTL and expression language:
```jsp

<c:set var="expr_str" value="sin(x)" />
<c:set var="x" value="4" />

<expr4j:expr expr="${expr_str}" x="${x}">
    x = ${x}, ${expr_str} = 
</expr4j:expr>
```

## Without tag body:

```jsp
<expr4j:expr expr="sin(x)" x="4" />
```

## With other tags:

```jsp
<expr4j:expr x="2" y="3">
    <jsp:attribute name="expr">
        2  + ${x}^2 - cos(sin(x^y))
    </jsp:attribute>
</expr4j:expr>
```

## Custom functions:

```jsp
<%
Function fiboFunc = new Function("fibonacci", 1) {
    @Override
    public double apply(double ... args) {
        double i = 1.0;
        double j = 0.0;
        for (int k = 1; k <= args[0]; k++) {
            j = i + j;
            i = j - i;
        }
        return j;
    }
};
pageContext.setAttribute("fibo", fiboFunc);
%>
```

```jsp
	<expr4j:expr expr="fibonacci(x) + cos(y)^2" customFunction="${fibo}" x="8" y="2">
	</expr4j:expr>
```

leogutierrezramirez@gmail.com
