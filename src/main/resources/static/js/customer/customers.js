import { postDeleteCustomer } from "./customerAPI.js";

const deleteBtns = document.getElementsByClassName('delete-btn');

for (let i = 0; i < deleteBtns.length; i++) {
    const btn = deleteBtns[i];

    btn.addEventListener('click', e => {
        e.preventDefault();

        if (window.confirm("Are you sure you want to delete this Customer?")) {
            postDeleteCustomer(btn.href);
        }         
    })
}






