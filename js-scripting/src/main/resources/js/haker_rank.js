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


/*
 * Complete the getMoneySpent function below.
 */
var keyboards = [40,50,60], drives = [5,8,12], b = 60;
keyboards = [3,1], drives = [5,2,8], b = 10;
keyboards = [4], drives = [5], b = 5;
function getMoneySpent(keyboards, drives, b) {
  var i = 0, j = 0, max = -1, tmp = 0;
    for(i=0; i<keyboards.length; i++){
        for(j=0;j<drives.length;j++){
            tmp = keyboards[i] + drives[j];
            if ( tmp <= b && tmp > max ){
                max = tmp;
            }
        }
    }
return max;
}


// Complete the catAndMouse function below.
var x = 2, y = 5, z = 4;
x = 1, y = 2, z = 3;
x = 1, y = 3, z = 2;

function catAndMouse(x, y, z) {

var distAC = Math.abs(x-z), distBC = Math.abs(y-z);
if(distAC < distBC){
    return "Cat A";
}
if(distAC > distBC){
    return "Cat B";
}
return "Mouse C";
}


// Complete the formingMagicSquare function below.
var s = [[3,5,4],[1,5,8],[6,4,2]];
s = [[4,9,2],[3,5,7],[8,1,5]];
s = [[4,8,2],[4,5,7],[6,1,6]];
s = [[4,5,8],[2,4,1],[1,9,7]];
function formingMagicSquare(s) {
var i = 0, j = 0, k = 0, min = Number.MAX_VALUE, dif = 0;
 var etalons = [ 
            [ [ 8, 1, 6 ], [ 3, 5, 7 ], [ 4, 9, 2 ] ], 
            [ [ 6, 1, 8 ], [ 7, 5, 3 ], [ 2, 9, 4 ] ], 
            [ [ 4, 9, 2 ], [ 3, 5, 7 ], [ 8, 1, 6 ] ], 
            [ [ 2, 9, 4 ], [ 7, 5, 3 ], [ 6, 1, 8 ] ], 
            [ [ 8, 3, 4 ], [ 1, 5, 9 ], [ 6, 7, 2 ] ], 
            [ [ 4, 3, 8 ], [ 9, 5, 1 ], [ 2, 7, 6 ] ], 
            [ [ 6, 7, 2 ], [ 1, 5, 9 ], [ 8, 3, 4 ] ], 
            [ [ 2, 7, 6 ], [ 9, 5, 1 ], [ 4, 3, 8 ] ], 
        ]; 
    for(i=0; i<8; i++){
    dif = 0;
        for(j=0;j<3;j++){
            for(k=0;k<3;k++){
                dif += Math.abs(etalons[i][j][k] - s[j][k]);
            }
        }
        if(min > dif){
            min = dif;
        }
    }
    return min;
}



/*
 * Complete the 'pickingNumbers' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY a as parameter.
 */

var a = [1,1,2,2,4,4,5,5,5];
a = [4,6,5,3,3,1];
a = [1,2,2,3,1,2];

function pickingNumbers(a) {
var tmp = [], i = 0, sum = 0;
for(i=0;i<100;i++){
    tmp[i] = 0;
}

for(i=0;i<a.length;i++){
    tmp[a[i]]+=1;
}

sum = tmp[0];
for(i=0;i<tmp.length-1;i++){
    var t = tmp[i] + tmp[i+1];
    if(t > sum){
        sum = t;
    }
}
return sum;
}



