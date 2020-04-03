console.log("hello");
var f = function(a){
a.index++;

};
var b = {index: 45};
f(b);
console.log(b);


function add(x,y){
return Promise.all([x,y]).then(function(values){
return values[0] + values[1];
});
}

var add = function(x,y){
Promise.all([x,y]).then(new function(args){
console.log(x+y+aaaa);
});
}

a typeof == 'something'

var p = Promise.resolve(42);
var p1 = p.then(function(v){
    console.log(v);
    return v*2;
}).then(function(v){
    console.log(v);
});




var p = Promise.resolve( 21 );
var p2 = p.then( function(v){
    console.log( v );
        return new Promise( function(resolve,reject){
            setTimeout( function(){
                resolve( v * 2 );
            }, 100 );
        });
    }).then(function(v){
console.log(v);
});

function plusMin(){
var arr = [1,2,-1,0];
var pos = 0;
 var neg = 0;
  var ze = 0;
var i=0;
for(i=0;i<arr.length;i++){
    if(arr[i]<0){
        neg=neg+1;
    }
    if(arr[i]>0){
        pos=pos+1;
    }
    if(arr[i]==0){
        ze=ze+1;
    }
}
console.log((pos/arr.length).toFixed(6));
console.log((neg/arr.length).toFixed(6));
console.log((ze/arr.length).toFixed(6));
}

//async calls
function delay(time) {
return new Promise( function(resolve,reject){
setTimeout( resolve, time );
} );
}
delay(1000).then( function STEP2(){
console.log( "step 2 (after 100ms)" );
return delay(2000);
}).then( function STEP3(){
console.log( "step 3 (after another 200ms)" );
}).then( function STEP4(){
console.log( "step 4 (next Job)" );
return delay( 5000 );
}).then( function STEP5(){
console.log( "step 5 (after another 50ms)" );
})

//error processing
function delay(time) {
return new Promise( function(resolve,reject){
setTimeout( resolve, time );
} );
}
delay(1000).then( function STEP2(){
foo.bar();
return delay(2000);
}).then( function STEP3(){
console.log( "step 3 (after another 200ms)" );
},
function handle(err){
console.log("something happened");
console.log(err);
return 42;
}).then( function STEP4(msg){
console.log( msg);
})



var p1 = Promise.resolve( 42 );
var p2 = Promise.resolve( "Hello World" );
var p3 = Promise.reject( "Oops" );
Promise.race( [p1,p2,p3] )
.then( function(msg){
console.log( msg );
} );
Promise.all( [p1,p2,p3] )
.catch( function(err){
console.error( err );
} );
Promise.all( [p1,p2] )
.then( function(msgs){
console.log( msgs );
} );



//generators
var x = 0;
function foo() {
x++;
console.log( "x:", x );
}
function bar() {
x++;
}
console.log(x);

x = 0;
function *foo() {
x++;
yield;
console.log( "x:", x );
}
function bar() {
x++;
}

var it = foo();
it.next();
x;
bar();
x;
it.next();


//interleaving generators
function *foo() {
var x = yield 2;
z++;
var y = yield (x * z);
console.log( x, y, z );
}
var z = 1;
var it1 = foo();
var it2 = foo();
var val1 = it1.next().value; // 2 <-- yield 2
var val2 = it2.next().value; // 2 <-- yield 2
val1 = it1.next( val2 * 10 ).value; // 40 <-- x:20, z:2
val2 = it2.next( val1 * 5 ).value; // 600 <-- x:200, z:3
it1.next( val2 / 2 ); // y:300
// 20 300 3
it2.next( val1 / 4 ); // y:10
// 200 10 3

//iterator
var something = (function(){
var nextVal;
return {
// needed for `for..of` loops
[Symbol.iterator]: function(){ return this; },
// standard iterator interface method
next: function(){
if (nextVal === undefined) {
nextVal = 1;
}
else {
nextVal = (3 * nextVal) + 6;
}
return { done:false, value:nextVal };
}
};
})();

var a = [1,3,5,7,9];
for (var v of a) {
console.log( v );
}
// 1 3 5 7 9

