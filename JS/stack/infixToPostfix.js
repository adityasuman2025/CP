Array.prototype.isEmpty = function() {
    return this.length == 0;
}

Array.prototype.peek = function() {
    return this[this.length - 1];
}

function isOperator(char) {
    return ['+', '-', '*', '/', '^', '(', ')'].includes(char)
}

function getWeight(char) {
    if (["+", "-"].includes(char)) {
        return 1;
    } else if (["*"].includes(char)) {
        return 2;
    } else if (["/"].includes(char)) {
        return 3;
    } else if (["^"].includes(char)) {
        return 4;
    }

    return 0;
}

function doCalculation(no1, no2, operator) {
    if (operator == "+") {
        return no1 + no2
    } else if (operator == "-") {
        return no1 - no2
    } else if (operator == "*") {
        return no1 * no2
    } else if (operator == "/") {
        return no1 / no2
    } else if (operator == "^") {
        return no1 ^ no2
    }

    return 0;
}

function infixToPostfix(str) {
    let stack = [];

    let postfix = "";
    for (let i = 0; i < str.length; i++) {
        let char = str[i].trim();
        if (!char) continue; //if character is space

        if (!isOperator(char)) {
            postfix += char;
        } else {
            if (stack.isEmpty()) {
                stack.push(char);
            } else if (char == '(') {
                // opening bracket
                stack.push(char);
            } else if (char == ')') {
                // closing bracket
                
                let top = stack.peek();
                while ((top != "(") && !stack.isEmpty()) {
                    postfix += top;
                    stack.pop();

                    if (!stack.isEmpty()) top = stack.peek();
                }
                stack.pop(); // lastly to remove open bracket `(`
            } else {
                // if top of the stack has less weight than the operator then push the operator in the stack
                // otherwise keep popping till in stack any element with greater weight appears

                let top = stack.peek();
                while ((getWeight(char) <= getWeight(top)) && !stack.isEmpty()) {
                    postfix += top;
                    stack.pop();

                    if (!stack.isEmpty()) top = stack.peek();
                }

                stack.push(char);
            }
        }
    }

    while (!stack.isEmpty()) {
        let topPop = stack.pop();
        postfix += topPop;
    }

    return postfix;
}

let infix = "a+b*(c^d-e)^(f+g*h)-i"; // "A+B*C-D*E";
console.log("infix", infix)

let postfix = infixToPostfix(infix);
console.log("postfix", postfix)