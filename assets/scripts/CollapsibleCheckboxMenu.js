function menuInit(parentId, toCollapse)
{
    var checkbox;
    var child;
    var menu;
    var checkboxes = xGetElementsByClassName('menu', xGetElementById(parentId), 'INPUT');
    var menus = xGetElementsByClassName('menu', xGetElementById(parentId), 'SPAN');
    var children = xGetElementsByClassName('collapsible', xGetElementById(parentId));
    
    var inputIdx = 0;
    for (var i=0; i<children.length; ++i)
    {
        while (inputIdx < checkboxes.length)
        {
            var element = checkboxes[inputIdx++];
            if ('checkbox' == element.type)
            {
                checkbox = element;
                break;
            }
        }
        
        menu = menus[i];
        child = children[i];
        if (checkbox && child && menu)
        {
            menu.onmouseover = menuOnMouseover;
            menu.onmouseout = menuOnMouseout;
            menu.child = child;
            menu.isCollapsed = toCollapse;
            menu.onclick = menuOnClick;
            menu.defaultColor = menu.style.color;
            
            checkbox.child = child;
            checkbox.onclick = checkboxOnClick;
        }
    }
}

function menuOnMouseover()
{
    if (this.tagName == 'SPAN')
    {
        this.style.color = 'blue';
    }
}

function menuOnMouseout()
{
    if (this.tagName == 'SPAN')
    {
        this.style.color = this.defaultColor;
    }
}

function menuOnClick()
{
    menuCollapse(this, this.isCollapsed);
}

function menuCollapse(menu, toExpand)
{
    var sDisplay;
    var sTitle;
    
    if (toExpand)
    {
        sDisplay = 'block';
        sTitle = 'Hide';
    }
    else
    {
        sDisplay = 'none';
        sTitle = 'Show';
    }
    
    if (menu.tagName == 'SPAN')
    {
        sTitle += ' submenus';
        menu.child.style.display = sDisplay;
    }
    
    menu.setAttribute('title', sTitle);
    menu.isCollapsed = !toExpand;
}

function checkboxOnClick()
{
    var checkboxes = xGetElementsByTagName('INPUT', this.child);
    for (var i=0; i < checkboxes.length; ++i)
    {
        var child = checkboxes[i];
        if ('checkbox' != child.type)
        {
            continue;
        }
        if (this.checked != child.checked)
        {
            child.click(); 
        }
    }
}