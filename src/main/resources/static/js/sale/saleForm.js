import { postCreateRequest } from '../utils/crudApi.js';

const newSaleForm = document.getElementById('new_sale_form');
const BASE_URL = window.location.origin + "/sales";


//NEW SALE FORM
if (newSaleForm != null) {
    newSaleForm.addEventListener('submit', e => {
        e.preventDefault();

        postCreateRequest(newSaleForm, BASE_URL)
    });
}
