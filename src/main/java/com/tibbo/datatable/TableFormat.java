package com.tibbo.datatable;

import java.util.*;

public class TableFormat implements Cloneable {
    private List<FieldFormat> fields = new ArrayList<>();
    private int minRows = 0;
    private int maxRows = Integer.MAX_VALUE;


    public void addField(FieldFormat fieldFormat)
    {
        if(fields.size() < maxRows) {
            fields.add(fieldFormat);
        }
    }

    public boolean removeField(FieldFormat fieldFormat)
    {
        if( fields.size() > minRows) {
            return fields.remove(fieldFormat);
        }
        else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(o == null || this.getClass() != o.getClass()) {
            return false;
        }
        TableFormat tableFormat = (TableFormat)o;
        return fields.equals(tableFormat.fields);
                //(fields == tableFormat.fields || (fields != null && fields.equals(tableFormat.fields)) );
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (fields == null ? 0 : fields.hashCode());
        return result;
    }

    @Override
    public String toString() {
        String result;
        result = "fields: " + (fields == null ? "null" : fields.toString()) + ".";
        return result;
    }

    @Override
    public TableFormat clone() throws CloneNotSupportedException{
        return (TableFormat) super.clone();
    }
}
