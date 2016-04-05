package org.zkoss.sortable.event;

import org.zkoss.sortable.Sortable;
import org.zkoss.sortable.SortableItem;
import org.zkoss.zk.au.AuRequest;
import org.zkoss.zk.au.AuRequests;
import org.zkoss.zk.ui.Component;

/**
 * @author Sean Connolly
 */
public final class SortableEvents {

    public static final String ON_START = "onStart";

    public static final String ON_END = "onEnd";

    public static final String ON_ADD = "onAdd";

    public static final String ON_REMOVE = "onRemove";

    public static final String ON_UPDATE = "onUpdate";

    public static final String ON_SORT = "onSort";

    public static final String ON_FILTER = "onFilter";

    static int getOldIndex(AuRequest request) {
        return getInt(request, "oldIndex");
    }

    static int getNewIndex(AuRequest request) {
        return getInt(request, "newIndex");
    }

    private static int getInt(AuRequest request, String key) {
        return AuRequests.getInt(request.getData(), key, -1);
    }

    static SortableItem getItem(AuRequest request) {
        return getSortableItem(request, "item");
    }

    private static SortableItem getSortableItem(AuRequest request, String key) {
        Component component = getComponent(request, key);
        if (component != null && SortableItem.class.isAssignableFrom(component.getClass())) {
            return (SortableItem) component;
        } else {
            return null;
        }
    }

    static Sortable getFrom(AuRequest request) {
        return getSortable(request, "from");
    }

    private static Sortable getSortable(AuRequest request, String key) {
        Component component = getComponent(request, key);
        if (component != null && Sortable.class.isAssignableFrom(component.getClass())) {
            return (Sortable) component;
        } else {
            return null;
        }
    }


    private static Component getComponent(AuRequest request, String key) {
        Object value = request.getData().get(key);
        if (value != null && value instanceof String) {
            String uuid = (String) value;
            return request.getDesktop().getComponentByUuid(uuid);
        }
        return null;
    }
}
