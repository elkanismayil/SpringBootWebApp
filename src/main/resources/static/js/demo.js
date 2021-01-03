function myFunction() {
    let td, i, txtValue;
    const input = document.querySelector("#myInput");
    const filter = input.value.toUpperCase();
    const table = document.querySelector("#myTable");
    const tr = table.getElementsByTagName('TR');

    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName('TD')[0];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}