for(var i = 0 ; i<5;i++){
console.log(i);
}
//iterator with generator
function *something() {
var nextVal;
while (true) {
if (nextVal === undefined) {
    nextVal = 1;
}
else {
    nextVal = (3 * nextVal) + 6;
}
yield nextVal;
}
}

for (var v of something()) {
console.log( v );
// don't let the loop run forever!
if (v > 500) {
break;
}
}
// 1 9 33 105 321 969


function *foo(){

yield b*2;
yield b*3;
return b;
}


function foo(x,y) {
    ajax(
    "http://some.url.1/?x=" + x + "&y=" + y,
    function(err,data){
        if (err) {
    // throw an error into `*main()`
            it.throw( err );
        }
        else {
        // resume `*main()` with received `data`
            it.next( data );
        }
        }
       );
    }
function *main() {
    try {
        var text = yield foo( 11, 31 );
        console.log( text );
    }
    catch (err) {
        console.error( err );
    }
}
var it = main();
// start it all up!
it.next();

//error handling in generators
function *main() {
var x = yield "Hello World";
// never gets here
console.log( x );
}
var it = main();
it.next();
try {
// will `*main()` handle this error? we'll see!
it.throw( "Oops" );
}
catch (err) {
// nope, didn't handle it!
console.error( err ); // Oops
}

//generator and promise

function foo(x,y) {
//async call
    return request(
        "http://some.url.1/?x=" + x + "&y=" + y
    );
}
//generator is calling async function
function *main() {
    try {
        var text = yield foo( 11, 31 );
        console.log( text );
    }
    catch (err) {
            console.error( err );
        }
    }
//create iterator
var it = main();
var p = it.next().value;
// wait for the `p` promise to resolve
p.then(
//fulfilment
function(text){
    it.next( text );
},
//error
function(err){
    it.throw( err );
}
);

//axync utility to run promise based generators

// thanks to Benjamin Gruenbaum (@benjamingr on GitHub) for
// big improvements here!
function run(gen) {
var args = [].slice.call( arguments, 1), it;
// initialize the generator in the current context
it = gen.apply( this, args );
// return a promise for the generator completing
return Promise.resolve()
.then( function handleNext(value){
// run to the next yielded value
var next = it.next( value );
return (function handleResult(next){
// generator has completed running?
if (next.done) {
return next.value;
}
// otherwise keep going
else {
return Promise.resolve( next.value )
.then(
// resume the async loop on
// success, sending the resolved
// value back into the generator
//Promise-Aware Generator Runner
//handleNext,
// if `value` is a rejected
// promise, propagate error back
// into the generator for its own
// error handling
function handleErr(err) {
return Promise.resolve(
it.throw( err )
)
.then( handleResult );
}
);
}
})(next);
} );
}

//async function
function foo(x,y) {
return request(
"http://some.url.1/?x=" + x + "&y=" + y
);
}
async function main() {
try {
var text = await foo( 11, 31 );
console.log( text );
}
catch (err) {
console.error( err );
}
}
main();

function *foo() {
console.log( "`*foo()` starting" );
yield 3;
yield 4;
console.log( "`*foo()` finished" );
}
function *bar() {
yield 1;
yield 2;
yield *foo(); // `yield`-delegation!
yield 5;
}
var it = bar();
it.next().value; // 1
it.next().value; // 2
it.next().value; // `*foo()` starting
// 3
it.next().value; // 4
it.next().value; // `*foo()` finished
// 5


function *foo() {
console.log( "inside `*foo()`:", yield "B" );
console.log( "inside `*foo()`:", yield "C" );
return "D";
}
function *bar() {
console.log( "inside `*bar()`:", yield "A" );
//Why Delegation?
//Delegating Messages
// `yield`-delegation!
console.log( "inside `*bar()`:", yield *foo() );
console.log( "inside `*bar()`:", yield "E" );
return "F";
}
var it = bar();
console.log( "outside:", it.next().value );
// outside: A
console.log( "outside:", it.next( 1 ).value );
// inside `*bar()`: 1
// outside: B
console.log( "outside:", it.next( 2 ).value );
// inside `*foo()`: 2
// outside: C
console.log( "outside:", it.next( 3 ).value );
// inside `*foo()`: 3
// inside `*bar()`: D
// outside: E
console.log( "outside:", it.next( 4 ).value );
// inside `*bar()`: 4
// outside: F

