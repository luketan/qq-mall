/**
 * Created by Dayong on 16/2/24.
 */

//菜单处理
$('#main-nav .menu_header').click(function () {
    $('.menu_header').addClass('collapsed');
    $('.menu_header').each(function (n, d) {
        $(this).next().removeClass('in');
    });
    $(this).removeClass('collapsed');
    $(this).next().addClass('in');
});
$('#main-nav a').click(function () {
    $('#main-nav a').each(function (n, d) {
        $(this).parent().removeClass('active');
    });
    $(this).parent().addClass('active');
});