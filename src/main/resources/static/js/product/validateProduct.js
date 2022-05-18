import { setError, setSuccess } from "../utils/validationFeedback.js";

const name = document.getElementById('name');
const stock = document.getElementById('stock');
const price = document.getElementById('price');
const description = document.getElementById('description');
const image = document.getElementById('image');
const imageFile = document.getElementById('image_file');

export function validateFields(isEditForm) {
    let isValid = true;

    const nameVal = name.value.trim();
    const stockVal = stock.value;
    const priceVal = price.value;
    const descriptionVal = description.value.trim();
    const imageFileVal = imageFile.files;

    if (nameVal === '') {
        setError(name, 'Name is required.');
        isValid = false;
    } else if (nameVal.length > 45 || nameVal.length < 4) {
        setError(name, 'Name must be between 4 and 45 characters');
        isValid = false;
    } else {
        setSuccess(name);
    }

    if (stockVal === '') {
        setError(stock, 'Stock number is required.');
        isValid = false;
    } else if (stockVal < 1) {
        setError(stock, 'At least one product is required');
        isValid = false;
    } else {
        setSuccess(stock);
    }

    if (priceVal === '') {
        setError(price, 'Price is required.');
        isValid = false;
    } else if (priceVal < 10) {
        setError(price, 'Price must at least 10$');
        isValid = false;
    } else {
        setSuccess(price);
    }


    if (descriptionVal === '') {
        setError(description, 'Description is required.');
        isValid = false;
    } else if (descriptionVal.length > 300 || descriptionVal.length < 10) {
        setError(description, 'Must be between 10 and 300 characters');
        isValid = false;
    } else {
        setSuccess(description);
    }

    if (!isEditForm) {
        if (imageFileVal.length === 0) {
            setError(imageFile, 'Image is required.');
            isValid = false;
        } else {
            setSuccess(imageFile);
            image.value = imageFileVal[0].name;
        }
    }

    if (isEditForm && imageFileVal.length !== 0) {
        image.value = imageFileVal[0].name;
    }


    return isValid;

}