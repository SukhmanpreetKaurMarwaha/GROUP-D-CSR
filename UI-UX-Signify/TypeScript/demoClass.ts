//create class and start transformation of js to TS or earlier example

//public private protected readOnly
class Person{
    public personID:number;
    private greeting:string;
    protected refVal:number;
    constructor(a:number){
        this.personID=a;
        this.greeting="welcome note";
        this.refVal=200;
        console.log("my first ts class object ");
        console.log("person is created with person id "+this.personID);
    }

    //creating the public method here for transformation
    public createPerson():string{
        console.log("call the public method here -->");
        return "Person is created with personid by method "+this.personID+" with "+this.greeting;
    }

    private greetingPerson():string{
        console.log("call private method");
        return this.greeting;
    }

    //previliged by nature js use in ts
    public testPreviliged():string{
        console.log("call previlihed here ");
        return this.greetingPerson();
    }
}

//here to declare the class student access protected in ts code

class Student extends Person{
    public testChildAccess():string{
        return "i am a child accesing the protected one"+this.refVal;
    }
}

let p=new Person(101);
let s=new Student(102);
console.log("call the public method here-->"+p.createPerson);
//console.log("access private->"+p.)
console.log("acess private by previliged in js by nature "+p.testPreviliged());
console.log("call student method here"+s.testChildAccess());