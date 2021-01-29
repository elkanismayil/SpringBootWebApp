const exampleModal = document.getElementById('myModal')
const email = document.getElementById('email')
const firstName = document.getElementById('firstName')
const lastName = document.getElementById('lastName')
const password = document.getElementById('password')

exampleModal.addEventListener('shown.bs.modal', function () {
    email.focus()
    firstName.focus()
    lastName.focus()
    password.focus()
})