// Complete the climbingLeaderboard function below.
var scores = [100,90,90,80], alice = [70,80,105,120];//4,3,1
var scores = [100,100,50,40,40,20,10], alice = [5,25,50,120];//6,4,2,1
var scores = [100,90,90,80,75,60], alice = [50,65,77,90,102];//6,5,4,2,1
var scores = [295,294,291,287,287,285,285,284,283,279,277,274,274,271,270,268,268,268,264,260,259,258,257,255,252,250,244,241,240,237,236,236,231,227,227,227,226,225,224,223,216,212,200,197,196,194,193,189,188,187,183,182,178,177,173,171,169,165,143,140,137,135,133,130,130,130,128,127,122,120,116,114,113,109,106,103,99,92,85,81,69,68,63,63,63,61,57,51,47,46,38,30,28,25,22,15,14,12,6,4],
alice = [5,5,6,14,19,20,23,25,29,29,30,30,32,37,38,38,38,41,41,44,45,45,47,59,59,62,63,65,67,69,70,72,72,76,79,82,83,90,91,92,93,98,98,100,100,102,103,105,106,107,109,112,115,118,118,121,122,122,123,125,125,125,127,128,131,131,133,134,139,140,141,143,144,144,144,144,147,150,152,155,156,160,164,164,165,165,166,168,169,170,171,172,173,174,174,180,184,187,187,188,194,197,197,197,198,201,202,202,207,208,211,212,212,214,217,219,219,220,220,223,225,227,228,229,229,233,235,235,236,242,242,245,246,252,253,253,257,257,260,261,266,266,268,269,271,271,275,276,281,282,283,284,285,287,289,289,295,296,298,300,300,301,304,306,308,309,310,316,318,318,324,326,329,329,329,330,330,332,337,337,341,341,349,351,351,354,356,357,366,369,377,379,380,382,391,391,394,396,396,400];
function climbingLeaderboard(scores, alice) {
var rank = Array(scores.length).fill(1), i = 0, j = scores.length - 1, res = Array(alice.length).fill(0);

for(i=1; i<scores.length;i++){
    if(scores[i-1]==scores[i]){
        rank[i] = rank[i-1];
    }else{
        rank[i] = rank[i-1] + 1;
    }
}
//console.log("rank="+rank);
for(i = alice.length - 1; i>=0; i--){
    res[i] = alice.length - i;
}
//console.log("res=" + res);

j = scores.length - 1;
i = 0;
 while(i < alice.length){
    if(alice[i] < scores[j]){
        res[i] = rank[j] + 1;
        i++;
    }
    if(alice[i] == scores[j]){
        res[i] = rank[j] ;
        i++;
    }
    if(alice[i] > scores[j]){
    if(j<=0){
        if(j == 0){
            res[i] = 1;
        }
        i++;

    }
    if(j>0){
        j--;
        }
    }
//    console.log("i=" + i);
}

return res;
}

// Complete the hurdleRace function below.

var k = 1, height = [1,2,3,3,2];//2
var k = 4, height = [1,6,3,5,2];//2
var k = 7, height = [2,5,4,5,2];//0
function hurdleRace(k, height) {
var i = 0, max = 0, h = 0;

for(i=0; i<height.length;i++){
    max = Math.max(max, height[i]);
}

if(max <= k){
    return 0;
}
else{
return max - k;
}
}


// Complete the designerPdfViewer function below.

var word = "abc", h = [1,3,1,3,1,4,1,3,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5];//9
var word = "zaba", h = [1,3,1,3,1,4,1,3,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,7];//28
function designerPdfViewer(h, word) {
var ar = word.split(''), maxH = 0, i = 0;
for(i=0; i < ar.length; i++){
    maxH = Math.max(h[ar[i].charCodeAt()-97], maxH);
}

return maxH*ar.length;
}


// Complete the utopianTree function below.
var n = 0;//1
var n = 1;//2
var n = 2;//3
var n = 3;//6
var n = 4;//7
var n = 5;//14
function utopianTree(n) {
 var i = 0, h = 0;
 for(i=0; i<= n ;i++){
    if(i%2==0){
        h+=1;
    }else{
        h*=2;
    }
 }

return h;
}


// Complete the angryProfessor function below.
var k = 4, a = [-1,-1,0,0,1,1];//no
var k = 5, a = [-1,-1,0,0,1,1];//yes
var k = 3, a = [-1,-3,4,2];//yes
var k = 2, a = [-1,-3,4,2];//no
function angryProfessor(k, a) {
    var cnt = 0, res = "";
    for(var i = 0; i<a.length;i++){
    if(a[i] <= 0){
        cnt+=1;
    }
    }
    res = (cnt >= k? "NO":"YES");
return res;
}


// Complete the beautifulDays function below.

var i = 20, j = 23, k = 6;//2
var i = 13, j = 45, k = 3;//33
function beautifulDays(i, j, k) {
var cnt = 0, tmp = 0, rev=0;
for(var c=i; c<=j; c++){
tmp = String(c).split("").reverse().join("");
rev = Number(tmp);
    if((Math.abs(c-rev))%k==0){
        cnt++;
    }
}
return cnt;

}


// Complete the viralAdvertising function below.
var n = 1;//2
var n = 2;//5
var n = 3;//9
var n = 4;//15
var n = 5;//24
function viralAdvertising(n) {
var sum = 2, delta = 2;
if(n == 1){
    return sum;
}
for(var i = 2; i<=n;i++){
    delta = Math.floor((delta * 3)/2);
    sum+=delta;
}
return sum;
}


// Complete the saveThePrisoner function below.

var n = 4, m = 6, s = 2;//3 2 + 4 -1+2
var n = 5, m = 2, s = 1;//2
var n = 5, m = 2, s = 2;//3
var n = 7, m = 19, s = 2;//6
var n = 3, m = 7, s = 3;//3
var n = 3, m = 8, s = 3;//1
function saveThePrisoner(n, m, s) {
    var x = (m%n - 1 + s)%n;
    if(x == 0){
    x = n;
    }
    return x   ;
}


