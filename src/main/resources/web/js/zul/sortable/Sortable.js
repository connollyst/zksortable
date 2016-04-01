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
        console.log('_group:     ' +this.__group);
        console.log('_animation: ' +this.__animation);
        console.log('_draggable: ' +this.__draggable);
        console.log('_handle:    ' +this.__handle);
        var config = {
            group: this.__group,
            animation: this.__animation,
            draggable: this.__draggable,
            handle: this.__handle
        };
        this.setSortable(
            $('#' + this.uuid).sortable(config)
        );
    }
});