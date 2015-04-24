?function CheckValidDate(mydate)
{
	if (mydate == null || mydate.length == 0)
	return true;

	if (mydate.length != 7)
	{
		alert("??????!!");
		return false;
	}

	var yy = mydate.substr(0,3);
	var mm = mydate.substr(3,2);
	var dd = mydate.substr(5,2);
	var flag;

	if (isNaN(yy)||isNaN(mm)||isNaN(dd))
	{
		alert("??????!!");
		return false;
	}

	//????,????????
	if (!((yy==''&&mm==''&&dd=='')||(yy!=''&&mm!=''&&dd!='')))
	{
		alert("??????!!");
		return false;
	}

	if (parseInt(yy,10)<0)  //????
	{
		alert("??????!!");
		return false;
	}

	if ((parseInt(mm,10)<1)||(parseInt(mm,10)>12))  //????
	{
		alert("??????!!");
		return false;
	}

	if (((parseInt(mm,10)==1)||(parseInt(mm,10)==3)||(parseInt(mm,10)==5)||(parseInt(mm,10)==7)||(parseInt(mm,10)==8)||(parseInt(mm,10)==10)||(parseInt(mm,10)==12))&&((parseInt(dd,10)<1)||(parseInt(dd,10)>31)))  //??????
	{
		alert("??????!!");
		return false;
	}

	if (((parseInt(mm,10)==4)||(parseInt(mm,10)==6)||(parseInt(mm,10)==9)||(parseInt(mm,10)==11))&&((parseInt(dd,10)<1)||(parseInt(dd,10)>30)))  //??????
	{
		alert("??????!!");
		return false;
	}

	if (parseInt(mm,10)==2) //??????
	{
		a =(((parseInt(yy,10)+1911)%100==0)&&((parseInt(yy,10)+1911)%400!=0)||((parseInt(yy,10)+1911)%4!=0));
		b =((parseInt(dd,10)<1)||(parseInt(dd,10)>28));

		if (a&&b)   //?????
		{
			alert("??????!!");
			return false;
		}
		else        //????
		{
			if ((parseInt(dd,10)<1)||(parseInt(dd,10)>29))
		 	{
				alert("??????!!");
				return false;
			}
		}
	}
	if (!((yy='')&&(mm='')&&(dd='')))
	{
		if ((yy='')||(mm='')||(dd=''))
		{
			alert("??????!!");
			return false;
		}
	}
	return(true);
}

function ClearInvalidDate(formIndex,field)
{
	if (false == CheckValidDate(field.value))
	{
		document.forms[formIndex][field.name].value="";
		return false;
	}
	else
	{
		return true;
	}	
}

// ====================================
// ???????
// yyyy -> yyy
// ToROCYear( yyyy ) return yyy
// ====================================
function ToROCYear(yyyy){
	var rYYY = (parseInt(yyyy)-1911).toString();
	if(rYYY.length==2){
			rYYY="0"+rYYY.toString();
	}
	return rYYY;
}

// ====================================
// ??????
// ?????1~9?????01~09
// parseMonth( mm ) return mm
// ====================================
function parseMonth(mm){
	if(mm.length==1){
		mm="0"+mm.toString();
	}
	return mm;
}

// ====================================
// ??????
// ?????1~9?????01~09
// parseDate( dd ) return dd
// ====================================
function parseDate(dd){
	if(dd.length==1){
		dd="0"+dd.toString();
	}
	return dd;
}

// ====================================
// DI???????
// ?"????94?9?5?" -> "0940905"
// parseCHDate( str ) return yyymmdd
// ====================================
function parseCHDate(str){
	var yy = "";
	var mm = "";
	var dd = "";

	if (str.indexOf("????") >= 0) {
		yy = str.substring(str.indexOf("????") + 4, str.indexOf("?"));
	}
	else {
		yy = str.substring(0, str.indexOf("?"));
	}

	if(yy.length==2){
			yy="0"+yy.toString();
	}

	mm = str.substring(str.indexOf("?") + 1, str.indexOf("?"));
	if(mm.length==1){
		mm="0"+mm.toString();
	}

	dd = str.substring(str.indexOf("?") + 1, str.indexOf("?"));
	if(dd.length==1){
		dd="0"+dd.toString();
	}

	return yy+mm+dd;
}


