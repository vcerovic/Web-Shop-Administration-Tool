const form = document.getElementById('customer_form');

const full_name = document.getElementById('name');
const email = document.getElementById('email');
const address = document.getElementById('address');


form.addEventListener('submit', e => {
    e.preventDefault();

    validateFields();
});

const setError = (element, message) => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = message;
    inputControl.classList.add('error');
    inputControl.classList.remove('success')
}

const setSuccess = element => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = '';
    inputControl.classList.add('success');
    inputControl.classList.remove('error');
};

const isValidEmail = email => {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

const validateFields = () => {
    let nameVal = full_name.value.trim();
    let emailVal = email.value.trim();
    let addressVal = address.value.trim();

    if(nameVal === ''){
        setError(full_name, 'Name is required.');
    } else if(nameVal.length > 45){
        setError(full_name, 'Name can only be 45 characters long.');
    } else {
        setSuccess(full_name);
    }

    if(emailVal === '') {
        setError(email, 'Email is required');
    } else if (emailVal.length > 60){
        setError(email, 'Email can only be 60 characters long.');
    } else if (!isValidEmail(emailVal)) {
        setError(email, 'Provide a valid email address');
    } else {
        setSuccess(email);
    }

    if(addressVal === ''){
        setError(address, 'Address is required.');
    } else if(addressVal.length > 45){
        setError(address, 'Name can only be 45 characters long.');
    } else {
        setSuccess(address);
    }

}

