import { postCreateRequest, postEditRequest } from '../utils/crudApi.js';
import { validateFields } from './validateProduct.js';

const newProductForm = document.getElementById('new_product_form');
const BASE_URL = window.location.origin + "/products";

//NEW PRODUCT FORM
if (newProductForm != null) {
    newProductForm.addEventListener('submit', e => {
        e.preventDefault();

        if (validateFields()) {
            postCreateRequest(newProductForm, BASE_URL)
        }
    });
}