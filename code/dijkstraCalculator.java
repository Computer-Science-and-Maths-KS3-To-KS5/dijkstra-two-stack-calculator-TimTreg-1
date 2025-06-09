import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class dijkstraCalculator {

    public static double evaluate(String expression) {
        Stack<String> operators = new Stack<>();
        Stack<Double> operands = new Stack<>();

        // Split the expression by spaces
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                operators.push(token);
            } else if (token.equals(")")) {
                String op = operators.pop();
                double right = operands.pop();
                double left = operands.pop();
                double result = 0;
                switch (op) {
                    case "+":
                        result = left + right;
                        break;
                    case "-":
                        result = left - right;
                        break;
                    case "*":
                        result = left * right;
                        break;
                    case "/":
                        result = left / right;
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown operator: " + op);
                }
                ;
                operands.push(result);
            } else if (!token.equals("(")){
                operands.push(Double.parseDouble(token));
            }
        }

        return operands.pop();
    }



public static void main(String[] args) {
    String expr;
    System.out.println("Enter expression: ");
    Scanner in = new Scanner(System.in);
    expr= in.nextLine();
    double result = evaluate(expr);
    System.out.println("Result: " + result); 
}
}

