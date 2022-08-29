const largestRectangleArea = function(arr) {
    let area = 0;
    let maxArea = 0;
    
    let i = 0;
    let length = arr.length;
    
    let stack = []
    while (i < length) {
        if ((stack.isEmpty()) || arr[i] >= arr[stack.peek()]) {
            stack.push(i++);
        } else {
            let top = stack.pop();
            if (stack.isEmpty()) { //if stack is empty
                area = arr[top] * i;
            } else {
                area = arr[top] * ((i-1) - stack.peek());
            }
            
            maxArea = Math.max(area, maxArea);
        }
    }
    
    while (!stack.isEmpty()) {
        let top = stack.pop();
        if (stack.isEmpty()) { //if stack is empty
            area = arr[top] * i;
        } else {
            area = arr[top] * ((i-1) - stack.peek());
        }

        maxArea = Math.max(area, maxArea);
    }
    
    return maxArea;
};

Array.prototype.peek = function() {
    return this[this.length-1];
}

Array.prototype.isEmpty = function() {
    return this.length == 0;
}

let heights = [2,1,5,6,2,3]
let maxHeight = largestRectangleArea(heights);

console.log("maxHeight", maxHeight)