// Complete the circularArrayRotation function below.
var a = [3,4,5], k = 2, queries = [1,2];//5,3
var a = [1,2,3], k = 2, queries = [0,1,2];//2,3,1
function circularArrayRotation(a, k, queries) {
var res = Array(queries.length), idx = 0;

    for(var i = 0; i< queries.length;i++){
        idx = queries[i] - k%a.length ;
        if(idx < 0){
            idx += a.length;
        }
        res[i] = a[idx];
    }
return res;
}

// Complete the permutationEquation function below.

var p = [5,2,1,3,4];//4,2,5,1,3
var p = [2,3,1];//2,3,1
var p = [4,3,5,1,2];//1,3,5,4,2
function permutationEquation(p) {
var aux = Array(p.length+1);
var res = Array(p.length);
for(var i = 0;i<p.length;i++){
    aux[p[i]] = i+1;
}
for(var i = 1;i<aux.length;i++){
    res[i-1] = aux[aux[i]];
}
return res;
}



// Complete the jumpingOnClouds function below.

var c = [0,0,1,0], k = 2;//96
var c = [0,0,1,0,0,1,1,0], k = 2;//92
var c = [1,1,1,0,1,1,0,0,0,0], k = 3;//80

function jumpingOnClouds(c, k) {
var idx = -1, e = 100;
while(idx != 0){
if(idx == -1){
    idx = 0;
}
idx = (idx + k)%c.length;
e -= 1;
if(c[idx]!=0){
e-=2;
}
}
return e;
}

// Complete the findDigits function below.
var n = 111;//3
var n = 12;//2
var n = 1012;//3
function findDigits(n) {
var ar = String(n).split(""), cnt = 0;
for(var i = 0; i<ar.length;i++){
if(n%Number(ar[i])==0){
cnt++;
}
}
return cnt;
}



// Complete the extraLongFactorials function below.
var n = 25;
function extraLongFactorials(n) {
var res = 1;
for(var i = 1; i<=n;i++){
res*=i;
}
return res;
}


// Complete the appendAndDelete function below.
var s = "abc", t = "def", k = 6;//Yes
var s = "hackerhappy", t = "hackerrank", k = 9;//Yes
var s = "aba", t = "aba", k = 7;//Yes
var s = "ashley", t = "ash", k = 2;//No
function appendAndDelete(s, t, k) {
var sAr = s.split(""), tAr = t.split(""), i = 0, j = 0, ops = 0;

if(s.length >= t.length){
    while( i < t.length && sAr[i]==tAr[i]){
       i++;
    }
    ops = s.length - i + t.length - i;
}
else {
    while( i < s.length && sAr[i]==tAr[i]){
       i++;
    }

    ops = s.length - i + t.length - i;
}

if((ops <= k && (k-ops)%2==0) || s.length + t.length <= k){
    return "Yes";
}
else{
    return "No";
}
}



// Complete the squares function below.
function squares(a, b) {
    var cnt = 0, i = a, start = 0, end = 0;
    start = Math.ceil(Math.sqrt(a));
    end=Math.floor(Math.sqrt(b));
    return end - start + 1;
}

// Complete the libraryFine function below.
var d1=9, m1=6, y1=2015, d2=6, m2=6, y2=2015;
var d1=2, m1=7, y1=1014, d2=1, m2=1, y2=1015;
function libraryFine(d1, m1, y1, d2, m2, y2) {
if(y1>y2){
    return 10000;
}
if(m1>m2 && y2==y1){
    return (m1-m2)*500;
}
if(d1 > d2 && m1==m2 && y2==y1){
    return (d1 - d2) * 15;
}
return 0;
}


// Complete the cutTheSticks function below.

var arr = [1,2,3];//[3,2,1]
var arr = [5,4,4,2,2,8];//6,4,2,1
var arr = [1,2,3,4,3,3,2,1];//8,6,4,1
function cutTheSticks(arr) {
var ar = Array(1002).fill(0);
var size = 0;
for(var i = 0; i<arr.length;i++){
    if(ar[arr[i]] == 0){
        size++;
    }
    ar[arr[i]]++;
}
var idx = 0, cur = arr.length;
var res = Array(size).fill(0);
res[0] = arr.length;
idx++;
for(var i = 0; i<ar.length; i++){
    if(ar[i]!=0){
        cur -= ar[i];
        res[idx]=cur;
        idx ++;
    }

}
return res.slice(0, res.length-1);
}

