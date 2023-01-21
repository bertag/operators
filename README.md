# Operators

Null-safe arithmetic operators for Java and Kotlin.

This library implements addition, subtraction, multiplication, division, and linear scaling for nullable numbers and provides tooling for these basic arithmetic operations when applied to nullable objects.

## Numeric Operations

When both operands are null, null is returned:

| `a`  | `b`  | Operation     | Result  |
|------|------|---------------|---------|
| null | null | `plus(a, b)`  | null    |
| null | null | `minus(a, b)` | null    |
| null | null | `times(a, b)` | null    |
| null | null | `div(a, b)`   | null    |
| null | null | `scale(a, b)` | null    |

When both operands are non-null, they are converted to their corresponding primitive values and the appropriate math operation is invoked.  Just as with normal primitive operations, data may be truncated (e.g. `5 / 4 = 1` if both operands are integers) or may overflow (e.g. `1 + 32767 = -32678` if both operands are short).  Specific to `scale` operations, when the first argument is integer-based (integers, longs, and shorts), the result will be rounded to the nearest integer.

| `a` | `b` | Operation     | Result                  |
|-----|-----|---------------|-------------------------|
| 2   | 1   | `plus(a, b)`  | 3                       |
| 3   | 2   | `minus(a, b)` | 1                       |
| 4   | 3   | `times(a, b)` | 12                      |
| 5.0 | 4.0 | `div(a, b)`   | 1.25                    |
| 6.0 | 5.0 | `scale(a, b)` | 30                      |
| 3L  | 1.5 | `scale(a, b)` | 5 (rounded up from 4.5) |

Except for `scale`, when one operand is non-null but the other operand is null, the null operand is substituted by a fallback/default value before the appropriate math is performed.  The fallback values (`0` for addition and subtraction; `1` for multiplication and division) have been chosen to best preserve identity and reflexive equality for each operation, as shown in the table below:

| `a`   | `b`   | Operation      | Substitution | Result | Demonstration of Identity/Equality      |
|-------|-------|----------------|--------------|--------|-----------------------------------------|
| 2     | null  | `plus(a, b)`   | `b = 0`      | 2      | `a+b = a+b` ⇒ `a+b-b = a` ⇒ `2+0-0 = 2` |
| 3     | null  | `minus(a, b)`  | `b = 0`      | 3      | `a-b = a-b` ⇒ `a-b+b = a` ⇒ `3-0+0 = 3` |
| 4     | null  | `times(a, b)`  | `b = 1`      | 4      | `a*b = a*b` ⇒ `a*b/b = a` ⇒ `4*1/1 = 4` |
| 5     | null  | `div(a, b)`    | `b = 1`      | 5      | `a/b = a/b` ⇒ `a/b*b = a` ⇒ `5/1*1 = 5` |
| null  | 2     | `plus(a, b)`   | `a = 0`      | 2      | `a+b = a+b` ⇒ `a+b-b = a` ⇒ `0+2-2 = 0` |
| null  | 3     | `minus(a, b)`  | `a = 0`      | -3     | `a-b = a-b` ⇒ `a-b+b = a` ⇒ `0-3+3 = 0` |
| null  | 4     | `times(a, b)`  | `a = 1`      | 4      | `a*b = a*b` ⇒ `a*b/b = a` ⇒ `1*4/4 = 1` |
| null  | 5.0   | `div(a, b)`    | `a = 1`      | 0.2    | `a/b = a/b` ⇒ `a/b*b = a` ⇒ `1/5*5 = 1` |

For `scale` only, the behavior of one null operand is slightly different.  If the first operand is null, then the result is null; if the second operand (the factor) is null, then `1.0` will be substituted as the factor:

| `a`  | `b`  | Operation     | Result |
|------|------|---------------|--------|
| null | 2    | `scale(a, b)` | null   |
| 2    | null | `scale(a, b)` | 2      |

## Object Operations

In addition to numeric operations, this library supports addition, subtraction, multiplication, and division of Objects.  In Java (which does not support operator overloading) this is done using a utility class.  In Kotlin, extension functions are defined to allow for null-safe operator overloading.

Consider the following record:

```java
record MyObj(Integer foo, Double bar) implements Addable<MyObj> {
    
    @Override
    public MyObj plus(MyObj other) {
        return new MyObj(
                Ops.plus(foo, other.foo),
                Ops.plus(bar, other.bar)
        );
    }
}
```

By implementing the `Addable` interface, we can now use `MyObj` as a valid target in the Ops methods:

```java
MyObj a = new MyObj(1, 2.0);
MyObj b = new MyObj(3, 4.0);
MyObj c = Ops.plus(a, b); // yields MyObj(4, 6.0)
```

Similar to what was discussed earlier with numeric operations, for addition, subtraction, multiplication, and division, if both inputs are null, then null is returned.  If only one input is null, then the non-null input is returned (the original is returned, **not** a copy!).  If both arguments are non-null, then the appropriate operator method is called using the two inputs.

For scale operations, if the first input is null, then null is returned; if the second input (the factor) is null, then the first input is returned.  Only if both arguments are non-null will the scaling method be executed.

Note that the Ops utility class makes no guarantees about the specific behavior or safety of the implementation of each operator method.  Developers are encouraged to give thought to null-safety, divide-by-zero, and other potential edge cases when implementing `plus`, `minus`, `times`, `div`, and `scale`.


## The `op` and `apply` Methods

Under the hood, each of the Ops methods discussed above use a general-purpose `op` method, except for scale — which uses a similar method `apply`.  Recognizing that implementing `Addable` et al. may not be possible for all use cases, these methods are made public so that developers can define addition, subtraction, multiplication, division, and scaling for plain objects (similar to how Comparable can be used to define custom sorting or sorting of objects having no natural ordering of their own):

Once again, consider the following record (note the absence of any operator interface declaration):

```java
record MyObj(Integer foo, Double bar) {}
```

Despite the lack of any operator interface, we can still perform arithmetic operations on `MyObj`.  But in order to do so, we must externally define what it will look like (for the "both inputs are non-null" case only):

```java
BinaryOperator<MyObj> plus = (x, y) ->
        new MyObj(Ops.plus(x.foo, y.foo), Ops.plus(x.bar, y.bar));

MyObj a = new MyObj(1, 2.0);
MyObj b = new MyObj(3, 4.0);
MyObj c = Ops.op(a, b, plus); // yields MyObj(4, 6.0)
```

```java
BiFunction<MyObj, Double, MyObj> scale = (x, factor) ->
        new MyObj(Ops.scale(x.foo, factor), Ops.scale(x.bar, factor));

MyObj src = new MyObj(1, 2.0);
double factor = 2.0;
MyObj result = Ops.apply(src, factor, scale); // yields MyObj(2, 4.0)
```