// function add(a,b){
//     var c=a+b;
//     return c;
// }
// console.log("===================");
// var sum=add(10,20);
// console.log('sum is '+sum);
// console.log("===================");

// var n1=10;
// var str='10';
// if(n1===str){
//     console.log('equal');
    
// }else{
//     console.log('not equal');
    
// }
// console.log("===================");
// console.log(typeof(10));
// console.log(typeof('hello'));
// console.log(typeof true);
// console.log('==============');
// var a=10;
// console.log(typeof a);
// console.log(typeof(a));
// console.log('===========');
// var nums=[10,20,30];
// console.log(typeof nums);
// console.log('============');
// console.log(typeof null);
// console.log(typeof undefined);
// console.log(Array.isArray(nums));
// console.log(Array.isArray([10,20,30]));
// console.log(Array.isArray(a));
// console.log();
var add=(a,b)=>a+b;
console.log('addition using arrow function '+add(10,20));
console.log(`addition using arrow function ${add(10,20)}`);

var sqr=a=>a*a;
var n=sqr(20)
console.log(`square is ${n}`);





