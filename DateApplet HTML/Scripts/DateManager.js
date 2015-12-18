var daysInMonth = [31,28,31,30,31,30,31,31,30,31,30,31]
var year = 1994;
var month = 11;
var day = 4;

$(document).ready(function(){ 
    year = new Date().getFullYear();
    month = new Date().getMonth() + 1;
    day = new Date().getDate();
    
    document.getElementById("dateDisplay").innerHTML = "Currently set date: "+internationalString();
});

function setDate() {

    year = document.getElementById("Year").value;
    month = document.getElementById("Month").value;
    day = document.getElementById("Day").value;
    
    document.getElementById("dateDisplay").innerHTML = "Currently set date: "+internationalString();
}
function internationalString(){
    var date = (year+"/"+month+"/"+day)
    return date;
}

function leapYear() {

    var message = "";
    if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))){
        message = year+" is a leap year";
    }
    else{
        message = year+" is not a leap year";
    }
    window.alert(message);
}
function validDate() {
    
    var valid = true;
    if(year < 1)
    {
        valid = false;
    }
    else if(month > 12 || month < 1)
    {
        valid = false;
    }
    else if(month == 2 && ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))))
    {
        if(day > 29)
        {
            valid = false;
        }
    }
    else
    {
        if(day > daysInMonth[month - 1])
        {
            valid = false;
        }
    }
    var message = "";
    if(valid){
        message = internationalString()+" is a valid date";
    }
    else{
        message = internationalString()+" is not a valid date";
    }
    window.alert(message);
}