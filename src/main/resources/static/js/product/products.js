import { postDeleteRequest } from "../utils/crudApi.js";

const deleteBtns = document.getElementsByClassName('delete-btn');

const BASE_URL = window.location.origin + "/products";

//HANDLE DELETE BUTTONS
for (let i = 0; i < deleteBtns.length; i++) {
    const btn = deleteBtns[i];

    btn.addEventListener('click', e => {
        e.preventDefault();

        swal({
            title: "Are you sure?",
            text: "You will not be able to recover this product",
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

                    swal("Product has been deleted!", {
                        icon: "success",
                    });
                } else {
                    swal("Product is still here.");
                }
            });
    })
}