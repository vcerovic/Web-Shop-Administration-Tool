export function showSuccessMessageAndRedirect(message, BASE_URL) {
    swal({
        title: "Good job!",
        text: message,
        icon: "success",
    }).then(() => {
        window.location.replace(`${BASE_URL}/customers`);
    })
}

export function showErrorMessage(message){
    swal({
        title: "Something went wrong...",
        text: message,
        icon: "error",
      });
}
