package org.zkoss.sortable.event;

import org.zkoss.sortable.Sortable;
import org.zkoss.sortable.SortableItem;
import org.zkoss.zk.au.AuRequest;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;

/**
 * Event fired when sorting within a {@link Sortable} changes.
 *
 * @author Sean Connolly
 */
public class UpdateEvent extends Event {

    public static UpdateEvent get(AuRequest request) {
        return new UpdateEvent(request.getCommand(), request.getComponent(),
                SortableEvents.getOldIndex(request),
                SortableEvents.getNewIndex(request),
                SortableEvents.getItem(request));
    }

    private final int oldIndex;
    private final int newIndex;
    private final SortableItem item;

    public UpdateEvent(String name, Component target, int oldIndex, int newIndex, SortableItem item) {
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

    public SortableItem getItem() {
        return item;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{oldIndex:" + oldIndex + ",newIndex:" + newIndex + ",item:" + item + "}";
    }

}
