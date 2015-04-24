/*
 * OptionManager Object Definitions
 * Revision v1.2
 */
 
/*
 * v1.2: move the selectedIndex setting for each group to OptionManager
 */

/* OptionManager --
 *	OptionManager initialization
 */
function OptionManager()
{
    this.init = true;
	this.depth = 0;
	this.root = new OptGroup();
	this.viewers = new Array();
    this.initValues = new Array();
    this.selectedIndices = new Array();
}

/*
 * getDepth() method --
 *	to obtain the option depth managed by the Option Manager
 */
OptionManager.prototype.getDepth = function()
{
	if (0 <= this.depth)
	{
		return this.depth;
	}
	return 0;
}

/*
 * increaseDepth() method --
 *	to increase the option depth managed by the Option Manager and return the
 *  original depth before increment
 */
OptionManager.prototype.increaseDepth = function()
{
	var oriDepth = this.depth++;
	return oriDepth;
}
	
/*
 * isInit() method --
 *	to check if the Option Manager is in the initialization status
 */
OptionManager.prototype.isInit = function()
{
	return this.init;
}

/*
 * setInit() method --
 *	to set the initialization status of the Option Manager
 *
 *	flag	: true(initialization) or false(non-initialization)
 */
OptionManager.prototype.setInit = function(flag)
{
	this.init = flag;
}

/*
 * getRoot() method --
 *	to get the root Option Group associated within the Option Manager.
 *	If there's no root found, a new one will be automatically created and return
 */
OptionManager.prototype.getRoot = function()
{
	if (null == htis.root)
	{
		this.setRoot(new OptGroup());
	}
	return this.root;
}

/*
 * setRoot() method --
 *	to set the root Option Group associated within the Option Manager
 */
OptionManager.prototype.setRoot = function(group)
{
	this.root = group;
}

/*
 * getViewer() method --
 *	to get the viewer element of the given depth
 * 
 *	depth	: the depth of the viewer
 */
OptionManager.prototype.getViewer = function(depth)
{
	return this.viewers[depth];
}

/*
 * getViewerOption() method --
 *	to get the idx-th option of the viewer element of the given depth.
 *	if idx is not given, return the currently selected option
 *
 *	depth	: the depth of the viewer
 *	idx		: the idx of the option of the viewer 
 */
OptionManager.prototype.getViewerOption = function(depth, idx)
{
	var viewer = this.getViewer(depth);
	if (idx && 0 <= idx && viewer.length > idx)
	{
		return viewer.options[idx];
	}

	return viewer.options[viewer.selectedIndex];
}

/*
 * getInitValue() method --
 *	to get the initialized value setup for the given depth
 * 
 *	depth	: the depth of initialized value
 */
OptionManager.prototype.getInitValue = function(depth)
{
	return this.initValues[depth];
}

/*
 * setInitValue() method --
 *	to set the initialized value for the given depth
 * 
 *	depth	: the depth of initialized value
 *	value	: the value to be set as the initialized
 */
OptionManager.prototype.setInitValue = function(depth, value)
{
	this.initValue[depth] = value;
}

/*
 * getSelectedIndex() method --
 *	to get the selected option index for the given depth
 *
 *	depth	: the depth 
 */
OptionManager.prototype.getSelectedIndex = function(depth)
{
	return this.selectedIndices[depth];
}

/*
 * setSelectedIndex() method --
 *	to set the selected option index for the given depth
 * 
 *	depth	: the depth
 *	idx		: the selected option index to be set
 */
OptionManager.prototype.setSelectedIndex = function(depth, idx)
{
	var index = (0 <= idx)? idx : 0;
	this.selectedIndices[depth] = index;
} 


/*
 * addViewer() method --
 *	to associate the Option Manager with viewers
 *
 *	formName	: the viewer's associated form name
 *	elementName	: the viewer's element name, should be a <select> element
 *	initValue	: the init value of the viewer. default to the first record
 */
OptionManager.prototype.addViewer = function (formName, elementName, initValue)
{
	var form = eval("document." + formName);
	for (var i=0; i<form.length ;++i)
	{
		var element = form.elements[i];
		if (elementName == element.name)
		{
			if ("select-one" == element.type)
			{
                if (initValue)
                {
                    this.initValues[this.getDepth()] = initValue;
                }
				this.viewers[this.increaseDepth()] = element;
			}
		}
	}
}

/*
 * getSelectedOptions() method --
 *	to find the current working OptGroup elements of the given depth
 *
 *	depth	: the depth to find
 */
OptionManager.prototype.getSelectedOptions = function(depth)
{
	if ((this.getDepth() > depth) && (0 <= depth))
	{
		var group = this.root;
		
		for (var i=0; i<=depth; ++i)
		{
			if (i == depth)
			{
				return group;
			}
			group = group.options[this.getSelectedIndex(i)].child;
		}	
	}
	return null;
}

