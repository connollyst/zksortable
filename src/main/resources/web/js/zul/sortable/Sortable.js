zul.sortable.Sortable = zk.$extends(zk.Widget, {
    bind_: function () {
        this.$supers(zul.sortable.Sortable, 'bind_', arguments);
        var config = {
            // TODO settings
        };
        $('#' + this.uuid).sortable(config);
    }
});