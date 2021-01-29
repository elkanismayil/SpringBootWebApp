jQuery(function() {
    $('.table #editAnchorTag').on('click',function (event) {
        const href = $(this).attr('href');
        $.get(href,function (user,status) {
            $('#emailEdit').val(user.email);
            $('#firstNameEdit').val(user.firstName);
            $('#lastNameEdit').val(user.lastName);
        });

        $('#editModal').modal();

        event.preventDefault();

    });

});

// jQuery(function() {
//     $('#editModal').on('show.bs.modal', function (event) {
//         const button = $(event.relatedTarget) // Button that triggered the modal
//         var recipient = button.data('whatever') // Extract info from data-* attributes
//         // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
//         // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
//         var modal = $(this)
//         modal.find('.modal-title').text('New message to ' + recipient)
//         modal.find('.modal-body input').val(recipient)
//     })
// })
