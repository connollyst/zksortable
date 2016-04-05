package org.zkoss.sortable.event;

import org.zkoss.sortable.Sortable;
import org.zkoss.sortable.SortableItem;
import org.zkoss.zk.au.AuRequest;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;

/**
 * Event fired when a {@link SortableItem} is removed from a {@link Sortable}.
 *
 * @author Sean Connolly
 */
public class RemoveEvent extends Event {

    public static RemoveEvent get(AuRequest request) {
        return new RemoveEvent(request.getCommand(), request.getComponent(),
                SortableEvents.getOldIndex(request),
                SortableEvents.getNewIndex(request),
                SortableEvents.getItem(request));
    }

    private final int oldIndex;
    private final int newIndex;
    private final Component item;

    public RemoveEvent(String name, Component target, int oldIndex, int newIndex, Component item) {
        super(name, target);
        this.oldIndex = oldIndex;
        this.newIndex = newIndex;
        this.item = item;
    }

    public int getOldIndex() {
        return oldIndex;
    }

    public int getNewIndex() {
        return newIndex;
    }

    public Component getItem() {
        return item;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + "{oldIndex:" + oldIndex + ",newIndex:" + newIndex + ",item:" + item + "}";
    }

}
