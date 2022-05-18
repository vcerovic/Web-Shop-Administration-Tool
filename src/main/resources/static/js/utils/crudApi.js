import { showSuccessMessageAndRedirect, showErrorMessage } from "./alertMessages.js";


//CREATE
export async function postCreateRequest(form, url) {
    const formData = new FormData(form);

    try {
        const response = await axios.post(url, formData, {
            headers: {
                "Content-Type": "multipart/form-data",
            },
        });

        showSuccessMessageAndRedirect(response.data, url);

    } catch (error) {
        console.log(error);
        showErrorMessage(error.response.data);
    }
}


//DELETE
export async function postDeleteRequest(url, redirect) {
    try {
        const response = await axios.delete(url);
        showSuccessMessageAndRedirect(response.data, redirect);

    } catch (error) {
        showErrorMessage(error.response.data);
    }
}


//UPDATE
export async function postEditRequest(id, form, url) {
    const formData = new FormData(form);

    try {
        const response = await axios.put(`${url}/${id}`, formData, {
            headers: {
                "Content-Type": "multipart/form-data",
            },
        });

        showSuccessMessageAndRedirect(response.data, url);

    } catch (error) {
        showErrorMessage(error.response.data);
    }
}
