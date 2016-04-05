package org.zkoss.sortable.event;

import org.zkoss.sortable.Sortable;
import org.zkoss.sortable.SortableItem;
import org.zkoss.zk.au.AuRequest;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;

/**
 * Event fired when a {@link SortableItem} is added to a {@link Sortable}.
 *
 * @author Sean Connolly
 */
public class AddEvent extends Event {

    public static AddEvent get(AuRequest request) {
        return new AddEvent(request.getCommand(), request.getComponent(),
                SortableEvents.getOldIndex(request),
                SortableEvents.getNewIndex(request),
                SortableEvents.getItem(request),
                SortableEvents.getFrom(request));
    }

    private final int oldIndex;
    private final int newIndex;
    private final Component item;
    private final Sortable from;

    public AddEvent(String name, Component target, int oldIndex, int newIndex, Component item, Sortable from) {
        super(name, target);
        this.oldIndex = oldIndex;
        this.newIndex = newIndex;
        this.item = item;
        this.from = from;
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

    public Sortable getFrom() {
        return from;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + "{oldIndex:" + oldIndex + ",newIndex:" + newIndex + ",item:" + item + ",from:" + from + "}";
    }

}
