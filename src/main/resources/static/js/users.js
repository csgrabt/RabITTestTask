window.onload = function () {
    //alert("Alma");
    console.log("Hello");


    let url = 'http://localhost:8080/api/users';
    fetch(url)
        .then(function (response) {
            return response.json();
        })
        .then(function (jsonData) {
            console.log(jsonData);

            let ul = document.querySelector("#users-ul")
            ul.innerHTML += "Usernames";
            for (let user of jsonData) {
                let row = "<li>" + user.fullName + "</li>"
                ul.innerHTML += row;
            }


        })


}