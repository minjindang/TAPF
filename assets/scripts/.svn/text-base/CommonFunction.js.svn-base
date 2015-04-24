function clearForm(innerForm)
{
	if (innerForm!=null)
	{
		for (var i = 0; i < innerForm.length; i++)
		{
			if( innerForm[i].type == "text" )
				innerForm[i].value = "" ;
			else if( innerForm[i].type == "select-one" )
				innerForm[i].value = "" ;
			else if( innerForm[i].type == "radio" )
				innerForm[i].checked = false ;
			else if( innerForm[i].type == "checkbox" )
				innerForm[i].checked = false ;
		}
	}
}

function clearForm(C_currform)
{
	for( i = 0 ; i < C_currform.length ; i++)
	{
		if( C_currform[i].type == "text" )
			C_currform[i].value = "" ;
		else if( C_currform[i].type == "radio" )
			C_currform[i].checked = false ;
		else if( C_currform[i].type == "select-one" )
			C_currform[i].value = "" ;
		else if( C_currform[i].type == "checkbox" )
			C_currform[i].checked = false ;
	}
}
function CheckInvalidNumber(mynumber)
{
	if (mynumber == null || mynumber=="")
	{
		return true;
	}
	if (!isInteger(mynumber))
	{
		alert("數字格式錯誤");
		return false;
	}
	return true;
}

function makeExternalCall(url)
{
	var frame = document.reqfram.location.replace(url);	
}

function GoToPage(currform, X)
{
	currform.target = 'bottom';
	currform.action = currform.xaction.value;
	currform.page.value=X;
	currform.submit();
}

// window.open("SomeAction" + buildQueryString(form));
// -> window.open("SomeAction?all=the&form=value
function getRequestDelim()
{
    if (navigator.appName == "Microsoft Internet Explorer")
	{
		return "&amp;";
	}
	else
	{
		return "&";
	}
}
function buildQueryString(form)
{
	var query = "";
	var delimiter = getRequestDelim();
	for (var i = 0; i < form.elements.length; i++)
	{
		if (form.elements[i].name != "")
		{
			if (form.elements[i].type == 'submit'
				|| form.elements[i].type == 'button'
				|| form.elements[i].type == 'radio'
				|| form.elements[i].type == 'reset'
				|| form.elements[i].name == 'ReportHandler' )
			{
				continue;
			}
			query += (query == "" ? "?" : delimiter);
			query += form.elements[i].name + "=" + form.elements[i].value;
		}
	}
	return query;
}

