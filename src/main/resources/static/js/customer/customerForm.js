import {validateFields} from './validateCustomer.js';
import {postAddCustomer} from './customerAPI.js';

const form = document.getElementById('customer_form');


form.addEventListener('submit', e => {
    e.preventDefault();

    
    if (validateFields()) {
        postAddCustomer(form);
    }
});
