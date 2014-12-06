# exp4j_tld

# exp4j JEE JSP Tags

## Using JSTL and expression language:
```jsp

<c:set var="expr_str" value="sin(x)" />
<c:set var="x" value="4" />

<expr4j:expr expr="${expr_str}" x="${x}">
    x = ${x}, ${expr_str} = 
</expr4j:expr>
```

## Using exp4j jsp tag without tag body:

```jsp
<expr4j:expr expr="sin(x)" x="4" />
```

## Using exp4j jsp tag with other tags:

```jsp
<expr4j:expr x="2" y="3">
    <jsp:attribute name="expr">
        2  + ${x}^2 - cos(sin(x^y))
    </jsp:attribute>
</expr4j:expr>
```

### leogutierrezramirez@gmail.com