package org.zkoss.sortable.event;

import org.zkoss.sortable.SortableItem;
import org.zkoss.zk.au.AuRequest;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;

/**
 * Event fired when a {@link SortableItem} starts to be dragged.
 *
 * @author Sean Connolly
 */
public class StartEvent extends Event {

    public static StartEvent get(AuRequest request) {
        return new StartEvent(request.getCommand(), request.getComponent(),
                SortableEvents.getOldIndex(request));
    }

    private final int oldIndex;

    public StartEvent(String name, Component target, int oldIndex) {
        super(name, target);
        this.oldIndex = oldIndex;
    }

    public int getOldIndex() {
        return oldIndex;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + "{oldIndex:" + oldIndex + "}";
    }

}
