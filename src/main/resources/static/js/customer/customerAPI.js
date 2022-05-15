import { showSuccessMessageAndRedirect, showErrorMessage } from "../utils/alertMessages.js";

const BASE_URL = window.location.origin;

//ADD CUSTOMER
export async function postAddCustomer(form) {
    const formData = new FormData(form);

    try {
        const response = await axios.post(`${BASE_URL}/customers`, formData, {
            headers: {
                "Content-Type": "multipart/form-data",
            },
        });

        showSuccessMessageAndRedirect(response.data, BASE_URL);

    } catch (error) {
        showErrorMessage(error.response.data);
    }
}

//DELETE CUSTOMER
export async function postDeleteCustomer(url) {
    try {
        const response = await axios.delete(url);
        showSuccessMessageAndRedirect(response.data, BASE_URL);

    } catch (error) {
        showErrorMessage(error.response.data);
    }
}

//EDIT CUSTOMER
export async function postEditCustomer(id, form) {
    const formData = new FormData(form);

    try {
        const response = await axios.put(`${BASE_URL}/customers/${id}`, formData, {
            headers: {
                "Content-Type": "multipart/form-data",
            },
        });

        showSuccessMessageAndRedirect(response.data, BASE_URL);

    } catch (error) {
        showErrorMessage(error.response.data);
    }
}


