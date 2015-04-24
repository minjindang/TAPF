package gov.dnt.tame.sys;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.handlers.MapListHandler;
import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;
import com.kangdainfo.ast.webmenu.loader.DatabaseMenuLoader;
import com.kangdainfo.ast.webmenu.menu.Menu;
import com.kangdainfo.ast.webmenu.menu.MenuComponent;
import com.kangdainfo.ast.webmenu.menu.MenuContainer;
import com.kangdainfo.ast.webmenu.menu.MenuItem;

public class DefaultMenuLoader extends DatabaseMenuLoader
{
    private static final String MENU_ITEM_TYPE = "2";

    private static final String DISABLE_STRING = "N";

    private static int nameCount = 0;
    
    private static final StringBuffer TOP_MENU_SQL = new StringBuffer("SELECT id, path as name, name as label,PATH as action, STATE, '0' as type FROM PM0001_DB WHERE STATE='Y'                ORDER BY ID");
    private static final StringBuffer SUB_MENU_SQL = new StringBuffer("SELECT id, PATH as name, name as label,PATH as action, STATE, '1' as type FROM PM0002_DB WHERE STATE='Y' AND PM0001ID=? ORDER BY ID");
    private static final StringBuffer DET_MENU_SQL = new StringBuffer("SELECT id, PATH as name, name as label,PATH as action, STATE, '2' as type FROM PM0003_DB WHERE STATE='Y' AND PM0002ID=? ORDER BY ID");

    /**
     * @param connection
     */
    protected DefaultMenuLoader(Connection connection)
    {
        super(connection);
    }

    protected MenuComponent createMenuItem(Map props)
    {
        MenuItem item;
        if (MENU_ITEM_TYPE.equals((String) props.get("type"))) //MenuItem
            item = new MenuItem();
        else
            item = new Menu();

        item.setId(Integer.parseInt(props.get("id").toString()));
        item.setLevel(Integer.parseInt(props.get("type").toString()));
        item.setName((String) props.get("name"));
        item.setLabel((String) props.get("label"));
        item.setActionURL((String) props.get("action"));
        item.setEnabled(!(DISABLE_STRING.equalsIgnoreCase((String) props.get("STATE"))));
        item.setProperty("id", props.get("type").toString()+"-"+props.get("id").toString());
        item.setMenuContext(this.getMenuContext());

        return (MenuComponent) item;
    }

    protected MenuComponent[] createMenusImpl(SQLJob job)
    {
        try
        {
            List<MenuComponent> menus = new ArrayList<MenuComponent>();
            SQLRunner run = new ConnectionSQLRunner(getConnection());
            List menuProps = (List) run.query(job, new MapListHandler());

            for (Iterator it = menuProps.iterator(); it.hasNext();)
            {
                menus.add(this.createMenuItem((Map) it.next()));
            }
            return (MenuComponent[]) menus.toArray(new MenuComponent[menus.size()]);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new MenuComponent[0];
    }

    protected MenuComponent[] createMenus()
    {
    	SQLJob job = new SQLJob(TOP_MENU_SQL.toString());
        return this.createMenusImpl(job);
    }

    protected MenuComponent[] createSubMenus(MenuContainer container)
    {
    	SQLJob job = new SQLJob((container.getLevel()==0)?SUB_MENU_SQL.toString():DET_MENU_SQL.toString());
        job.addParameter(new Integer(container.getId()));
        return this.createMenusImpl(job);
    }

    protected String constructName()
    {
        synchronized (this.getClass())
        {
            String name = this.getClass().getName();
            if (0 < nameCount++)
            {
                name += ("_" + nameCount);
            }
            return name;
        }
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof DefaultMenuLoader))
        {
            return false;
        }
        return super.equals(obj);
    }
}