$(document).ready(function() {

    $('#btn-submit').click(function(event) {
        event.preventDefault();
        $(this).addClass("disabled");
        // Store the original text to a data attribute
        $(this).attr("data-original",$(this).text());
        
        // Update the button text
        $(this).text('Đang xử lý...');
        
        var form = $('#form-product')[0];
        var data = new FormData(form);

        $.ajax({
            type : "POST",
            enctype : 'multipart/form-data',
            url : 'admin-sanpham-add',
            data : data,
            processData : false,
            contentType : false,
            cache : false,
            success : function(responseText) {
                alert(responseText);
                $('#btn-submit').text($('#btn-submit').attr("data-original"));
                $('#btn-submit').removeAttr("data-original");
                $('#btn-submit').removeClass("disabled");
            }
        });
    }); 
});

