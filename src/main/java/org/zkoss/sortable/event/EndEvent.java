package org.zkoss.sortable.event;

import org.zkoss.sortable.Sortable;
import org.zkoss.sortable.SortableItem;
import org.zkoss.zk.au.AuRequest;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;

/**
 * Event fired when a {@link SortableItem} is dropped into the same {@link Sortable} it was dragged from.
 *
 * @author Sean Connolly
 */
public class EndEvent extends Event {

    public static EndEvent get(AuRequest request) {
        return new EndEvent(request.getCommand(), request.getComponent(),
                SortableEvents.getOldIndex(request),
                SortableEvents.getNewIndex(request));
    }

    private final int oldIndex;
    private final int newIndex;

    public EndEvent(String name, Component target, int oldIndex, int newIndex) {
        super(name, target);
        this.oldIndex = oldIndex;
        this.newIndex = newIndex;
    }

    public int getOldIndex() {
        return oldIndex;
    }

    public int getNewIndex() {
        return newIndex;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + "{oldIndex:" + oldIndex + ",newIndex:" + newIndex + "}";
    }

}
