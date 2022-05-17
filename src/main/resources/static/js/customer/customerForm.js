import { validateFields } from './validateCustomer.js';
import { postCreateRequest, postEditRequest } from '../utils/crudApi.js';

const newCustomerForm = document.getElementById('new_customer_form');
const editCustomerForm = document.getElementById('edit_customer_form');

const BASE_URL = window.location.origin + "/customers";


//NEW CUSTOMER FORM
if (newCustomerForm != null) {
    newCustomerForm.addEventListener('submit', e => {
        e.preventDefault();

        if (validateFields()) {
            postCreateRequest(newCustomerForm, BASE_URL);
        }
    });
}

//EDIT CUSTOMER FORM
if (editCustomerForm != null) {
    editCustomerForm.addEventListener('submit', e => {
        e.preventDefault();

        if (validateFields()) {
            let customerId = document.getElementById('customer_id').value;
            postEditRequest(customerId, editCustomerForm, BASE_URL);
        }
    })
}

