package gov.dnt.tame.common;

public class LabelValueBean
{
    private String label;
    private String valuess;

	public LabelValueBean()
	{
	}

	public LabelValueBean(String valuess,String label)
	{
		this.valuess=valuess;
		this.label=label;
	}

    public String getLabel()
	{
        return this.label;
    }

    public void setLabel(String label)
	{
        this.label = label;
    }

    public String getValuess()
	{
        return this.valuess;
    }

    public void setValuess(String valuess)
	{
        this.valuess = valuess;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("LabelValueBean[");
        sb.append(this.label);
        sb.append(", ");
        sb.append(this.valuess);
        sb.append("]");
        return (sb.toString());
    }
}