import { setError, setSuccess } from "../utils/validationFeedback.js";

const full_name = document.getElementById('name');
const email = document.getElementById('email');
const address = document.getElementById('address');


const isValidEmail = email => {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

export function validateFields(){
    let isValid = true;
    let nameVal = full_name.value.trim();
    let emailVal = email.value.trim();
    let addressVal = address.value.trim();

    if (nameVal === '') {
        setError(full_name, 'Name is required.');
        isValid = false;
    } else if (nameVal.length > 15 || nameVal.length < 4) {
        setError(full_name, 'Name must be between 4 and 15 characters');
        isValid = false;
    } else {
        setSuccess(full_name);
    }

    if (emailVal === '') {
        setError(email, 'Email is required');
        isValid = false;
    } else if (emailVal.length > 60 ) {
        setError(email, 'Email can only be 60 characters long.');
        isValid = false;
    } else if (!isValidEmail(emailVal)) {
        setError(email, 'Provide a valid email address');
        isValid = false;
    } else {
        setSuccess(email);
    }

    if (addressVal === '') {
        setError(address, 'Address is required.');
        isValid = false;
    } else if (addressVal.length > 30 || addressVal.length < 4) {
        setError(address, 'Address must be between 4 and 30 characters');
        isValid = false;
    } else {
        setSuccess(address);
    }

    return isValid;
}