const form = document.getElementById('customer_form');
const BASE_URL = window.location.origin;

//ADD CUSTOMER
export async function postAddCustomer (){
    const formData = new FormData(form);

    try {
        const response = await axios.post(`${BASE_URL}/customers`, formData, {
            headers: {
                "Content-Type": "multipart/form-data",
            },
        });

        alert(response.data);

        window.location.replace(`${BASE_URL}/customers`);

    } catch (error) {
        if (error.response) {
            console.log(error.response.status)
        } else {
            console.log(error.message)
        }
    }
}