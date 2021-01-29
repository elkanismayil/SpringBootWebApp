function myFunction() {
    $(function () {
        $("#myInput").on("keyup", function () {
            const value = $(this).val().toLowerCase();
            $("#myTable #myTr").filter(function () {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        });
    });

}

$(function() {

    $('.table #myEditBtn').on('click',function(event){

        event.preventDefault();

        const href= $(this).attr('href');

        $.get(href, function(user, status){
            $('#idEdit').val(user.id);
            $('#emailEdit').val(user.email);
            $('#passwordEdit').val(user.password);
            $('#firstNameEdit').val(user.firstName);
            $('#lastNameEdit').val(user.lastName.substr(0,10));
        });

        $('#editModal').modal();

    });

    $('.table #myDelBtn').on('click',function(event) {
        event.preventDefault();
        const href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();

    });

});
