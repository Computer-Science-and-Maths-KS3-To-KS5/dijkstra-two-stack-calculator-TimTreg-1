This project will be composed mainly of a single function named evaluate, which gets an input string (the equation) and outputs the result as a double. This method will contain 2 stacks- the operator stack (for +,-,*,/) and the operand stack for the numbers that are entered. The program will iterate through each token and handle it according to whether it’s a number, operator, open bracket or closed bracket

Psudocode:
PROCEDURE evaluate(expression)
    CREATE empty stack operators
    CREATE empty stack operands
    SPLIT expression into tokens by spaces
    FOR EACH token IN tokens DO
        IF token IS "+" OR "-" OR "* " OR "/" THEN
            PUSH token TO operators
        ELSE IF token IS ")" THEN
            SET op TO POP from operators
            SET right TO POP from operands
            SET left TO POP from operands
            IF op IS "+" THEN
                SET result TO left + right
            ELSE IF op IS "-" THEN
                SET result TO left - right
            ELSE IF op IS " *" THEN
                SET result TO left * right
            ELSE IF op IS "/" THEN
                SET result TO left / right
            ELSE
                RAISE error "Unknown operator"
            ENDIF
            PUSH result TO operands
        ELSE IF token IS NOT "(" THEN
            CONVERT token TO number
            PUSH number TO operands
        ENDIF
    ENDFOR
    RETURN POP from operands
ENDPROCEDURE

