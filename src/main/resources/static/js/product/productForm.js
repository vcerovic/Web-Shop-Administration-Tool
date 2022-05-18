import { postCreateRequest, postEditRequest } from '../utils/crudApi.js';
import { validateFields } from './validateProduct.js';

const newProductForm = document.getElementById('new_product_form');
const editProductForm = document.getElementById('edit_product_form');
const BASE_URL = window.location.origin + "/products";

//NEW PRODUCT FORM
if (newProductForm != null) {
    newProductForm.addEventListener('submit', e => {
        e.preventDefault();

        if (validateFields(false)) {
            postCreateRequest(newProductForm, BASE_URL)
        }
    });
}


//EDIT PRODUCT FORM
if (editProductForm != null) {
    editProductForm.addEventListener('submit', e => {
        e.preventDefault();

        if (validateFields(true)) {
            let productId = document.getElementById('product_id').value;
            postEditRequest(productId, editProductForm, BASE_URL);
        }
    })
}