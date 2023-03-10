//create class and start transformation of js to TS or earlier example
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
//public private protected readOnly
var Person = /** @class */ (function () {
    function Person(a) {
        this.personID = a;
        this.greeting = "welcome note";
        this.refVal = 200;
        console.log("my first ts class object ");
        console.log("person is created with person id " + this.personID);
    }
    //creating the public method here for transformation
    Person.prototype.createPerson = function () {
        console.log("call the public method here -->");
        return "Person is created with personid by method " + this.personID + " with " + this.greeting;
    };
    Person.prototype.greetingPerson = function () {
        console.log("call private method");
        return this.greeting;
    };
    //previliged by nature js use in ts
    Person.prototype.testPreviliged = function () {
        console.log("call previlihed here ");
        return this.greetingPerson();
    };
    return Person;
}());
//here to declare the class student access protected in ts code
var Student = /** @class */ (function (_super) {
    __extends(Student, _super);
    function Student() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    Student.prototype.testChildAccess = function () {
        return "i am a child accesing the protected one" + this.refVal;
    };
    return Student;
}(Person));
var p = new Person(101);
var s = new Student(102);
console.log("call the public method here-->" + p.createPerson);
//console.log("access private->"+p.)
console.log("acess private by previliged in js by nature " + p.testPreviliged());
console.log("call student method here" + s.testChildAccess());
