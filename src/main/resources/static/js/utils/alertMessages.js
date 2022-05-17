export function showSuccessMessageAndRedirect(message, redirect) {
    swal({
        title: "Good job!",
        text: message,
        icon: "success",
    }).then(() => {
            window.location.replace(redirect);
    })
}

export function showErrorMessage(message){
    swal({
        title: "Something went wrong...",
        text: message,
        icon: "error",
      });
}
