function isNetscape()
{
   if (document.layers)
      { return true; }
   else
      { return false; }
}

function getBlock(sName)
{
   if (isNetscape())
      { return document.layers[sName]; }
   else
      { return document.all[sName].style; }
}

function hide(block)
{
	if (null != block)
	{
		block.display="none";
	}
}

function show(block)
{
	if (null != block)
	{
		block.display="block";
	}
}

function add(sName)
{
	var block = this.getBlock(sName);
	if (null != block)
	{
		if (null == this.blocks)
		{
			this.blocks = new Array(1);
		}
		else
		{
			this.blocks.length++;
		}

		this.blocks[this.blocks.length-1] = block;
	}
}

function hideAll()
{
	if (null != this.blocks)
	{
		for (var i=0; i<this.blocks.length; ++i)
		{
			this.hide(this.blocks[i]);
		}
	}
}

function display(sName)
{
	if (null != this.blocks)
	{
		this.hideAll();
		if (null != sName)
		{
			var block = this.getBlock(sName);
			for (var i=0; i<this.blocks.length; ++i)
			{
				if (block == this.blocks[i])
				{
					this.defaultIdx = i;
					break;
				}
			}
		}
		this.show(this.blocks[this.defaultIdx]);
	}
}

function BlockManager()
{
	this.blocks = new Array(0);
	this.defaultIdx = 0;
	this.add = add;
	this.display = display;
	this.show = show;
	this.hideAll = hideAll;
	this.hide = hide;
	this.isNetscape = isNetscape;
	this.getBlock = getBlock;
}