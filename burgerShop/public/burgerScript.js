
var crust="";
var crustArray=["Hard","Thin","Soft"];
var filling="";
var fillingArray=["Chicken Tikka","Paneer Tikka","Turkey Meat"];
var toppings=[];
var toppingsArray=["Cucumber","Tomato","Meat Strip","Cabbage"];
var amount=0;
var items={'Hard':10,'Thin':10,'Soft':12,'Chicken Tikka':120,'Paneer Tikka':100,'Turkey Meat':130,'Cucumber':25,'Tomato':20,'Meat Strip':45,'Cabbage':20};


function limitOfCheckBox(){
	$("input:checkbox").click(function() {
var bol = $("input:checkbox:checked").length >= 3;     
$("input:checkbox").not(":checked").attr("disabled",bol);
});
}

function orderPage(){
	
	
	var todaySpecial =$("<button></button>").attr({
		"onclick":"todaySpecial()","id":"todayBurger"
	}).text("Order 'Burger' of the day");
	
	
	var ownBurger =$("<button></button>").attr({
		"onclick":"ownBurger()","id":"ownBurger"
	}).text("Order your Own Burger");
	
	
	var exist =$("<button></button>").attr({
		"onclick":"exist()","id":"exist"
	}).text("Exist");
	
	
	$(".mainDiv").empty();
	$(".mainDiv").append(todaySpecial,ownBurger,exist);
}

function ownBurger(){
	
	var veg =$("<button></button>").attr({
		"onclick":"veg()","id":"veg"
	}).text("Veg Burger");
	
	
	var nonVeg =$("<button></button>").attr({
		"onclick":"nonVeg()","id":"nonVeg"
	}).text("Non-Veg Burger");
	
	
	$(".mainDiv").empty();
	$(".mainDiv").append(veg,nonVeg);

}

function veg(){
		$(".mainDiv").empty();
	    $(".veg").show();
}

function nonVeg(){
	    $(".mainDiv").empty();
	    $(".nonVeg").show();
}

function billTable(){

	crust=$('input[name="Crust"]:checked').val();
	if(crust){
		amount+=items[crust];
	}
	else{
		alert("Select Crust");
	}
	Filling=$('input[name="Filling"]:checked').val();
	if(Filling){
		amount+=items[Filling];
	}
	else{
				alert("Select Filling");
	}
	$('input:checkbox[name=toppings]:checked').each(function(c) 
{
	toppings[c]=$(this).val();
	amount+=items[$(this).val()];
});
if(toppings.length<1){
					alert("Select Topping");

}
	    $(".veg").hide();
	    $(".nonVeg").hide();

    console.log(crust);
    console.log(filling);
    console.log(toppings);
    console.log(amount);
    $(".mainDiv").append(crust);
    $(".mainDiv").append("="+items[crust]);
    $(".mainDiv").append($("<br>"));
    $(".mainDiv").append(Filling);
    $(".mainDiv").append("="+items[Filling]+"<br>");
    var count=0;
    jQuery.each(toppings,function(i,val){
	if(toppings.length>2){
		console.log(count);
		if(count==0&&(val=="Tomato"||val=="Cabbage")){
			$(".mainDiv").append(val);
	        $(".mainDiv").append("="+0+"<br>");
	        amount-=20;
	        count=1;
	        console.log(count);
		}
		else{
			$(".mainDiv").append(val);
	        $(".mainDiv").append("="+items[val]+"<br>");
		}
	}
	else{
		$(".mainDiv").append(val);
	$(".mainDiv").append("="+items[val]+"<br>");
	}
});
    $(".mainDiv").append("Total Amount ="+amount);
    
    var confirm =$("<br><button></button>").attr({
		"onclick":"confirm()","id":"confirm"
	}).text("Confirm Order");
	$(".mainDiv").append(confirm);
}

function todaySpecial(){
	   $("#todayBurger").hide();
	   $("#ownBurger").hide();
	   $("#exist").hide();
	console.log(Math.floor(Math.random()*crustArray.length));
	crust=crustArray[Math.floor(Math.random()*crustArray.length)];
	amount+=items[crust];
	Filling=fillingArray[Math.floor(Math.random()*fillingArray.length)];
	amount+=items[Filling];
    toppings[1]=toppingsArray[Math.floor(Math.random()*toppingsArray.length)];
    amount+=items[toppings[1]];

	console.log(crust);
    console.log(filling);
    console.log(toppings);
    console.log(amount);
    $(".mainDiv").append(crust);
    $(".mainDiv").append("="+items[crust]);
    $(".mainDiv").append($("<br>"));
    $(".mainDiv").append(Filling);
    $(".mainDiv").append("="+items[Filling]+"<br>");
    $(".mainDiv").append(toppings[1]);
    $(".mainDiv").append("="+items[toppings[1]]+"<br>");
    $(".mainDiv").append("Total Amount ="+amount);
    
    var confirm =$("<br><button></button>").attr({
		"onclick":"confirm()","id":"confirm"
	}).text("Confirm Order");
	$(".mainDiv").append(confirm);
}

function confirm(){
	var output=$("<p></p>").text("Your Burger Shop order is placed for "+amount+" ₹.");
	$(".mainDiv").hide();
	$(".output").append(output);
}

function exist(){
	$("#todayBurger").hide();
	$("#ownBurger").hide();
	$("#exist").hide();
	var order =$("<button></button>").attr({
		"onclick":"orderPage()","class":"order"
	}).text("Order");
	$(".mainDiv").append(order);

}