var Calculator = /** @class */ (function () {
    function Calculator(a, b) {
        this.num1 = a;
        this.num2 = b;
    }
    Calculator.prototype.add = function () {
        console.log("Addition of " + this.num1 + " and " + this.num2 + " = ");
        return this.num1 + this.num2;
    };
    Calculator.prototype.sub = function () {
        console.log("Subtraction of " + this.num1 + " and " + this.num2 + " = ");
        return this.num1 - this.num2;
    };
    Calculator.prototype.mul = function () {
        console.log("Multiplication  of " + this.num1 + " and " + this.num2 + " = ");
        return this.num1 * this.num2;
    };
    Calculator.prototype.div = function () {
        console.log("Division of " + this.num1 + " and " + this.num2 + " = ");
        return this.num1 / this.num2;
    };
    return Calculator;
}());
var c = new Calculator(18, 9);
console.log(c.add());
console.log(c.sub());
console.log(c.mul());
console.log(c.div());
