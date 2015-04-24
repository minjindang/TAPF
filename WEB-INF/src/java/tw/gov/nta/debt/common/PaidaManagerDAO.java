package tw.gov.nta.debt.common;

import gov.dnt.tame.common.LabelValueBean;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.MapListHandler;

import com.kangdainfo.ast.dao.DAOException;
import com.kangdainfo.ast.dao.SQLRunnerDAOImpl;
import com.kangdainfo.ast.sql.SQLJob;

public class PaidaManagerDAO extends SQLRunnerDAOImpl {
	

	private Connection connection = null;

    public PaidaManagerDAO(Connection connection)
    {
        super(connection);
        this.connection = connection;
    }
	
	protected static SQLJob getPaidaBondID(){					
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select distinct BOND_ID ");
		sqljob.appendSQL("from PAIDA ");
		sqljob.appendSQL("WHERE 1=1 ");
		sqljob.appendSQL("and substring(bond_id,4,1) between 1 and 4 ");
		sqljob.appendSQL("group by BOND_ID ");
		sqljob.appendSQL("order by BOND_ID ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	protected static SQLJob getPaidaBondID(String bondID){					
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select distinct BOND_ID ");
		sqljob.appendSQL("from PAIDA ");
		sqljob.appendSQL("WHERE 1=1 ");
		sqljob.appendSQL("and substring(bond_id,4,1) between 1 and 4 ");
		sqljob.appendSQL("and BOND_ID="+bondID+" ");
		sqljob.appendSQL("group by BOND_ID ");
		sqljob.appendSQL("order by BOND_ID ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	/**
	 * 取得CombinText List
	 * 
	 * @return List<LabelValueBean>
	 * @throws SQLException
	 */
	public List<LabelValueBean> getPaidaNameLabelList() throws DAOException
	{
		SQLJob job =  getPaidaBondID();
		List list = (List) query(job,new MapListHandler());
		List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
		if(list!=null)
        {
            for (Iterator it = list.iterator(); it.hasNext();)
            {
            	Map tMap =(Map) it.next();
            	LabelValueBean labelValueBean = new LabelValueBean();
            	String bondID = (String)tMap.get("BOND_ID");
            	String bondName = "";
            	labelValueBean.setValuess(bondID);
            	switch (Integer.parseInt(bondID.substring(3,4))){
    			case 1:
    				bondName = "中央政府公債 " + Integer.parseInt(bondID.substring(1,3)) + " 年甲類第 " + Integer.parseInt(bondID.substring(4,6)) + " 期";
    				break;
    			case 2:
    				bondName = "中央政府公債 " + Integer.parseInt(bondID.substring(1,3)) + " 年乙類第 " + Integer.parseInt(bondID.substring(4,6)) + " 期";
    				break;
    			case 3:
    				bondName = "中央政府公債 " + Integer.parseInt(bondID.substring(1,3)) + " 年重大交通建設甲類第" + Integer.parseInt(bondID.substring(4,6)) + " 期";
    				break;
    			case 4:
    				bondName = "中央政府公債 " + Integer.parseInt(bondID.substring(1,3)) + " 年重大交通建設乙類第" + Integer.parseInt(bondID.substring(4,6)) + " 期";
    				break;
    			}
            	labelValueBean.setLabel(bondName);
            	labelValueBeanList.add(labelValueBean);
            }
        }
        return labelValueBeanList;
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
