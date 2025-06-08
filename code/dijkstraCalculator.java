import java.util.Stack;

public class dijkstraCalculator {

    public static double evaluate(String expression) {
        Stack<String> operators = new Stack<>();
        Stack<Double> operands = new Stack<>();

        // Split the expression by spaces
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            switch (token) {
                case "(":
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    operators.push(token);
                    break;
                case ")":
                    String op = operators.pop();
                    double right = operands.pop();
                    double left = operands.pop();
                    double result=0;
                    switch (op)
                    {
                        case "+": result =  left + right;break;
                        case "-": result =  left - right;break;
                        case "*": result =  left * right;break;
                        case "/": result =  left / right;break;
                        default: throw new IllegalArgumentException("Unknown operator: " + op);
                    };
                    operands.push(result);
                    break;
                default:
                    // Assume it's a number
                    operands.push(Double.parseDouble(token));
                    break;
            }
        }

        return operands.pop();
    }

    public static void main(String[] args) {
        String expr = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        double result = evaluate(expr);
        System.out.println("Result: " + result); // Should print 101.0
    }
}

