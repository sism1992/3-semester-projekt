$(document).ready(function () {

    var id;

    $('.card').on('click',function(event) {
        event.preventDefault();
        var href = $(this).attr('href');

            $.get(href,function (menu,status) {

                $('.myModal #example-modal-label').text(menu.name);
                $('.myModal #row-description').text(menu.description);
                $('.myModal #row-price').text(menu.price);

                id = menu.id;

            });

            $('.myModal #example-modal').modal();
    })

    $('#submit-order').on('click', function(event){
        window.location = '../order/create/?id=' + id + '&quantity=' + $('#guest-count').val();
    })
});