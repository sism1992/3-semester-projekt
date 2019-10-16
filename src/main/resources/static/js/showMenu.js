$(document).ready(function () {
    $('.table .eBtn').on('click',function(event) {
        event.preventDefault();
        var href = $(this).attr('href');

        $.get(href,function (menu,status) {
            $('.myModal #row-name').text(menu.name);
            $('.myModal #row-price').text(menu.price + 'DKK');
            $('.myModal #row-description').text(menu.description);
            $('.myModal #row-items').text(menu.items);
        });

        $('.myModal #example-modal').modal();
    })
});