function CheckCompID(CompID)      //檢查統一編號
{
	var wk1, wk2, wk3, wk4, wk5, wk6, wk7, wk8, wk9, wk10, wk_total, wk_check;

	if ( CompID.length != 8 ) return false;

	for ( var i = 0 ; i < 8 ; i++ )
	{
		nNum = CompID.substr(i,1);
		if ( nNum < '0' || nNum > '9' )
		{
			return false;
		}
	}

	wk1 = parseInt(CompID.substr(0,1)) + parseInt(CompID.substr(2,1)) + parseInt(CompID.substr(4,1)) + parseInt(CompID.substr(7,1));
	wk2 = Math.floor(parseInt(CompID.substr(1, 1)) * 2 / 10);
	wk3 = Math.floor(parseInt(CompID.substr(3, 1)) * 2 / 10);
	wk4 = Math.floor(parseInt(CompID.substr(5, 1)) * 2 / 10);
	wk5 = Math.floor(parseInt(CompID.substr(6, 1)) * 4 / 10);
	wk6 = parseInt(CompID.substr(1, 1)) * 2 % 10;
	wk7 = parseInt(CompID.substr(3, 1)) * 2 % 10;
	wk8 = parseInt(CompID.substr(5, 1)) * 2 % 10;
	wk9 = parseInt(CompID.substr(6, 1)) * 4 % 10;
	
	wk_total = wk1 + wk2 + wk3 + wk4 + wk5 + wk6 + wk7 + wk8 + wk9;
	wk_check = wk_total % 10;
	

	if (wk_check == 0)
	{
		return true;
	}
	else
	{
		if (CompID.substr(6,1) == '7')
		{
			wk_total = wk1 + wk2 + wk3 + wk4 + wk6 + wk7 + wk8 + 0;
			wk_total2 = wk1 + wk2 + wk3 + wk4 + wk6 + wk7 + wk8 + 1;
			wk_check1 = wk_total % 10;
			wk_check2 = wk_total2 % 10;
			if (wk_check1 == 0 || wk_check2 == 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	return false;
}

//Made by Grace
function CheckRate(intLen,decLen,myRate)  //(整數位數,小數位數,傳入要檢查的值)
{
	var length = myRate.length;
	
	if (length == 0)
	{
		return false;
	}
	if (length > (intLen + decLen + 1))
	{
		alert("數字格式輸入錯誤");
		return false;
	}

	var a = new Array(intLen + decLen + 1);
	var iLen,dLen;
	var check;
	
	iLen = 0;
	dLen = 0;
	check = false;

	for (var i = 0; i < length; i++)
	{
		a[i] = myRate.charAt(i);
		if (a[i]==".")
			check = true;
		else
		{
			if (check == false)
				iLen = iLen + 1;    //整數位數
			else
				dLen = dLen + 1;    //小數位數
		}
	}

	if (iLen > intLen)
	{
			alert("數字格式輸入錯誤");
			return false;
	}		

	if (dLen > decLen)
	{
			alert("數字格式輸入錯誤");
			return false;
	}	

	var vint = myRate.substr(0,iLen);
	var vden = myRate.substr(iLen+1 ,dLen);

	if (isNaN(vint) || isNaN(vden))
	{
			alert("數字格式輸入錯誤");
			return false;
	}
	return true;	
} 

function checkedAll(form)
{
	var currform = form;
	var len = currform.elements.length;
	for( var i=0 ; i<len ; i++)
	{
		if (currform.elements[i].type == "checkbox" )
		{
			currform.elements[i].checked = true;
		}
	}
}
function notCheckedAll(form)
{
	var currform = form;
	var len = currform.elements.length;
	for( var i=0 ; i<len ; i++)
	{
		if (currform.elements[i].type == "checkbox" )
		{
			currform.elements[i].checked = false;
		}
	}
}   
function popWin(sqlString){
	var aWindow=window.open('','popWin','scrollbars =yes,height=200,width=300,status=no,toolbar=no,menubar=no,location=no,top=0,left=0');	
	aWindow.document.write("<br><br><br><center>連線中請稍待...</center>");
	aWindow.document.close;
	aWindow.location = "popwin?sql="+sqlString;
	aWindow.focus();	
}
function popWin2(sqlString,showColumnCount){
	var aWindow=window.open('/tapf/common/empty.jsp','popWin','scrollbars =yes,height=200,width=300,status=no,toolbar=no,menubar=no,location=no,top=0,left=0');	
	aWindow.document.write("<br><br><br><center>連線中請稍待...</center>");
	aWindow.document.close;
	aWindow.location = "popwin?sql="+sqlString+"&count="+showColumnCount;
	aWindow.focus();	
}
function CalcByteLength(val)
{
	var vlen = 0;
	for(i=0;i<val.length;i++)
	{
		var c = val.substring(i,i+1);
		if( c.charCodeAt(0)>=0 && c.charCodeAt(0)<128 )
			vlen = vlen + 1;
		else
			vlen = vlen + 2;
	}
	return vlen;
}

function isValidAmount(val)
{
	if( val.indexOf(".") > 0 )
	{
		if( val.indexOf(".") > 16 )
		{
			alert("金額位數有誤，請確認!");
			return false
		}
		else
			return true;
	}
	else
	{
		if( val.length>20 )
		{
			alert("金額位數有誤，請確認!");
			return false
		}
		else
			return true;
	}
}

function isValidRate(val)
{
	if( val.indexOf(".") > 0 && val.indexOf(".") > 3 )
	{
		if( val.indexOf(".") > 3 )
		{
			alert("金額位數有誤，請確認!");
			return false
		}
		else
			return true;
	}
	else
	{
		if( val.length>13 )
		{
			alert("金額位數有誤，請確認!");
			return false
		}
		else
			return true;
	}
}

function replaceAll(str,char1,char2)
{
	try{
		for (var i=0;i<str.length;i++)
		{
			str	=	str.replace(char1, char2);
		}
	}catch( e ){
		return "";
	}
	return str;
}
