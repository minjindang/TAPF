function isChineseOnly(s)
{
	if (s.length <= 0)
	{
		return true;
	}
	
	if( !containsSubhedral(s) )
	{
		return (!s.match(/[A-Za-z]+/));
	}
	return false;
}

function containsSubhedral(s)
{
	var bool = false;
	
	var len = s.length;
	if (len <= 0)
	{
		return true;
	}
	
	for (var i = 0; i < len; i++)
	{
		var c = escape(s.charAt(i));
		if (c.charAt(0) == '%')
		{
			if( c == '%0D' || c == '%0A')
			{
			}
			else if (c.charAt(1) == 'A' || c.charAt(1) == 'u' )
			{
			}
			else
			{
				bool = true;
			}
		}
		else
		{
			bool = true;
		}
	}
	return bool;
}

function containsChinese(s)
{
	var len = s.length;
	if (len <= 0)
	{
		return false;
	}
	
	for (var i = 0; i < len; i++)
	{
		var c = escape(s.charAt(i));
		if (c.charAt(0) == '%')
		{
			if (c.charAt(1) == 'A' || c.charAt(1) == 'u')
			{
				return true;
			}
		}
	}
	return false;
}

function isEnglishOnly(s)
{
	if (s.length <= 0)
	{
		return true;
	}
	return !containsChinese(s);
}
