zul.sortable.SortableItem = zk.$extends(zk.Widget, {
    bind_: function () {
        this.$supers(zul.sortable.SortableItem, 'bind_', arguments);
    }
});