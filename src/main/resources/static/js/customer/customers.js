import { postDeleteRequest } from "../utils/crudApi.js";

const deleteBtns = document.getElementsByClassName('delete-btn');

const BASE_URL = window.location.origin + "/customers";

//HANDLE DELETE BUTTONS
for (let i = 0; i < deleteBtns.length; i++) {
    const btn = deleteBtns[i];

    btn.addEventListener('click', e => {
        e.preventDefault();

        swal({
            title: "Are you sure?",
            text: "All of this customer's purchases will be deleted.",
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
                    postDeleteRequest(btn.href, BASE_URL);

                    swal("Customer has been deleted!", {
                        icon: "success",
                    });
                } else {
                    swal("Customer is still here.");
                }
            });
    })
}






