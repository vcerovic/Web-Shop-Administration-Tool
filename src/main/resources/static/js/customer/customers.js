import { postDeleteCustomer } from "./customerAPI.js";

const deleteBtns = document.getElementsByClassName('delete-btn');

for (let i = 0; i < deleteBtns.length; i++) {
    const btn = deleteBtns[i];

    btn.addEventListener('click', e => {
        e.preventDefault();

        swal({
            title: "Are you sure?",
            text: "You will not be able to recover this customer",
            icon: "warning",
            buttons: true,
            cancel: {
                text: "Cancel",
              },
              confirm: {
                text: "Yes",
              },
            dangerMode: true,
        })
            .then((willDelete) => {
                if (willDelete) {
                    postDeleteCustomer(btn.href);

                    swal("Customer has been deleted!", {
                        icon: "success",
                    });
                } else {
                    swal("Customer is still here.");
                }
            });
    })
}






