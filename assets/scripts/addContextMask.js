//顯示金額型態
// 123456789 => 123,456,789
// 123456.789 => 123,456.789
function addMoneyMask(str)
{
	var isNegative = false;
	str = Number(str);
	if( str < 0 )
	{
		isNegative = true;
		str = 0 - str;
	}
	str = String(str);

	var decimal = "";
	if( str.indexOf('.')>0 )
	{
		decimal = str.substring(str.indexOf('.')+1,str.length);
		str = str.substring(0,str.indexOf('.'));
	}
	if( decimal!= "" )
		decimal = "."+decimal;

	var ss;
	var len = str.length;
	var start = 0;
	ss = str.substr(0,len%3);
	for(var i=0;i<len/3;i++)
	{
		start = len%3+i*3;
		if(ss.length!=0 && ss.length<len+i)
			ss += ",";
		ss += str.substr(start,3);
	}

	if( isNegative )
		ss = "-"+ss;

	return ss+decimal;
}

//timestamp( 2006-03-30 00:00:00.0 )
//顯示日期型態( timestamp => yyy/mm/dd )
//required validations.js
function addDateMask(str)
{
	if( isBlank( TrimAll( str ) ) )
		return "";
	else
	{
		var yy = str.substr(0,4);
			yy = (parseInt(yy)-1911).toString();
		if(yy.length==2)
			yy="0"+yy;

		var mm = str.substr(5,2);
		var dd = str.substr(8,2);
		return yy+"/"+mm+"/"+dd;
	}
}

function addYNMask(str)
{
	if(str=="Y")
  		return ("是");
  	else if(str=="N")
  		return ("否");
  	else
		return "";
}
function addCounterMask(str)
{
	var ss = '';
	var len = str.length;
	if( len<8 )
	{
		for (var i = 0; i < 8-len; i++)
		{
			ss += '0';
		}
	}
	ss += str;
	return ss;
}