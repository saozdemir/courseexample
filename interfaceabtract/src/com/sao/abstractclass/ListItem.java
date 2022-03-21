package com.sao.abstractclass;

import java.util.List;

public abstract class ListItem {
    protected ListItem rightLink = null;
    protected ListItem leftLink = null;
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    public abstract ListItem next();

    public abstract ListItem setNext(ListItem item);

    public abstract ListItem previous();

    public abstract ListItem setPrevious(ListItem item);

    public abstract int compareTo(ListItem item);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
