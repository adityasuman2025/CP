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
    no1 = Number(no1);
    no2 = Number(no2);

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

    let postfix = "", postFixArr = [];
    for (let i = 0; i < str.length; i++) {
        let char = str[i].trim();
        if (!char) continue; //if character is space

        if (!isOperator(char)) {
            postfix += char;
            postFixArr.push(char);
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
                    postFixArr.push(top);
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
                    postFixArr.push(top);
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
        postFixArr.push(topPop);
    }

    return { postfix, postFixArr };
}

function tokenize(str) { // convert string mathematical equation to array
    let arr = [];

    let prev = str[0], temp = str[0];
    for (let i = 1; i < str.length; i++) {
        if (!isNaN(Number(prev)) && !isNaN(Number(str[i]))) {
            temp += str[i];
        } else if (isNaN(Number(prev)) && !isNaN(Number(str[i]))) {
            temp = str[i];
        } else {
            if (temp.trim()) arr.push(temp.trim());
            if (str[i].trim()) arr.push(str[i].trim());

            temp = "";
        }

        prev = str[i];
    }
    if (temp.trim()) arr.push(temp.trim());

    return arr;
}

function calculate(str) {
    const tokens = tokenize(str);
    const postFix = infixToPostfix(tokens).postFixArr;

    let numbers = [], operators = [];
    postFix.forEach(i => {
        if (isOperator(i)) operators.push(i);
        else numbers.push(i);

        if (numbers.length >= 2 && isOperator(operators.peek())) {
            const second = numbers.pop(), first = numbers.pop();
            const operator = operators.pop();

            numbers.push(doCalculation(first, second, operator));
        }
    });

    return numbers.peek();
}

const infix = "a+b*(c^d-e)^(f+g*h)-i"; // "A+B*C-D*E";
console.log("infix", infix);

const postfix = infixToPostfix(infix).postfix;
console.log("postfix", postfix);

const ans = calculate('1 * (20 -   300      ) ');
console.log("ans", ans);
