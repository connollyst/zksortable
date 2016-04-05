zul.sortable.Sortable = zk.$extends(zk.Widget, {
    $define: {
        sortable: function (s) {
            var n = this.$n();
            if (n)
                s.sortable = s;
        },
        _group: null,
        _animation: null,
        _draggable: null,
        _handle: null
    },
    bind_: function () {
        this.$supers(zul.sortable.Sortable, 'bind_', arguments);
        var widget = this;
        var config = {
            group: this.__group,
            animation: this.__animation,
            draggable: this.__draggable,
            handle: this.__handle,
            // dragging started
            onStart: function (event) {
                widget.fire('onStart', {
                    oldIndex: event.oldIndex
                });
            },
            // dragging ended
            onEnd: function (event) {
                widget.fire('onEnd', {
                    oldIndex: event.oldIndex,
                    newIndex: event.newIndex
                });
            },
            // Element is dropped into the list from another list
            onAdd: function (event) {
                widget.fire('onAdd', {
                    oldIndex: event.oldIndex,
                    newIndex: event.newIndex,
                    item: event.item.id,
                    from: event.from.id
                });
            },
            // Changed sorting within list
            onUpdate: function (event) {
                widget.fire('onUpdate', {
                    oldIndex: event.oldIndex,
                    newIndex: event.newIndex,
                    item: event.item.id
                });
            },
            // Called by any change to the list (add / update / remove)
            onSort: function (event) {
                widget.fire('onSort', {
                    oldIndex: event.oldIndex,
                    newIndex: event.newIndex,
                    item: event.item.id
                });
            },
            // Element is removed from the list into another list
            onRemove: function (event) {
                widget.fire('onRemove', {
                    oldIndex: event.oldIndex,
                    newIndex: event.newIndex,
                    item: event.item.id
                });
            },
            // Attempt to drag a filtered element
            onFilter: function (event) {
                widget.fire('onFilter', {
                    item: event.item.id
                });
            }
        };
        for (var c in config) {
            if (config.hasOwnProperty(c) && (config[c] === null || config[c] === undefined)) {
                delete config[c];
            }
        }
        this.setSortable(
            $('#' + this.uuid).sortable(config)
        );
    }
});