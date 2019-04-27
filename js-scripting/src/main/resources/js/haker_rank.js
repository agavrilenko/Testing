//Plus Minus
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

//staircase
var n = 6;
function staircase(n) {

var i = 0;
var sp = "";
var ha = "";
for(i=0;i<n;i++){
    sp+=" ";
    ha+="#";
}
for(i=0;i<n;i++){
    console.log(sp.slice(0,n-1-i) + ha.slice(n-1-i,n));
}
}
//mini-max-sum
function miniMaxSum(arr) {

var i = 0;
var sum = 0;
var min = arr[0];
var max = 0;

for(i=0;i<arr.length;i++){
if(max < arr[i]){
max = arr[i];
}
if(min > arr[i]){
min = arr[i];
}
sum+=arr[i];
}
console.log((sum-max) + " " + (sum-min));
}


//birthday cake candies
function birthdayCakeCandles(ar) {

var i = 0;
var cnt = 0;
var max = 0;
for(i=0;i<ar.length;i++){
    max = ar[i]>max?ar[i]:max;
}
i=0;
for(i=0;i<ar.length;i++){
    if(ar[i]==max){
    cnt++;
    }
}
console.log(cnt);
}

/*
 * Complete the timeConversion function below.
 hh:mm:ssAM
 */
function timeConversion(s) {
var am = s.slice(8,10);
var hours = s.slice(0,2);
var rest  = s.slice(2,8);
var newHr = 0;
var result = "";
if(am == "AM"){
    if(hours == "12"){
        hours = "00";
    }
    return hours+rest;
}
if(am == "PM"){
    if(hours == "12"){
        newHr = 12;
    }
    else {
    newHr = parseInt(hours) + 12;
    }
    return newHr + rest;
}
}

/*
 * Complete the gradingStudents function below.
 */
function gradingStudents(grades) {

 var i = 0;
 var newGrades = [];
 var dif = 0;
 var rem = 0;
 for (i = 0; i< grades.length; i++){
    if(grades[i]<38){
        newGrades[i] = grades[i];
        continue;
    }
    rem = grades[i] % 5;
    dif = 5 - rem;
    if(dif < 3){
    newGrades[i] = grades[i] + dif;
    continue;
    }
    newGrades[i] = grades[i];
 }
return newGrades;
}


// Complete the breakingRecords function below.
var data = [10, 5, 20, 20, 4, 5, 2, 25, 1];
data = [12,24,10,24];
data = [3, 4, 21, 36, 10, 28, 35, 5, 24, 42];
function breakingRecords(scores) {

var max = scores[0], min = scores[0], minC=0, maxC = 0;
var x;
var i ;
for( i = 0; i < scores.length;i++){
if(max > scores[i]){
max = scores[i];
maxC +=1;
}
if(min < scores[i]){
min = scores[i];
minC +=1;
}
}

return [minC, maxC];

}

// Complete the birthday function below.
var s = [2,2,1,3,2], d = 4, m = 2;
s = [1,2,1,3,2], d = 3, m=2;
s = [1,1,1,1,1,1], d=3, m =2;
s = [4], d=4, m =1;
function birthday(s, d, m) {
var sum = 0, next = 0, prev = 0;
var i ;
var cnt = 0;
for(i = 0; i<m;i++){
    sum += s[i];
}
if(sum == d){
    cnt++;
    console.log("increased 1 " + cnt);
}
for(i=1;i<s.length-1;i++){
 sum = sum - s[i-1] + s[i+m-1];
    console.log("sum  " + i + " " + cnt);
 if(sum == d){
    cnt++;
    console.log("increased 2 " + cnt);
 }
}
return cnt;

}

var n = 6, k = 5, ar = [1,2,3,4,5,6];
n = 6, k = 3, ar = [1,3,2,6,1,2];
// Complete the divisibleSumPairs function below.
function divisibleSumPairs(n, k, ar) {

var cnt = 0, i = 0, j = 0;
for(i=0;i<ar.length-1;i++){
    for(j=i+1;j<ar.length;j++){
        if((ar[i]+ar[j])%k==0){
            cnt++;
        }
    }
}
return cnt;
}


var arr = [1,1,2,2,3];
arr = [1,4,4,4,5,3];
arr = [1,2,3,4,5,4,3,2,1,3,4];

// Complete the migratoryBirds function below.
function migratoryBirds(arr) {

var s = [0,0,0,0,0], i=0, idx = 0, max = 0;
for(i=0;i<arr.length;i++){
    s[arr[i]-1]++;
}
for(i=0;i<s.length;i++){
    if(max < s[i]){
        max = s[i];
        idx = i+1;
    }
}
return idx;
}



// Complete the dayOfProgrammer function below.
function dayOfProgrammer(year) {

if (year < 1918){
 if( year%4==0){
    return "12.09." + year;
 }
 else{
  return "13.09." + year;
 }
}
if (year == 1918){
    return "26.09.1918";
}
if (year > 1918){
    if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
        return "12.09." + year;
    }
    else {
        return "13.09." + year;
    }

}
}



// Complete the bonAppetit function below.
var bill = [2,4,6], k = 2, b = 3;
bill = [3,10,2,9], k = 1, b = 12;

bill = [3,10,2,9], k = 1, b = 7;
function bonAppetit(bill, k, b) {
var total = 0, i = 0, totalAvg = 0, avg = 0, dif = 0;

for(i=0; i< bill.length;i++){
    total+=bill[i];
}
totalAvg = total/2;
avg = (total - bill[k])/2;
dif = totalAvg - avg;
if(avg == b){
 return "Bon Appetit";
}
else {
    return dif;
}
}

// Complete the sockMerchant function below.
var n = 7, ar = [1,2,1,2,1,3,2];
n = 9, ar = [10,20,20,10,10,30,50,10,20];
function sockMerchant(n, ar) {
var obj = {}, i = 0;

for(i=0; i< ar.length; i++){
    if(typeof obj[ar[i]]=='undefined'){
        obj[ar[i]]=1;
    }else{
        obj[ar[i]]+=1;
    }
}
var cnt = 0;
Object.keys(obj).forEach(function(key,index) {
    if(obj[key] % 2 == 0){
     cnt+=obj[key]/2;
    }else{

    cnt += (obj[key]-1)/2;
    }

});
return cnt;
}


/*
 * Complete the pageCount function below.
 */
 var n = 6, p = 2;
 n = 5, p = 4;
 n = 6, p = 5;

function pageCount(n, p) {

    var dif = 0;
    /*needs to shift by 1 for odd numbers*/
    if(p%2==0){
        dif = n - p;
    }else {
        dif = n - p + 1;
    }
if(dif < p){
    return Math.floor(dif/2);
}else{
    return Math.floor(p/2);
}
}


var n = 8, s = ["D","D","U","U","U","U","D","D"];
n = 8, s = ["U","D","D","D","U","D","U","U"];
// Complete the countingValleys function below.
function countingValleys(n, s) {
var see = 0, i = 0, cnt=0, delta=0;

for(i = 0; i<s.length;i++){
if(s[i]=="U"){
    delta = 1;
}else{
    delta=-1;
}
if(see == 0 && delta == -1){
    cnt+=1;
}
see+=delta;
}
return cnt;
}