//web workers
var w1 = new Worker( "http://some.url.1/mycoolworker.js" );
w1.addEventListener( "message", function(evt){
// evt.data
} );

w1.postMessage( "something cool to say" );
//inside worker itself is symmetric "mycoolworker.js"
addEventListener( "message", function(evt){
// evt.data
} );
postMessage( "a really cool reply" );

"Structured Cloning Algorithm" (https://developer.mozilla.org/en-
US/docs/Web/Guide/API/DOM/The_structured_clone_algorithm)

//future capabilities
var v1 = SIMD.float32x4( 3.14159, 21.0, 32.3, 55.55 );
var v2 = SIMD.float32x4( 2.1, 3.2, 4.3, 5.4 );
var v3 = SIMD.int32x4( 10, 101, 1001, 10001 );
var v4 = SIMD.int32x4( 10, 20, 30, 40 );
SIMD.float32x4.mul( v1, v2 ); // [ 6.597339, 67.2, 138.89, 299.97 ]
SIMD.int32x4.add( v3, v4 ); // [ 20, 121, 1031, 10041 ]

var newObj = JSON.parse( JSON.stringify( someObj ) );


function f(...a){
console.log(arguments);
}

var o1 = {
a:3
};
var o2 = {
__proto__: o1,
b:9
};

//interpolating
function upper(s) {
return s.toUpperCase();
}
var who = "reader"
var text =
`A very ${upper( "warm" )} welcome
to all of you ${upper( `${who}s` )}!`;
console.log( text );
// A very WARM welcome
// to all of you READERS!

`you are ${who} yo`;
function bar(strings , ...vars){
    console.log(strings);
    console.log(vars);
}

function bar() {
return function foo(strings, ...values) {
console.log( strings );
console.log( values );
}
}

//string tags
function dollabillsyall(strings, ...values) {
return strings.reduce( function(s,v,idx){
if (idx > 0) {
if (typeof values[idx-1] == "number") {
// look, also using interpolated
// string literals!
s += `$${values[idx-1].toFixed( 2 )}`;
}
else {
s += values[idx-1];
}
}
return s + v;
}, "" );
}
var amt1 = 11.99,
amt2 = amt1 * 1.08,
name = "Kyle";
var text = dollabillsyall
`Thanks for your purchase, ${name}! Your
product cost was ${amt1}, which with tax
comes out to ${amt2}.`
console.log( text );
// Thanks for your purchase, Kyle! Your
// product cost was $11.99, which with tax
// comes out to $12.95.

//arrow functions

//regexp
var re = /\d+\.\s(.*?)(?:\s|$)/y
str = "1. foo 2. bar 3. baz";
str.match( re ); // [ "1. foo ", "foo" ]
re.lastIndex; // 7 -- correct position!
str.match( re ); // [ "2. bar ", "bar" ]
re.lastIndex; // 14 -- correct position!
str.match( re ); // ["3. baz", "baz"]

var re = /(o+.)/g, // <-- look, `g`!
str = "foot book more";
str.match( re ); // ["oot","ook","or"]

var re = /foo/ig;
re.flags;

//Unicode conversion
var s1 = "abc\u0301d",
s2 = "ab\u0107d",
s3 = "ab\u{1d49e}d";
String.fromCodePoint( s1.normalize().codePointAt( 2 ) );
// "ć"
String.fromCodePoint( s2.normalize().codePointAt( 2 ) );
// "ć"
String.fromCodePoint( s3.normalize().codePointAt( 2 ) );
// "𝒞"

var gclef = "\u{1D11E}";
console.log( gclef ); // "𝄞 "
String.fromCodePoint( gclef.normalize().codePointAt( 1 ) );

//iterator
var arr = [1,2,3];
var it = arr[Symbol.iterator]();
it.next(); // { value: 1, done: false }
it.next(); // { value: 2, done: false }
it.next(); // { value: 3, done: false }
it.next(); // { value: undefined, done: true }

var m = new Map();
m.set( "foo", 42 );
m.set( { cool: true }, "hello world" );
var it1 = m[Symbol.iterator]();
var it2 = m.entries();
it1.next(); // { value: [ "foo", 42 ], done: false }
it2.next(); // { value: [ "foo", 42 ], done: false }
