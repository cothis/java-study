var val1 = "난 var야";
function printVal() {
    console.log("val1 : " + val1);
}

printVal();

let val2 = "난 let이야";
function printVal2() {
    console.log("val2 : " + val2);
}

printVal2();


var scope = "global";

function f() {
    var scope = "local";
    console.log(scope);
}

let scope2 = "global";
function f2() {
    let scope2 = "local";
    console.log(scope2);
}

f();
f2();