$(function() {
  var lastsel;
  $('#feedProtocolList').jqGrid({
    url: appContext + '/action/feed/protocol/list',
    datatype: 'json',
    colNames:['Name','Description','Actions'],
    colModel:[
      {name:'feedProtocol.feedProtocolId',index:'feedProtocol.feedProtocolId',width:100,editable:false},
      {name:'feedProtocol.description',index:'feedProtocol.description',width:100},
      {name:'actions',index:'actions',width:50,sortable:false}
    ],
    caption: 'Feed Protocol List',
    rowNum: 10,
    rowList:[10,25,50],
    imgpath: appContext + '/styles/jqGrid/themes/green/images',
    pager: $('#pager'),
    sortname: 'name',
    sortorder: 'asc',
    width: 500,
    height: 150,
    loadComplete: function() {
      var ids = jQuery("#feedProtocolList").getDataIDs();
      for (var i = 0; i < ids.length; i++) {
        var row_id = ids[i];
        be = "<img title='edit_row' id='" + row_id + "' src='" + appContext + "/images/row_edit.gif' />";
        bd = "<img title='del_row' id='" + row_id + "' src='" + appContext + "/images/row_delete.gif' />";
        jQuery("#feedProtocolList").setRowData(ids[i], {actions:be + bd})
      }
      $('img[title=edit_row]').click(function() {
        window.location = appContext + "/action/feed/protocol/edit/" + this.id;
      });
      $('img[title=del_row]').click(function() {
        var id = this.id;

        confirmDelete("Really Delete?", function() {
          var params = {'feedProtocol.description':id};
          $.post(appContext + '/action/feed/protocol/delete/', params, function(data) {
            $('#feedProtocolList').delRowData(id);
          });
        });
      });
    }
  });
});

function confirmDelete(message, callback) {
  $('#confirm').modal({
    close:false,
    overlayId:'confirmModalOverlay',
    containerId:'confirmModalContainer',
    onShow: function (dialog) {
      dialog.data.find('.message').append(message);
			// if the user clicks "yes"
      dialog.data.find('.yes').click(function () {
        // call the callback
        if ($.isFunction(callback)) {
          callback.apply();
        }
				// close the dialog
        $.modal.close();
      });
    }
  });
}