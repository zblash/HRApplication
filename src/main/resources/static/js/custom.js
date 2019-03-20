$(document).ready(function () {

    $("#addapplicant").submit(function (event) {

        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {
    var form = $('#addapplicant')[0];
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    var data = new FormData(form);

    $.ajax({
        type: "POST",
        beforeSend: function(request) {
            request.setRequestHeader(header, token);
        },
        enctype: 'multipart/form-data',
        url: "/applicant/form",
        processData: false,
        contentType: false,
        cache: false,
        data: data,
        timeout: 600000,
        success: function (data) {
            alert(data.responseText);
            $('#addapplicant')[0].reset();
        },
        error: function (e) {
            alert(e.responseText)

        }
    });

}