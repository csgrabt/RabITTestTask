window.onload = function () {
    //alert("Alma");
    console.log("Hello");


    let url = 'http://localhost:8080/api/advertisements';
    fetch(url,)
        .then(function (response) {
            return response.json();
        })
        .then(function (jsonData) {
            console.log(jsonData);

            let ul = document.querySelector("#advertisements-ul")

            for (let advertisements of jsonData) {
                let row = "<li>" + "Title: " + advertisements.title + ";   " + " Username: " + advertisements.userName + "</li>"
                ul.innerHTML += row;
            }


        })


}