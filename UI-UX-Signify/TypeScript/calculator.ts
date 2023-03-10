class Calculator{
    public num1:number;
    public num2:number;

    constructor(a:number,b:number){
        this.num1=a;
        this.num2=b;
    }

    public add():number{
        console.log("Addition of "+this.num1+" and "+this.num2+" = ");
        return this.num1+this.num2;
    }
    public sub():number{
        console.log("Subtraction of "+this.num1+" and "+this.num2+" = ");
        return this.num1-this.num2;
    }
    public mul():number{
        console.log("Multiplication  of "+this.num1+" and "+this.num2+" = ");
        return this.num1*this.num2;
    }
    public div():number{
        console.log("Division of "+this.num1+" and "+this.num2+" = ");
        return this.num1/this.num2;
    }

   
}

let c=new Calculator(18,9);
console.log(c.add());
console.log(c.sub());
console.log(c.mul());
console.log(c.div());