/*
 * setValue() method --
 *	to directly set value that will affect to the associated viewer
 *
 *	depth	: the depth of the value to be set
 *	value	: the value to be set
 */
OptionManager.prototype.setValue = function(depth, value)
{
	var group = this.getSelectedOptions(depth);
	if (null != group)
	{
		for (var i=0; i<group.size; ++i)
		{
			if (group.options[i].value == value)
			{
				this.setSelectedIndex(depth, i);
				this.getViewerOption(depth, i).selected = true;
								
				/*
				this.setInitValue(depth, value);
			
				for (var j=depth+1; j<this.getDepth(); ++j)
				{
					this.setInitValue(j, null);
				}
				*/
				
				break;
			}
		}	
	}
	this.populate(depth+1, true);
}


/*
 * populate() method --
 *	to calculate the proper records and have them showed in the viewers
 *
 *	depth		: the start depth to populate (default 0)
 *  isChanged	: a flag to indicate the given depth changed (default false)
 */
OptionManager.prototype.populate = function(depth, isGrpChanged)
{
	var fromDepth = 0;
	
	if (depth && !this.isInit())
	{
		if ((0 < depth) && (this.getDepth() > depth))
		{
			fromDepth = depth;
		}
		else if (this.getDepth() <= depth)
		{
			fromDepth = this.getDepth() - 1;
		}
	}
	
	isGrpChanged = ((isGrpChanged && (depth == fromDepth))? isGrpChanged : false) || this.isInit();
	var group = this.getSelectedOptions(fromDepth);
		
	for (var i=fromDepth; i<this.getDepth(); ++i)
	{
		var element = this.getViewer(i);
        var initValue = this.initValues[i];
		if (null == group)
		{
			for (var j=element.length-1; j>=0; --j)
			{
				element.options[j] = null;
			}
			break;
		}
		else if ("select-one" == element.type)
		{
			if (!isGrpChanged)
			{
				if (element.selectedIndex != this.getSelectedIndex(i))
				// && (0 <= element.selectedIndex)
				{
					this.setSelectedIndex(i, element.selectedIndex);
					isGrpChanged = true;
				}
				//continue;
			}
			else
			{
				while (element.length > group.size)
				{
					element.options[element.length-1] = null;
				}
				
				var initDepth = 0;
				var elementSize = element.length;
				for (var j=0; j<group.size; ++j)
				{
					var optText = group.options[j].label;
					var optValue = group.options[j].value;
					
					if (j < elementSize)
					{
						element.options[j].text = optText;
						element.options[j].value = optValue;
					}
					else
					{		
						element.options[j] = new Option(optText, optValue);
					}

                    if ((this.isInit) && (optValue == initValue))
                    {
                        initDepth = j;
                    }
				} //end for j
				
				this.setSelectedIndex(i, initDepth);
				element.options[initDepth].selected = true;				
			} //end else
		}
		group = group.options[this.getSelectedIndex(i)].child;
	} //end for
    this.setInit(false);
}

/* OptGroup --
 *	OptGroup initialization
 */
function OptGroup()
{
	this.options = new Array();
	this.size = 0;
	//this.selectedIdx = 0;
	this.parent = null;
}

/*
 * add() method --
 *	to add a record to the option group
 */
OptGroup.prototype.add = function(label, value, name)
{
	this.options[this.size++] = new OptElement(label, value, name);
}

/*
 * get() method --
 *	to get a record by the given name. If the name is not found, return the last
 *	record by default
 *
 *	name	: the record's name to be found
 */
OptGroup.prototype.get = function(name)
{
	if ((null == name) || ("" == name) || (0 == this.size))
	{
		return this.getLast();
	}
	else
	{
		for (var i=0; i<this.size; ++i)
		{
			if ((i == this.size-1) || (name == this.options[i].name))
			{
				return this.options[i];
			}
		}
	}
}

/*
 * getLast() method --
 *	to get the last record of the option group
 */
OptGroup.prototype.getLast = function()
{
	if (0 < this.size)
 	{
		return this.options[this.size-1];
  	}
   	else
	{
 		return null;
   	}
}

/*
 * getFirst() method --
 *	to get the first record of the option group
 */
OptGroup.prototype.getFirst = function()
{
	if (0 < this.size)
	{
		return this.options[0];
  	}
    else
	{
 		return null;
   	}
}

/* OptElement --
 *	OptElement initialization
 *
 *	label	: the displayed label (Required)
 *	value	: the associated value. If not given, use the given label as the value
 *	name	: the element name. If not given, use the value as the name
 */
function OptElement(label, value, name)
{
	this.label = label;
	this.value = value? value : label;
	this.name = name? name : this.value;
	this.child = null;
}

/*
 * newSubGroup() method --
 *	to get the option element's sub-group if found, or create a new one to return
 */
OptElement.prototype.newSubGroup = function()
{
	if (null == this.child)
	{
		var group = new OptGroup();
		this.child = group;
		this.child.parent = this;
	}
	return this.child;
}
