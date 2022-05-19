import { setError, setSuccess } from "../utils/validationFeedback.js";

const customerId = document.getElementById('customer_id');
const productId = document.getElementById('product_id');
const quantity = document.getElementById('quantity');


export function validateFields(isEditForm) {
    let isValid = true;

    const customerIdVal = customerId.value;
    const productIdVal = productId.value;
    const quantityVal = quantity.value;

    if (customerIdVal === '') {
        setError(customerId, 'Customer id is required.');
        isValid = false;
    } else if (customerIdVal < 1) {
        setError(customerId, "Customers with id below 1 don't exist.");
        isValid = false;
    } else {
        setSuccess(customerId);
    }

    if (productIdVal === '') {
        setError(productId, 'Product id is required.');
        isValid = false;
    } else if (productIdVal < 1) {
        setError(productId, "Products with id below 1 don't exist.");
        isValid = false;
    } else {
        setSuccess(productId);
    }

    if (quantityVal === '') {
        setError(quantity, 'Quantity id is required.');
        isValid = false;
    } else if (quantityVal < 1) {
        setError(quantity, "Quantity must be higher than 0");
        isValid = false;
    } else {
        setSuccess(quantity);
    }


    return isValid;
}