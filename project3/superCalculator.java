import java.util.*;
/**
 * Write a description of class calculator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class superCalculator
{
    protected Stack<Double> operands = new Stack<>();
    protected Stack<String> operators = new Stack<>();
    protected String infixExpression;
    protected String[] Token;
    protected final String allOperator = "()[]{}-+*/%^";
    protected final int precedences[] = { -1, -1, -1, -1, -1, -1, 1, 1, 2, 2, 2, 3 };       // these value match exactly with every char in String allOperator
    
    
    // superCalculator's constructor
    public superCalculator(String infixExpression) throws BracketNotMatchException
    {
        operands = new Stack<>();             // create a new Stack everytime
        operators = new Stack<>();            // create a new Stack everytime
        this.infixExpression = addSpace(infixExpression);
        Token = this.infixExpression.split("\\s+");
        calculate();
    }
    
    // make decision for every calculation in this program
    public void calculate() throws InputMismatchException, BracketNotMatchException
    {
        for (String next: Token) {
            if (allOperator.contains(next))
            {
                if (next.equals("(") || next.equals("{") || next.equals("[") )
                    operators.push(next);
                
                else if (next.equals("}") || next.equals("]") || next.equals(")"))
                {
                    while (!operators.empty() && !operators.peek().equals("") && !operators.peek().equals("{") && !operators.peek().equals("[") && !operators.peek().equals("(")) 
                        cal();
                    
                    if ((next.equals(")") && operators.peek().equals("(")) || (next.equals("]") && operators.peek().equals("[")) || (next.equals("}") && operators.peek().equals("{")))
                        operators.pop();
                        else
                            throw new BracketNotMatchException();
                }
                else {
                    while (!operators.empty() && !operators.peek().equals("") && precedence(next) <= precedence(operators.peek())) 
                        cal();
                    
                    operators.push(next);
                }
            }
            else 
                try {
                    operands.push(Double.parseDouble(next));
                } catch (NumberFormatException E) {
                    throw new InputMismatchException();
                }
        }
        
        while(!operators.empty() && !operators.peek().equals(""))
            cal();
    }
    
    // Calculate 2 number between an operator; brackets exluded
    public void cal() throws EmptyStackException
    {
        double operand1 = operands.pop();
        switch (operators.peek()) {
            case "-": operands.push(operands.pop() - operand1); break;          //perform calculation and push the result back to the operands stack
            case "+": operands.push(operands.pop() + operand1); break;
            case "*": operands.push(operands.pop() * operand1); break;
            case "/": operands.push(operands.pop() / operand1); break;
            case "%": operands.push(operands.pop() % operand1); break;
            case "^": operands.push(Math.pow(operands.pop(), operand1)); break;
        }
        operators.pop();
    }
    
    // Return the operator's precedence
    public int precedence(String sign)
    {
        for(int i = 0; i < allOperator.length(); i++)
            if (sign.equals(Character.toString(allOperator.charAt(i))))
                return precedences[i];
                
        return 100;
    }
    
    // Return a string of an infixExpression with all space added between operators. Ex: " + "
    public String addSpace(String infixExpression)
    {
        String result = "";
        for (int i = 0; i < infixExpression.length(); i++)
        {
            if (allOperator.contains(Character.toString(infixExpression.charAt(i))))
                result += " " + infixExpression.charAt(i) + " ";
                else
                    result += infixExpression.charAt(i);
                }
                
        return result;
    }
    
    // Return a string of the last value in operands stack
    public String toString()
    {
        return ""+ operands.peek()+"\n";
    }
    
    
    
    public static void main(String[] args)
    {
        String expression = "";
        Scanner input = new Scanner(System.in);
        
        while (true) {
            System.out.println("Please enter an infix expression OR type \"exit\" to stop:");
            expression = input.nextLine();
            
            if (expression.equals("exit"))
                break;
            System.out.print(">>  ");
                
            try {
                System.out.println(new superCalculator(expression));
            } catch (InputMismatchException E) {
                System.out.println("Invalid Input");
            } catch (EmptyStackException E) {
                System.out.println("This is not an infix expression");
            } catch (BracketNotMatchException E) {
                System.out.println("Bracket not match");
            }
        }
    }
}