// ====================================
// DI???????
// ? "0940905" -> "????94?9?5?"
// dateToCHDate( str ) return "????yy?mm?dd?"
// ====================================
function parseDateToCHDate(yyymmdd)
{
	var str = "????";
	var yy = yyymmdd.substring(0,3);
	var mm = yyymmdd.substring(3,5);
	var dd = yyymmdd.substring(5,7);

	yy	=	parseInt(yy,10);
	mm	=	parseInt(mm,10);
	dd	=	parseInt(dd,10);

	return str+yy+"?"+mm+"?"+dd+"?";
}
//===================================
// ?????????????
//===================================
function daycount(begDate,endDate,mykey)
{
	//begDate ????
	//endDate ????
	//mykey A-> ?
	//      B-> ?
	//      C-> ?
	//      D-> ?,?
	//      E-> ?,?,?

	year1 = 1911+parseInt(begDate.substring(0,3),10);
	year2 = 1911+parseInt(endDate.substring(0,3),10);
	mon1 = parseInt(begDate.substring(3,5),10);
	mon2 = parseInt(endDate.substring(3,5),10);
	day1 = parseInt(begDate.substring(5,7),10);
	day2 = parseInt(endDate.substring(5,7),10);
	pass = 1;
	
	rtn = "";
	if (mykey=="A")
	{
		rtn = (Math.floor((year2-year1+(mon2-mon1)/12) * 100 + 0.5) / 100)+"?";
	}
	
	if (mykey=="B")
	{
		rtn = Math.floor(((year2-year1)*12+mon2-mon1+(day2-day1)/30)* 100 + 0.5)+"?";
	}
	
	if (mykey=="C")
	{
		//begMyDate = new Date(year1, mon1-1, day1);
		//endMyDate = new Date(year2, mon2-1, day2);
		//rtn = ((endMyDate-begMyDate)/86400000+"?");
		begMyDate = new Date(year1, mon1, day1);
		EbegMyDate = new Date(year1, 12, 31);
		endMyDate = new Date(year2, mon2, day2);
		SbegMyDate = new Date(year2, 1, 1);
		
		if (parseInt(year1)-parseInt(year2)==0)
		{
			rtn = ((endMyDate-begMyDate) / 86400000 + 1 );
		}
		else
		{
			rtn = ((EbegMyDate-begMyDate) / 86400000 + 1 )+((endMyDate-SbegMyDate) / 86400000 + 1 );
		}
		
	}
	
	if (mykey=="D")
	{
		if (mon2<mon1)
		{
			mon2 = mon2+12;
			year2= year2-1;
		}
		rtn = ((year2-year1)+"?"+(mon2-mon1)+"?");
	}
	
	if (mykey=="E")
	{
		if (day2<day1)
		{
			if ((mon2==2)||(mon2==4)||(mon2==6)||(mon2==8)||(mon2==9)||(mon2==11)||(mon2==1)&&(pass==1))
			{
				day2 = day2+31;
				mon2 = mon2-1;
				if (mon2==0)
				{
					year2 = year2-1;
					mon2 = 12;	
				}
				pass = 0;
			}
	
			if ((mon2==5)||(mon2==7)||(mon2==10)||(mon2==12)&&(pass==1))
			{
				day2 = day2+30;
				mon2 = mon2-1;
				pass = 0;
			}
	
			if ((mon2==3)&&(pass==1))
			{
				a =((year2%100==0)&&(year2%400!=0)||(year2%4!=0));
				if (a)
				{
					day2 = day2+28;
					mon2 = mon2-1;
				}else{
					day2 = day2+29;
					mon2 = mon2-1;
				}
				pass = 0;
			}
		}
		if (mon2<mon1)
		{
			mon2 = mon2+12;
			year2= year2-1;
		}
	
		rtn = ((year2-year1)+"?"+(mon2-mon1)+"?"+(day2-day1)+"?");
	}
	if (mykey=="F")
	{

		if (day2<day1)
		{
			if ((mon2==2)||(mon2==4)||(mon2==6)||(mon2==8)||(mon2==9)||(mon2==11)||(mon2==1)&&(pass==1))
			{
				day2 = day2+31;
				mon2 = mon2-1;
				if (mon2==0)
				{
					year2 = year2-1;
					mon2 = 12;	
				}
				pass = 0;
			}
	
			if ((mon2==5)||(mon2==7)||(mon2==10)||(mon2==12)&&(pass==1))
			{
				day2 = day2+30;
				mon2 = mon2-1;
				pass = 0;
			}
	
			if ((mon2==3)&&(pass==1))
			{
				a =((year2%100==0)&&(year2%400!=0)||(year2%4!=0));
				if (a)
				{
					day2 = day2+28;
					mon2 = mon2-1;
				}else{
					day2 = day2+29;
					mon2 = mon2-1;
				}
				pass = 0;
			}
		}
		if (mon2<mon1)
		{
			mon2 = mon2+12;
			year2= year2-1;
		}
		for(i=mon2;i>mon1;i--)
		{
			if ((i==2)||(i==4)||(i==6)||(i==8)||(i==9)||(i==11)||(i==1)||((i-12)==2)||((i-12)==4)||((i-12)==6)||((i-12)==8)||((i-12)==9)||((i-12)==11)||((i-12)==1))
			{
				day2 = day2+31;
			}
	
			if ((i==5)||(i==7)||(i==10)||(i==12)||((i-12)==5)||((i-12)==7)||((i-12)==10)||((i-12)==12))
			{
				day2 = day2+30;
			}
	
			if ((i==3)||((i-12)==3))
			{
				a =((year2%100==0)&&(year2%400!=0)||(year2%4!=0));
				if (a)
				{
					day2 = day2+28;
				}else{
					day2 = day2+29;
		
				}
			}
		}
		rtn = ((year2-year1)+"?"+(day2-day1)+"?");

	}
	return rtn;
}
