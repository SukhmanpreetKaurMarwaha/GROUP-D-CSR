//console.log("my first typescript code-->");
//some basic concepts of TS
console.log("my first ts code");
//variable and object declaration
let testnum:number=10;
console.log(typeof(testnum));
console.log("value of number here -->"+testnum);

//string
let testString: string="training";
console.log(typeof(testString));
console.log("value of string--> "+testString);


//
let testboolean:boolean=false;
console.log(typeof(testboolean));
console.log("value of string--> "+testboolean);

//
let testany:any="Hello any string";
console.log(typeof(testany));
console.log("value of any:-->"+testany);


//declare arrays i typescript
let myArray:string[]=["amit","angular","react"];
console.log(typeof(myArray));
console.log("print my array--> "+myArray);

//declaration of array
let myAnyArray:any[]=["nidhi",1,1.12,"hello"];
console.log(typeof(myAnyArray));
console.log("call the array here-->"+myAnyArray);

//type of functions or methods in TS code

//normal method with return type
function addNums(num1:number,num2:number):number{
    console.log("here is addition with return type of method number");
    return num1+num2;
}

console.log(addNums(10,10));

//function with optional parameter represent by the ?
function details(id:number,name:string,mail_id?:string){
    console.log("ID- "+id);
    console.log("Name- "+name);
    if(mail_id!=undefined){
        console.log("email- "+mail_id);
    }
}

details(101,"amit");
details(107,"parth","p@yahoo.com");


//default paramete rwith = sign in function impl
function discount(price:number,rate:number=0.50){
    let discount1=price*rate;
    console.log("final discount- "+discount1);
}
discount(1000);
discount(1000,0.30);