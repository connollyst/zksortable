package org.zkoss.sortable.event;

import org.zkoss.sortable.SortableItem;
import org.zkoss.zk.au.AuRequest;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;

/**
 * Event fired when attempting to drag a filtered {@link SortableItem}.
 *
 * @author Sean Connolly
 */
public class FilterEvent extends Event {

    public static FilterEvent get(AuRequest request) {
        return new FilterEvent(request.getCommand(), request.getComponent(), SortableEvents.getItem(request));
    }

    private final SortableItem item;

    public FilterEvent(String name, Component target, SortableItem item) {
        super(name, target);
        this.item = item;
    }


    public SortableItem getItem() {
        return item;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{item:" + item + "}";
    }

}
