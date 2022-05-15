import {validateFields} from './validateCustomer.js';
import {postAddCustomer, postEditCustomer} from './customerAPI.js';

const newCustomerForm = document.getElementById('new_customer_form');
const editCustomerForm = document.getElementById('edit_customer_form');

if(newCustomerForm != null){
    newCustomerForm.addEventListener('submit', e => {
        e.preventDefault();
    
        
        if (validateFields()) {
            postAddCustomer(newCustomerForm);
        }
    });
}

if(editCustomerForm != null){
    editCustomerForm.addEventListener('submit', e => {
        e.preventDefault();

        if(validateFields()){
            let customerId = document.getElementById('customer_id').value;
            postEditCustomer(customerId, editCustomerForm);
        }
    })
}

