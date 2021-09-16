window.onload = function () {


    let button = document.querySelector("#create-button")
    let input = document.querySelector("#name-input")

    button.onclick = function () {
        let name = input.value;
        let data = {"fullName": name}
        let url = 'http://localhost:8080/api/users';
        fetch(url, {
            method: "POST",
            body: JSON.stringify(data),
            headers: {
                "Content-Type": "application/json"
            }
        })
            .then(function (Response) {
                    if (201 !== Response.status) alert("Something went wrong, User not created")
                    else alert("User has been created")
                }
            )
    };

}